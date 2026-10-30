package com.example.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.CompanyData
import com.example.data.ContactInquiry
import com.example.data.Project
import com.example.data.ServiceCategory
import com.example.ui.navigation.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

data class UiState(
  val currentScreen: Screen = Screen.Home,
  val backStack: List<Screen> = listOf(Screen.Home),
  val isQuoteModalVisible: Boolean = false,
  val selectedProjectCategory: String = "all",
  val faqSearchQuery: String = "",
  val selectedFaqCategory: String = "All",
  val isSubmittingInquiry: Boolean = false,
  val inquirySubmissionSuccess: Boolean = false,
  val submittedInquiries: List<ContactInquiry> = emptyList(),
  val userFeedbackMessage: String? = null,
  // Quote calculator state
  val quoteSelectedService: String = "App Development",
  val quoteTier: String = "Commercial Build",
  val quoteAddons: Set<String> = emptySet(),
  val prefilledContactService: String = "App Development",
  val prefilledProjectDescription: String = ""
)

class MainViewModel : ViewModel() {
  private val _uiState = MutableStateFlow(UiState())
  val uiState: StateFlow<UiState> = _uiState.asStateFlow()

  fun navigateTo(screen: Screen) {
    _uiState.update { state ->
      if (state.currentScreen == screen) {
        state
      } else {
        val newStack = if (screen == Screen.Home) {
          listOf(Screen.Home)
        } else {
          state.backStack + screen
        }
        state.copy(
          currentScreen = screen,
          backStack = newStack
        )
      }
    }
  }

  fun popBack(): Boolean {
    val state = _uiState.value
    if (state.backStack.size > 1) {
      val newStack = state.backStack.dropLast(1)
      val previousScreen = newStack.last()
      _uiState.update { it.copy(currentScreen = previousScreen, backStack = newStack) }
      return true
    } else if (state.currentScreen != Screen.Home) {
      _uiState.update { it.copy(currentScreen = Screen.Home, backStack = listOf(Screen.Home)) }
      return true
    }
    return false
  }

  fun setQuoteModalVisible(visible: Boolean) {
    _uiState.update { it.copy(isQuoteModalVisible = visible) }
  }

  fun setProjectCategoryFilter(category: String) {
    _uiState.update { it.copy(selectedProjectCategory = category) }
  }

  fun setFaqSearchQuery(query: String) {
    _uiState.update { it.copy(faqSearchQuery = query) }
  }

  fun setFaqCategory(category: String) {
    _uiState.update { it.copy(selectedFaqCategory = category) }
  }

  fun updateQuoteSelection(service: String, tier: String, addons: Set<String>) {
    _uiState.update {
      it.copy(
        quoteSelectedService = service,
        quoteTier = tier,
        quoteAddons = addons
      )
    }
  }

  fun transferQuoteToContact(service: String, summaryText: String) {
    _uiState.update {
      it.copy(
        isQuoteModalVisible = false,
        prefilledContactService = service,
        prefilledProjectDescription = summaryText
      )
    }
    navigateTo(Screen.Contact)
  }

  fun submitInquiry(
    name: String,
    email: String,
    phone: String,
    company: String,
    service: String,
    budget: String,
    description: String,
    onSuccess: () -> Unit
  ) {
    if (name.isBlank() || email.isBlank() || description.isBlank()) {
      _uiState.update { it.copy(userFeedbackMessage = "Please complete all required fields (Name, Email, Description).") }
      return
    }

    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches()) {
      _uiState.update { it.copy(userFeedbackMessage = "Please enter a valid email address.") }
      return
    }

    viewModelScope.launch {
      _uiState.update { it.copy(isSubmittingInquiry = true, userFeedbackMessage = null) }
      
      // Simulate real network validation and submission pipeline
      kotlinx.coroutines.delay(1000)

      val inquiry = ContactInquiry(
        id = UUID.randomUUID().toString(),
        name = name.trim(),
        email = email.trim(),
        phone = phone.trim(),
        company = company.trim(),
        serviceCategory = service,
        budgetRange = budget,
        projectDescription = description.trim()
      )

      _uiState.update { state ->
        state.copy(
          isSubmittingInquiry = false,
          inquirySubmissionSuccess = true,
          submittedInquiries = listOf(inquiry) + state.submittedInquiries,
          userFeedbackMessage = "Thank you! Your project inquiry has been received. Our team will review your specifications promptly."
        )
      }
      onSuccess()
    }
  }

  fun clearFeedbackMessage() {
    _uiState.update { it.copy(userFeedbackMessage = null) }
  }

  fun resetInquirySuccessState() {
    _uiState.update { it.copy(inquirySubmissionSuccess = false) }
  }

  fun getServiceBySlug(slug: String): ServiceCategory? {
    return CompanyData.SERVICES.find { it.slug == slug }
  }

  fun getProjectBySlug(slug: String): Project? {
    return CompanyData.PROJECTS.find { it.slug == slug }
  }
}
