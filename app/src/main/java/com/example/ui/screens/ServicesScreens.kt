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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.data.ServiceCategory
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
import com.example.ui.theme.SurfaceContainerHighest

@Composable
fun ServicesScreen(
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
            text = "SERVICES & CAPABILITIES",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Comprehensive Digital Solutions",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "From custom native mobile software to bespoke web portals, intelligent AI workflows, and distinctive visual branding, AMJark Digital engineers end-to-end digital excellence.",
          fontSize = 14.sp,
          color = SecondaryText,
          lineHeight = 22.sp
        )
      }
    }

    // 6 Services Detailed Cards
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      CompanyData.SERVICES.forEach { service ->
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(16.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .testTag("service_full_card_${service.slug}")
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
              Box(
                modifier = Modifier
                  .size(42.dp)
                  .clip(RoundedCornerShape(10.dp))
                  .background(PrimaryBlue.copy(alpha = 0.15f))
                  .border(1.dp, ElectricBlue.copy(alpha = 0.4f), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
              ) {
                Icon(service.icon, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(24.dp))
              }
              Spacer(modifier = Modifier.width(12.dp))
              Column {
                Text(
                  text = service.title,
                  fontWeight = FontWeight.Bold,
                  fontSize = 18.sp,
                  color = MainText
                )
                Text(
                  text = service.shortTagline,
                  fontSize = 12.sp,
                  color = ElectricBlue
                )
              }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = service.overview,
              fontSize = 13.sp,
              color = SecondaryText,
              lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(14.dp))

            Text(
              text = "Key Offerings:",
              fontSize = 12.sp,
              fontWeight = FontWeight.Bold,
              color = MainText
            )
            Spacer(modifier = Modifier.height(6.dp))

            service.subServices.forEach { sub ->
              Row(
                modifier = Modifier.padding(vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
              ) {
                Icon(Icons.Default.CheckCircle, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = sub, fontSize = 12.sp, color = SecondaryText)
              }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Button(
                onClick = { onNavigate(Screen.ServiceDetail(service.slug)) },
                colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).height(42.dp)
              ) {
                Text("Full Details", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(14.dp))
              }

              OutlinedButton(
                onClick = onOpenQuoteModal,
                colors = ButtonDefaults.outlinedButtonColors(contentColor = ElectricBlue),
                border = BorderStroke(1.dp, CardBorder),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).height(42.dp)
              ) {
                Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(4.dp))
                Text("Get Quote", fontSize = 12.sp, fontWeight = FontWeight.Bold)
              }
            }
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ServiceDetailScreen(
  slug: String,
  onNavigate: (Screen) -> Unit,
  onBack: () -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val service = CompanyData.SERVICES.find { it.slug == slug } ?: CompanyData.SERVICES.first()
  val relevantProjects = CompanyData.PROJECTS.filter { it.categoryId == service.id }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MainBackground)
  ) {
    // Top Bar Breadcrumb
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
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back to services", tint = MainText)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
          Text(text = "Services / ${service.title}", fontSize = 11.sp, color = ElectricBlue)
          Text(text = service.title, fontSize = 16.sp, fontWeight = FontWeight.Bold, color = MainText)
        }
      }
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      // Hero Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Box(
            modifier = Modifier
              .size(48.dp)
              .clip(RoundedCornerShape(12.dp))
              .background(Brush.linearGradient(listOf(PrimaryBlue, ElectricBlue))),
            contentAlignment = Alignment.Center
          ) {
            Icon(service.icon, contentDescription = null, tint = Color.White, modifier = Modifier.size(28.dp))
          }
          Spacer(modifier = Modifier.height(14.dp))
          Text(
            text = service.title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            color = MainText
          )
          Text(
            text = service.shortTagline,
            fontSize = 13.sp,
            color = ElectricBlue,
            fontWeight = FontWeight.Medium
          )
          Spacer(modifier = Modifier.height(12.dp))
          Text(
            text = service.overview,
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 21.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(18.dp))

      // Deliverables Section
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Tangible Deliverables",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(10.dp))
          service.deliverables.forEach { item ->
            Row(
              modifier = Modifier.padding(vertical = 4.dp),
              verticalAlignment = Alignment.Top
            ) {
              Icon(Icons.Default.Check, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp).padding(top = 2.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text(text = item, fontSize = 12.sp, color = SecondaryText, lineHeight = 18.sp)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Benefits Section
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Key Client Benefits",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(10.dp))
          service.benefits.forEach { item ->
            Row(
              modifier = Modifier.padding(vertical = 4.dp),
              verticalAlignment = Alignment.Top
            ) {
              Icon(Icons.Default.CheckCircle, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp).padding(top = 2.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text(text = item, fontSize = 12.sp, color = SecondaryText, lineHeight = 18.sp)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Technologies & Tools
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Technologies & Tooling",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(10.dp))
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            service.technologies.forEach { tech ->
              Surface(
                color = SurfaceContainerHigh,
                border = BorderStroke(1.dp, CardBorder),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = tech,
                  fontSize = 11.sp,
                  fontWeight = FontWeight.Medium,
                  color = MainText,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Process Steps for this service
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Delivery Lifecycle",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(10.dp))
          service.processSteps.forEachIndexed { idx, step ->
            Row(
              modifier = Modifier.padding(vertical = 4.dp),
              verticalAlignment = Alignment.CenterVertically
            ) {
              Box(
                modifier = Modifier
                  .size(22.dp)
                  .clip(CircleShape)
                  .background(PrimaryBlue.copy(alpha = 0.2f))
                  .border(1.dp, ElectricBlue, CircleShape),
                contentAlignment = Alignment.Center
              ) {
                Text(text = "${idx + 1}", fontSize = 10.sp, fontWeight = FontWeight.Bold, color = ElectricBlue)
              }
              Spacer(modifier = Modifier.width(10.dp))
              Text(text = step, fontSize = 12.sp, color = SecondaryText)
            }
          }
        }
      }

      if (relevantProjects.isNotEmpty()) {
        Spacer(modifier = Modifier.height(18.dp))
        Text(
          text = "RELEVANT DEMONSTRATION WORK",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = ElectricBlue,
          letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        relevantProjects.forEach { proj ->
          Card(
            colors = CardDefaults.cardColors(containerColor = CardBackground),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, CardBorder),
            modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
          ) {
            Column(modifier = Modifier.padding(14.dp)) {
              Text(text = proj.title, fontWeight = FontWeight.Bold, fontSize = 14.sp, color = MainText)
              Text(text = proj.shortDescription, fontSize = 12.sp, color = SecondaryText)
              Spacer(modifier = Modifier.height(8.dp))
              Button(
                onClick = { onNavigate(Screen.ProjectDetail(proj.slug)) },
                colors = ButtonDefaults.buttonColors(containerColor = SurfaceContainerHighest),
                shape = RoundedCornerShape(6.dp),
                modifier = Modifier.height(34.dp)
              ) {
                Icon(Icons.Default.Visibility, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text("View Architecture & Code Highlights", fontSize = 11.sp, color = MainText)
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      // Request Quote CTA
      Button(
        onClick = onOpenQuoteModal,
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
          .fillMaxWidth()
          .height(48.dp)
      ) {
        Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
        Spacer(modifier = Modifier.width(8.dp))
        Text("Request a Quote for ${service.title}", fontWeight = FontWeight.Bold, fontSize = 13.sp)
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}
