package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CompanyData
import com.example.ui.components.AmjarkFooter
import com.example.ui.navigation.Screen
import com.example.ui.theme.CardBackground
import com.example.ui.theme.CardBorder
import com.example.ui.theme.ElectricBlue
import com.example.ui.theme.MainBackground
import com.example.ui.theme.MainText
import com.example.ui.theme.MutedText
import com.example.ui.theme.PrimaryBlue
import com.example.ui.theme.SecondaryBackground
import com.example.ui.theme.SecondaryText
import com.example.ui.theme.SuccessGreen
import com.example.ui.theme.SurfaceContainerHigh
import com.example.ui.viewmodel.MainViewModel

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContactScreen(
  viewModel: MainViewModel,
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val context = LocalContext.current
  val uiState = viewModel.uiState.value

  var name by remember { mutableStateOf("") }
  var email by remember { mutableStateOf("") }
  var phone by remember { mutableStateOf("") }
  var company by remember { mutableStateOf("") }
  var selectedService by remember { mutableStateOf(uiState.prefilledContactService) }
  var selectedBudget by remember { mutableStateOf("Under \$5,000") }
  var projectDescription by remember { mutableStateOf(uiState.prefilledProjectDescription) }

  // Sync if prefilled changes from quote flow
  LaunchedEffect(uiState.prefilledContactService, uiState.prefilledProjectDescription) {
    if (uiState.prefilledContactService.isNotBlank()) {
      selectedService = uiState.prefilledContactService
    }
    if (uiState.prefilledProjectDescription.isNotBlank() && projectDescription.isBlank()) {
      projectDescription = uiState.prefilledProjectDescription
    }
  }

  val servicesList = listOf(
    "App Development",
    "Web Development",
    "Graphic & Creative Design",
    "AI & Automation",
    "Video Production",
    "Digital Solutions"
  )

  val budgetRanges = listOf(
    "Under \$5,000",
    "\$5,000 - \$15,000",
    "\$15,000 - \$30,000",
    "\$30,000+",
    "Undetermined"
  )

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MainBackground)
  ) {
    // Header Banner
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .background(
          Brush.verticalGradient(
            listOf(SecondaryBackground, MainBackground)
          )
        )
        .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
      Column {
        Surface(
          color = PrimaryBlue.copy(alpha = 0.15f),
          border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.4f)),
          shape = RoundedCornerShape(16.dp)
        ) {
          Text(
            text = "INITIATE ENGAGEMENT",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Let's Build Something Great Together.",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Share your project vision, target timeline, or technical challenges. Our leadership and engineering team will review your requirements and respond promptly.",
          fontSize = 14.sp,
          color = SecondaryText,
          lineHeight = 22.sp
        )
      }
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      // Direct Communication Fast Action Cards
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Card(
          colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
          shape = RoundedCornerShape(12.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .weight(1f)
            .clickable {
              val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CompanyData.WHATSAPP_LINK))
              context.startActivity(intent)
            }
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Icon(Icons.AutoMirrored.Filled.Chat, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text("WhatsApp Direct", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MainText)
            Text(CompanyData.WHATSAPP_NUMBER, fontSize = 11.sp, color = SecondaryText)
          }
        }

        Card(
          colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
          shape = RoundedCornerShape(12.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .weight(1f)
            .clickable {
              val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${CompanyData.CONTACT_EMAIL}")
                putExtra(Intent.EXTRA_SUBJECT, "Project Inquiry via AMJark App")
              }
              context.startActivity(Intent.createChooser(intent, "Email Inquiry"))
            }
        ) {
          Column(modifier = Modifier.padding(14.dp)) {
            Icon(Icons.Default.Email, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text("Official Email", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MainText)
            Text(CompanyData.CONTACT_EMAIL, fontSize = 11.sp, color = SecondaryText, maxLines = 1)
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Submission Feedback Messages
      uiState.userFeedbackMessage?.let { msg ->
        Card(
          colors = CardDefaults.cardColors(
            containerColor = if (uiState.inquirySubmissionSuccess) SuccessGreen.copy(alpha = 0.15f) else PrimaryBlue.copy(alpha = 0.15f)
          ),
          shape = RoundedCornerShape(10.dp),
          border = BorderStroke(1.dp, if (uiState.inquirySubmissionSuccess) SuccessGreen else ElectricBlue),
          modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
        ) {
          Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
          ) {
            Icon(
              if (uiState.inquirySubmissionSuccess) Icons.Default.CheckCircle else Icons.Default.Email,
              contentDescription = null,
              tint = if (uiState.inquirySubmissionSuccess) SuccessGreen else ElectricBlue,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = msg,
              fontSize = 12.sp,
              color = MainText,
              lineHeight = 17.sp,
              modifier = Modifier.weight(1f)
            )
          }
        }
      }

      // Contact Form Card
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth().testTag("contact_form_card")
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Project Inquiry Form",
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Text(
            text = "Fields marked with (*) are required.",
            fontSize = 11.sp,
            color = MutedText
          )

          Spacer(modifier = Modifier.height(16.dp))

          // Full Name
          Text(text = "Your Full Name *", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
          Spacer(modifier = Modifier.height(4.dp))
          OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            placeholder = { Text("e.g. Alex Johnson", color = MutedText, fontSize = 13.sp) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().testTag("input_contact_name"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = ElectricBlue,
              unfocusedBorderColor = CardBorder,
              focusedContainerColor = SecondaryBackground,
              unfocusedContainerColor = SecondaryBackground,
              focusedTextColor = MainText,
              unfocusedTextColor = MainText
            ),
            shape = RoundedCornerShape(10.dp)
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Email
          Text(text = "Business Email Address *", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
          Spacer(modifier = Modifier.height(4.dp))
          OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = { Text("e.g. alex@company.com", color = MutedText, fontSize = 13.sp) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth().testTag("input_contact_email"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = ElectricBlue,
              unfocusedBorderColor = CardBorder,
              focusedContainerColor = SecondaryBackground,
              unfocusedContainerColor = SecondaryBackground,
              focusedTextColor = MainText,
              unfocusedTextColor = MainText
            ),
            shape = RoundedCornerShape(10.dp)
          )

          Spacer(modifier = Modifier.height(12.dp))

          // Phone & Company Row
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Column(modifier = Modifier.weight(1f)) {
              Text(text = "Phone (Optional)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
              Spacer(modifier = Modifier.height(4.dp))
              OutlinedTextField(
                value = phone,
                onValueChange = { phone = it },
                placeholder = { Text("+1 (555)...", color = MutedText, fontSize = 12.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().testTag("input_contact_phone"),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = ElectricBlue,
                  unfocusedBorderColor = CardBorder,
                  focusedContainerColor = SecondaryBackground,
                  unfocusedContainerColor = SecondaryBackground,
                  focusedTextColor = MainText,
                  unfocusedTextColor = MainText
                ),
                shape = RoundedCornerShape(10.dp)
              )
            }

            Column(modifier = Modifier.weight(1f)) {
              Text(text = "Company (Optional)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
              Spacer(modifier = Modifier.height(4.dp))
              OutlinedTextField(
                value = company,
                onValueChange = { company = it },
                placeholder = { Text("Acme Corp", color = MutedText, fontSize = 12.sp) },
                singleLine = true,
                modifier = Modifier.fillMaxWidth().testTag("input_contact_company"),
                colors = OutlinedTextFieldDefaults.colors(
                  focusedBorderColor = ElectricBlue,
                  unfocusedBorderColor = CardBorder,
                  focusedContainerColor = SecondaryBackground,
                  unfocusedContainerColor = SecondaryBackground,
                  focusedTextColor = MainText,
                  unfocusedTextColor = MainText
                ),
                shape = RoundedCornerShape(10.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Service Selection
          Text(text = "Service of Interest", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
          Spacer(modifier = Modifier.height(6.dp))
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            servicesList.forEach { s ->
              FilterChip(
                selected = selectedService == s,
                onClick = { selectedService = s },
                label = { Text(s, fontSize = 11.sp) },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = PrimaryBlue,
                  selectedLabelColor = Color.White,
                  containerColor = SecondaryBackground,
                  labelColor = SecondaryText
                ),
                border = FilterChipDefaults.filterChipBorder(
                  enabled = true,
                  selected = selectedService == s,
                  borderColor = if (selectedService == s) ElectricBlue else CardBorder
                )
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Budget range
          Text(text = "Project Budget Parameter (Optional)", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
          Spacer(modifier = Modifier.height(6.dp))
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            budgetRanges.forEach { b ->
              FilterChip(
                selected = selectedBudget == b,
                onClick = { selectedBudget = b },
                label = { Text(b, fontSize = 11.sp) },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = PrimaryBlue,
                  selectedLabelColor = Color.White,
                  containerColor = SecondaryBackground,
                  labelColor = SecondaryText
                ),
                border = FilterChipDefaults.filterChipBorder(
                  enabled = true,
                  selected = selectedBudget == b,
                  borderColor = if (selectedBudget == b) ElectricBlue else CardBorder
                )
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          // Project Description
          Text(text = "Project Overview & Requirements *", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
          Spacer(modifier = Modifier.height(4.dp))
          OutlinedTextField(
            value = projectDescription,
            onValueChange = { projectDescription = it },
            placeholder = { Text("Briefly describe your objectives, key features, and any timeline preferences...", color = MutedText, fontSize = 12.sp) },
            minLines = 4,
            maxLines = 8,
            modifier = Modifier.fillMaxWidth().testTag("input_contact_description"),
            colors = OutlinedTextFieldDefaults.colors(
              focusedBorderColor = ElectricBlue,
              unfocusedBorderColor = CardBorder,
              focusedContainerColor = SecondaryBackground,
              unfocusedContainerColor = SecondaryBackground,
              focusedTextColor = MainText,
              unfocusedTextColor = MainText
            ),
            shape = RoundedCornerShape(10.dp)
          )

          Spacer(modifier = Modifier.height(18.dp))

          // Submit Button
          Button(
            onClick = {
              viewModel.submitInquiry(
                name = name,
                email = email,
                phone = phone,
                company = company,
                service = selectedService,
                budget = selectedBudget,
                description = projectDescription,
                onSuccess = {
                  // Keep fields in memory or reset
                }
              )
            },
            enabled = !uiState.isSubmittingInquiry,
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
              .testTag("submit_inquiry_button")
          ) {
            if (uiState.isSubmittingInquiry) {
              CircularProgressIndicator(color = Color.White, modifier = Modifier.size(18.dp), strokeWidth = 2.dp)
              Spacer(modifier = Modifier.width(8.dp))
              Text("Submitting Inquiry...", fontSize = 13.sp)
            } else {
              Icon(Icons.AutoMirrored.Filled.Send, contentDescription = null, modifier = Modifier.size(16.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text("Submit Project Inquiry", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            }
          }

          // Options after submit or fast dispatch
          if (name.isNotBlank() && email.isNotBlank()) {
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedButton(
              onClick = {
                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText(
                  "AMJark Digital Inquiry",
                  "Inquiry Details:\nName: $name\nEmail: $email\nService: $selectedService\nDescription: $projectDescription"
                )
                clipboard.setPrimaryClip(clip)
                Toast.makeText(context, "Inquiry summary copied to clipboard!", Toast.LENGTH_SHORT).show()
              },
              border = BorderStroke(1.dp, CardBorder),
              shape = RoundedCornerShape(10.dp),
              modifier = Modifier.fillMaxWidth().height(40.dp)
            ) {
              Icon(Icons.Default.ContentCopy, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Copy Inquiry Draft", fontSize = 11.sp, color = MainText)
            }
          }
        }
      }

      // Recent Submitted Inquiries in this session
      if (uiState.submittedInquiries.isNotEmpty()) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
          text = "YOUR RECENT INQUIRIES (${uiState.submittedInquiries.size})",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = ElectricBlue,
          letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        uiState.submittedInquiries.forEach { inq ->
          Card(
            colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, SuccessGreen.copy(alpha = 0.5f)),
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
              ) {
                Text(text = inq.serviceCategory, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = ElectricBlue)
                Surface(
                  color = SuccessGreen.copy(alpha = 0.2f),
                  shape = RoundedCornerShape(4.dp)
                ) {
                  Text(text = "Received", fontSize = 10.sp, color = SuccessGreen, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text(text = "From: ${inq.name} (${inq.email})", fontSize = 12.sp, color = MainText)
              Spacer(modifier = Modifier.height(4.dp))
              Text(text = inq.projectDescription, fontSize = 11.sp, color = SecondaryText, maxLines = 2)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Direct Contact Coordinates Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text("Official Corporate Coordinates", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = MainText)
          Spacer(modifier = Modifier.height(12.dp))

          CoordinateRow(icon = Icons.Default.Language, title = "Official Website", value = CompanyData.OFFICIAL_DOMAIN) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CompanyData.OFFICIAL_DOMAIN))
            context.startActivity(intent)
          }

          CoordinateRow(icon = Icons.Default.Email, title = "Business Inquiries", value = CompanyData.CONTACT_EMAIL) {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
              data = Uri.parse("mailto:${CompanyData.CONTACT_EMAIL}")
              putExtra(Intent.EXTRA_SUBJECT, "Direct Inquiry — AMJark Digital")
            }
            context.startActivity(Intent.createChooser(intent, "Email AMJark"))
          }

          CoordinateRow(icon = Icons.AutoMirrored.Filled.Chat, title = "WhatsApp Direct", value = CompanyData.WHATSAPP_NUMBER) {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CompanyData.WHATSAPP_LINK))
            context.startActivity(intent)
          }

          CoordinateRow(icon = Icons.Default.Person, title = "Founder & CEO", value = CompanyData.FOUNDER_NAME) {}
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@Composable
fun CoordinateRow(
  icon: androidx.compose.ui.graphics.vector.ImageVector,
  title: String,
  value: String,
  onClick: () -> Unit
) {
  Row(
    modifier = Modifier
      .fillMaxWidth()
      .clickable { onClick() }
      .padding(vertical = 6.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Icon(icon, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp))
    Spacer(modifier = Modifier.width(12.dp))
    Column {
      Text(text = title, fontSize = 11.sp, color = SecondaryText)
      Text(text = value, fontSize = 13.sp, fontWeight = FontWeight.SemiBold, color = MainText)
    }
  }
}
