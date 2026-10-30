package com.example.ui.screens

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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Payments
import androidx.compose.material.icons.filled.Timeline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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

@Composable
fun ProcessScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
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
            text = "METHODOLOGY & EXECUTION",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Our 6-Stage Process",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "We engineer digital products through a structured, predictable, and transparent lifecycle from initial requirement analysis to final production launch and long-term support.",
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
      CompanyData.PROCESS_STEPS.forEach { step ->
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(16.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .testTag("process_step_${step.stepNumber}")
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .clip(CircleShape)
                  .background(Brush.linearGradient(listOf(PrimaryBlue, ElectricBlue))),
                contentAlignment = Alignment.Center
              ) {
                Text(
                  text = "0${step.stepNumber}",
                  fontSize = 13.sp,
                  fontWeight = FontWeight.Black,
                  color = Color.White
                )
              }
              Spacer(modifier = Modifier.width(12.dp))
              Text(
                text = step.title,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold,
                color = MainText
              )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = step.description,
              fontSize = 13.sp,
              color = SecondaryText,
              lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(14.dp))
            HorizontalDivider(color = CardBorder.copy(alpha = 0.5f))
            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = "Key Stage Deliverables:",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = ElectricBlue
            )
            Spacer(modifier = Modifier.height(6.dp))

            step.deliverables.forEach { item ->
              Row(
                modifier = Modifier.padding(vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(Icons.Default.Check, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = item, fontSize = 12.sp, color = SecondaryText)
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Timeline Commitment Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.4f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "Transparent Delivery Milestones",
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            color = MainText
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "Every client project includes weekly milestone check-ins, direct communications with lead engineers, staging environment access, and sprint demonstration reviews.",
            fontSize = 12.sp,
            color = SecondaryText,
            lineHeight = 18.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      Button(
        onClick = onOpenQuoteModal,
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth().height(48.dp)
      ) {
        Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text("Request Milestone Project Estimate", fontSize = 13.sp, fontWeight = FontWeight.Bold)
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun PricingScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit,
  onProceedToContact: (service: String, summary: String) -> Unit
) {
  var activeService by remember { mutableStateOf("App Development") }
  var activeTier by remember { mutableStateOf("Commercial Launch") }
  val activeAddons = remember { mutableStateOf(setOf("High Performance Architecture", "Security & QA Audit")) }

  val serviceList = listOf(
    "App Development",
    "Web Development",
    "Graphic & Creative Design",
    "AI & Automation",
    "Video Production",
    "Digital Solutions"
  )

  val tiers = listOf(
    Triple("Prototype / MVP", "Rapid proof of concept & core feature validation.", "2 - 4 Weeks"),
    Triple("Commercial Launch", "Full production architecture, responsive UI & store readiness.", "5 - 8 Weeks"),
    Triple("Enterprise Platform", "High SLA, microservices, cloud orchestration & automated CI/CD.", "8 - 14 Weeks")
  )

  val addonList = listOf(
    "High Performance Architecture",
    "Security & QA Audit",
    "AI & Machine Intelligence Microservice",
    "Multi-Platform Parity (Android + iOS / Web)",
    "Ongoing SLA & Maintenance Retainer"
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
            text = "INVESTMENT & QUOTATION",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Transparent Custom Quotes",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "We build custom software, web platforms, and visual identities. We do not use arbitrary fixed pricing. We structure transparent, itemized quotes tailored strictly to your project's technical scope.",
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
      // Pricing Philosophy Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Info, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(10.dp))
            Text(
              text = "Why Custom Quoting Matters",
              fontWeight = FontWeight.Bold,
              fontSize = 15.sp,
              color = MainText
            )
          }
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "Pre-packaged fixed packages often lead to bloated costs or cut corners. At AMJark Digital, we analyze your exact technology stack, third-party integrations, and performance targets to deliver an honest proposal.",
            fontSize = 12.sp,
            color = SecondaryText,
            lineHeight = 18.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      Text(
        text = "INTERACTIVE SCOPE ESTIMATOR",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )
      Spacer(modifier = Modifier.height(10.dp))

      // 1. Service Selection
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text("1. Select Required Service", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MainText)
          Spacer(modifier = Modifier.height(8.dp))

          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            serviceList.forEach { s ->
              FilterChip(
                selected = activeService == s,
                onClick = { activeService = s },
                label = { Text(s, fontSize = 11.sp) },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = PrimaryBlue,
                  selectedLabelColor = Color.White,
                  containerColor = SecondaryBackground,
                  labelColor = SecondaryText
                ),
                border = FilterChipDefaults.filterChipBorder(
                  enabled = true,
                  selected = activeService == s,
                  borderColor = if (activeService == s) ElectricBlue else CardBorder
                )
              )
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 2. Tier Selection
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text("2. Select Project Scale & Horizon", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MainText)
          Spacer(modifier = Modifier.height(10.dp))

          tiers.forEach { (name, desc, time) ->
            val isSelected = activeTier == name
            Surface(
              onClick = { activeTier = name },
              color = if (isSelected) PrimaryBlue.copy(alpha = 0.15f) else SecondaryBackground,
              shape = RoundedCornerShape(10.dp),
              border = BorderStroke(1.dp, if (isSelected) ElectricBlue else CardBorder),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
            ) {
              Row(
                modifier = Modifier.padding(12.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Box(
                  modifier = Modifier
                    .size(16.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, if (isSelected) ElectricBlue else SecondaryText, CircleShape)
                    .background(if (isSelected) ElectricBlue else Color.Transparent)
                )
                Spacer(modifier = Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                  Text(text = name, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = if (isSelected) ElectricBlue else MainText)
                  Text(text = desc, fontSize = 11.sp, color = SecondaryText)
                }
                Surface(
                  color = SurfaceContainerHigh,
                  shape = RoundedCornerShape(4.dp)
                ) {
                  Text(text = time, fontSize = 10.sp, color = ElectricBlue, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                }
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // 3. Addon selection
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text("3. Architectural Enhancements & Add-ons", fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MainText)
          Spacer(modifier = Modifier.height(8.dp))

          addonList.forEach { addon ->
            val isChecked = activeAddons.value.contains(addon)
            Surface(
              onClick = {
                val current = activeAddons.value.toMutableSet()
                if (isChecked) current.remove(addon) else current.add(addon)
                activeAddons.value = current
              },
              color = SecondaryBackground,
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, if (isChecked) ElectricBlue.copy(alpha = 0.5f) else CardBorder),
              modifier = Modifier.fillMaxWidth().padding(vertical = 3.dp)
            ) {
              Row(
                modifier = Modifier.padding(10.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Box(
                  modifier = Modifier
                    .size(16.dp)
                    .clip(RoundedCornerShape(4.dp))
                    .border(1.5.dp, if (isChecked) ElectricBlue else SecondaryText, RoundedCornerShape(4.dp))
                    .background(if (isChecked) ElectricBlue else Color.Transparent),
                  contentAlignment = Alignment.Center
                ) {
                  if (isChecked) {
                    Icon(Icons.Default.Check, contentDescription = null, tint = MainBackground, modifier = Modifier.size(12.dp))
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = addon, fontSize = 12.sp, color = if (isChecked) MainText else SecondaryText)
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(18.dp))

      // Request Official Quote CTA
      Button(
        onClick = {
          val summary = "Quote request from Pricing Scope Estimator:\n" +
            "• Service: $activeService\n" +
            "• Scale Tier: $activeTier\n" +
            "• Add-ons: ${if (activeAddons.value.isEmpty()) "None" else activeAddons.value.joinToString(", ")}\n" +
            "Please contact me with an itemized proposal."
          onProceedToContact(activeService, summary)
        },
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp)
          .testTag("pricing_proceed_contact_button")
      ) {
        Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text("Request Official Itemized Proposal", fontSize = 13.sp, fontWeight = FontWeight.Bold)
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}
