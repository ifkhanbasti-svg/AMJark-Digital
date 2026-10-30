package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import com.example.ui.theme.SurfaceContainerHigh

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FaqScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  var searchQuery by remember { mutableStateOf("") }
  var selectedCategory by remember { mutableStateOf("All") }
  var expandedIndices by remember { mutableStateOf(setOf(0)) }

  val categories = listOf(
    "All",
    "Services",
    "Project Timelines",
    "Pricing & Quotes",
    "Custom Development",
    "Revisions",
    "Payments",
    "Maintenance",
    "Project Inquiries"
  )

  val filteredFaqs = CompanyData.FAQS.filter { item ->
    val matchesCategory = (selectedCategory == "All") || (item.category.equals(selectedCategory, ignoreCase = true))
    val matchesSearch = searchQuery.isBlank() ||
      item.question.contains(searchQuery, ignoreCase = true) ||
      item.answer.contains(searchQuery, ignoreCase = true) ||
      item.category.contains(searchQuery, ignoreCase = true)
    matchesCategory && matchesSearch
  }

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
            text = "KNOWLEDGE BASE",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Frequently Asked Questions",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Explore clear answers concerning our software development cycles, custom quoting policies, revision processes, technologies, and post-launch maintenance.",
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
      // Search Bar
      OutlinedTextField(
        value = searchQuery,
        onValueChange = { searchQuery = it },
        placeholder = { Text("Search questions by keyword...", color = MutedText, fontSize = 13.sp) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = ElectricBlue) },
        trailingIcon = {
          if (searchQuery.isNotEmpty()) {
            IconButton(onClick = { searchQuery = "" }) {
              Icon(Icons.Default.Close, contentDescription = "Clear", tint = SecondaryText)
            }
          }
        },
        singleLine = true,
        modifier = Modifier.fillMaxWidth().testTag("faq_search_input"),
        colors = OutlinedTextFieldDefaults.colors(
          focusedBorderColor = ElectricBlue,
          unfocusedBorderColor = CardBorder,
          focusedContainerColor = CardBackground,
          unfocusedContainerColor = CardBackground,
          focusedTextColor = MainText,
          unfocusedTextColor = MainText
        ),
        shape = RoundedCornerShape(12.dp)
      )

      Spacer(modifier = Modifier.height(14.dp))

      // Category Chips
      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        categories.forEach { cat ->
          FilterChip(
            selected = selectedCategory == cat,
            onClick = { selectedCategory = cat },
            label = { Text(cat, fontSize = 11.sp) },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = PrimaryBlue,
              selectedLabelColor = androidx.compose.ui.graphics.Color.White,
              containerColor = CardBackground,
              labelColor = SecondaryText
            ),
            border = FilterChipDefaults.filterChipBorder(
              enabled = true,
              selected = selectedCategory == cat,
              borderColor = if (selectedCategory == cat) ElectricBlue else CardBorder
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      if (filteredFaqs.isEmpty()) {
        Card(
          colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
          shape = RoundedCornerShape(12.dp),
          modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
        ) {
          Column(
            modifier = Modifier.padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text("No questions found matching '$searchQuery'", color = MainText, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text("Try searching with broader terms or contact us directly.", color = SecondaryText, fontSize = 12.sp)
          }
        }
      } else {
        filteredFaqs.forEachIndexed { index, faq ->
          val isExpanded = expandedIndices.contains(index)
          Card(
            colors = CardDefaults.cardColors(containerColor = CardBackground),
            shape = RoundedCornerShape(14.dp),
            border = BorderStroke(1.dp, if (isExpanded) ElectricBlue.copy(alpha = 0.5f) else CardBorder),
            modifier = Modifier
              .fillMaxWidth()
              .padding(vertical = 5.dp)
              .testTag("faq_item_$index")
          ) {
            Column(
              modifier = Modifier
                .clickable {
                  expandedIndices = if (isExpanded) {
                    expandedIndices - index
                  } else {
                    expandedIndices + index
                  }
                }
                .padding(16.dp)
            ) {
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Column(modifier = Modifier.weight(1f)) {
                  Surface(
                    color = PrimaryBlue.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(4.dp)
                  ) {
                    Text(
                      text = faq.category,
                      fontSize = 9.sp,
                      fontWeight = FontWeight.Bold,
                      color = ElectricBlue,
                      modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                    )
                  }
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = faq.question,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = if (isExpanded) ElectricBlue else MainText
                  )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                  imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                  contentDescription = null,
                  tint = if (isExpanded) ElectricBlue else SecondaryText
                )
              }

              AnimatedVisibility(visible = isExpanded) {
                Column {
                  Spacer(modifier = Modifier.height(10.dp))
                  HorizontalDivider(color = CardBorder.copy(alpha = 0.5f))
                  Spacer(modifier = Modifier.height(10.dp))
                  Text(
                    text = faq.answer,
                    fontSize = 13.sp,
                    color = SecondaryText,
                    lineHeight = 20.sp
                  )
                }
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Still Have Questions Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier.padding(18.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text("Still have questions about your project?", fontWeight = FontWeight.Bold, fontSize = 15.sp, color = MainText)
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "Our senior engineers are ready to discuss your specific technical roadmap.",
            fontSize = 12.sp,
            color = SecondaryText,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
          )
          Spacer(modifier = Modifier.height(14.dp))
          Button(
            onClick = { onNavigate(Screen.Contact) },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.height(42.dp)
          ) {
            Text("Contact Our Team", fontWeight = FontWeight.Bold, fontSize = 12.sp)
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@Composable
fun PrivacyPolicyScreen(
  onNavigate: (Screen) -> Unit,
  onBack: () -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val context = LocalContext.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MainBackground)
  ) {
    Surface(
      color = SecondaryBackground,
      border = BorderStroke(1.dp, CardBorder)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(onClick = onBack, modifier = Modifier.size(36.dp)) {
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = MainText)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Privacy Policy", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MainText)
      }
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(text = "AMJark Digital — Privacy Policy", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = MainText)
            IconButton(
              onClick = {
                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("AMJark Digital Privacy Policy", CompanyData.PRIVACY_POLICY)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(context, "Privacy policy copied to clipboard", Toast.LENGTH_SHORT).show()
              }
            ) {
              Icon(Icons.Default.ContentCopy, contentDescription = "Copy text", tint = ElectricBlue, modifier = Modifier.size(18.dp))
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          HorizontalDivider(color = CardBorder)
          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = CompanyData.PRIVACY_POLICY,
            fontSize = 12.sp,
            color = SecondaryText,
            lineHeight = 19.sp
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@Composable
fun TermsScreen(
  onNavigate: (Screen) -> Unit,
  onBack: () -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val context = LocalContext.current

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MainBackground)
  ) {
    Surface(
      color = SecondaryBackground,
      border = BorderStroke(1.dp, CardBorder)
    ) {
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
      ) {
        IconButton(onClick = onBack, modifier = Modifier.size(36.dp)) {
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = MainText)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "Terms & Conditions", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MainText)
      }
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Text(text = "AMJark Digital — Terms & Conditions", fontWeight = FontWeight.Bold, fontSize = 16.sp, color = MainText)
            IconButton(
              onClick = {
                val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                val clip = ClipData.newPlainText("AMJark Digital Terms & Conditions", CompanyData.TERMS_AND_CONDITIONS)
                clipboard.setPrimaryClip(clip)
                Toast.makeText(context, "Terms copied to clipboard", Toast.LENGTH_SHORT).show()
              }
            ) {
              Icon(Icons.Default.ContentCopy, contentDescription = "Copy text", tint = ElectricBlue, modifier = Modifier.size(18.dp))
            }
          }

          Spacer(modifier = Modifier.height(12.dp))
          HorizontalDivider(color = CardBorder)
          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = CompanyData.TERMS_AND_CONDITIONS,
            fontSize = 12.sp,
            color = SecondaryText,
            lineHeight = 19.sp
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}
