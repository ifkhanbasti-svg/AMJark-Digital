package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui.components.AmjarkBottomNavigation
import com.example.ui.components.AmjarkNavigationMenuSheet
import com.example.ui.components.AmjarkTopAppBar
import com.example.ui.components.QuoteCalculatorDialog
import com.example.ui.navigation.Screen
import com.example.ui.screens.AboutScreen
import com.example.ui.screens.ContactScreen
import com.example.ui.screens.FaqScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PricingScreen
import com.example.ui.screens.PrivacyPolicyScreen
import com.example.ui.screens.ProcessScreen
import com.example.ui.screens.ProjectDetailScreen
import com.example.ui.screens.ProjectsScreen
import com.example.ui.screens.ServiceDetailScreen
import com.example.ui.screens.ServicesScreen
import com.example.ui.screens.TeamScreen
import com.example.ui.screens.TermsScreen
import com.example.ui.theme.MainBackground
import com.example.ui.theme.MyApplicationTheme
import com.example.ui.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
  private val viewModel: MainViewModel by viewModels()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        AmjarkDigitalApp(viewModel = viewModel)
      }
    }
  }
}

@Composable
fun AmjarkDigitalApp(viewModel: MainViewModel) {
  val uiState by viewModel.uiState.collectAsStateWithLifecycle()
  var isMenuOpen by remember { mutableStateOf(false) }
  val scrollState = rememberScrollState()

  // Reset scroll position on navigation
  LaunchedEffect(uiState.currentScreen) {
    scrollState.scrollTo(0)
  }

  // Handle system back navigation gracefully
  BackHandler(enabled = uiState.currentScreen != Screen.Home || uiState.backStack.size > 1) {
    viewModel.popBack()
  }

  Scaffold(
    topBar = {
      AmjarkTopAppBar(
        currentScreen = uiState.currentScreen,
        onNavigate = { viewModel.navigateTo(it) },
        onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) },
        onOpenMenu = { isMenuOpen = true }
      )
    },
    bottomBar = {
      AmjarkBottomNavigation(
        currentScreen = uiState.currentScreen,
        onNavigate = { viewModel.navigateTo(it) }
      )
    },
    containerColor = MainBackground
  ) { innerPadding ->
    Box(
      modifier = Modifier
        .fillMaxSize()
        .background(MainBackground)
        .padding(innerPadding)
        .verticalScroll(scrollState)
    ) {
      when (val screen = uiState.currentScreen) {
        is Screen.Home -> {
          HomeScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.About -> {
          AboutScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Services -> {
          ServicesScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.ServiceDetail -> {
          ServiceDetailScreen(
            slug = screen.slug,
            onNavigate = { viewModel.navigateTo(it) },
            onBack = { viewModel.popBack() },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Projects -> {
          ProjectsScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.ProjectDetail -> {
          ProjectDetailScreen(
            slug = screen.slug,
            onNavigate = { viewModel.navigateTo(it) },
            onBack = { viewModel.popBack() },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Team -> {
          TeamScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Process -> {
          ProcessScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Pricing -> {
          PricingScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) },
            onProceedToContact = { service, summary ->
              viewModel.transferQuoteToContact(service, summary)
            }
          )
        }
        is Screen.Contact -> {
          ContactScreen(
            viewModel = viewModel,
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Faq -> {
          FaqScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.PrivacyPolicy -> {
          PrivacyPolicyScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onBack = { viewModel.popBack() },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
        is Screen.Terms -> {
          TermsScreen(
            onNavigate = { viewModel.navigateTo(it) },
            onBack = { viewModel.popBack() },
            onOpenQuoteModal = { viewModel.setQuoteModalVisible(true) }
          )
        }
      }
    }
  }

  // Full Navigation Drawer / BottomSheet
  AmjarkNavigationMenuSheet(
    isOpen = isMenuOpen,
    currentScreen = uiState.currentScreen,
    onDismiss = { isMenuOpen = false },
    onNavigate = {
      isMenuOpen = false
      viewModel.navigateTo(it)
    },
    onOpenQuote = {
      viewModel.setQuoteModalVisible(true)
    }
  )

  // Interactive Quote Calculator Modal
  QuoteCalculatorDialog(
    isOpen = uiState.isQuoteModalVisible,
    onDismiss = { viewModel.setQuoteModalVisible(false) },
    onProceedToContact = { service, summary ->
      viewModel.transferQuoteToContact(service, summary)
    }
  )
}
