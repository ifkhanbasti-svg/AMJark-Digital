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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.Shield
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.Visibility
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
import com.example.data.Project
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectsScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  var selectedFilter by remember { mutableStateOf("all") }

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
            text = "PORTFOLIO & SHOWCASE",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Projects & Case Studies",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Explore our demonstration projects engineered to demonstrate architectural design, responsive UI/UX, and technical precision across web, mobile, AI, and creative design.",
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
      // Demonstration Disclosure Banner
      Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceContainerHigh),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier.padding(12.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(Icons.Default.Shield, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(18.dp))
          Spacer(modifier = Modifier.width(10.dp))
          Text(
            text = "Portfolio Transparency: In strict alignment with AMJark Digital's ethics, these showcase solutions are demonstration benchmarks built to exhibit genuine technical and architectural capability without simulated client metrics.",
            fontSize = 11.sp,
            color = SecondaryText,
            lineHeight = 16.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Category filters
      val categories = listOf(
        Pair("all", "All"),
        Pair("app-dev", "App Dev"),
        Pair("web-dev", "Web Dev"),
        Pair("creative-design", "Design"),
        Pair("ai-automation", "AI & Automation"),
        Pair("video-production", "Video"),
        Pair("digital-solutions", "Solutions")
      )

      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        categories.forEach { (catId, catTitle) ->
          FilterChip(
            selected = selectedFilter == catId,
            onClick = { selectedFilter = catId },
            label = { Text(catTitle, fontSize = 11.sp) },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = PrimaryBlue,
              selectedLabelColor = Color.White,
              containerColor = CardBackground,
              labelColor = SecondaryText
            ),
            border = FilterChipDefaults.filterChipBorder(
              enabled = true,
              selected = selectedFilter == catId,
              borderColor = if (selectedFilter == catId) ElectricBlue else CardBorder
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      val filteredProjects = if (selectedFilter == "all") {
        CompanyData.PROJECTS
      } else {
        CompanyData.PROJECTS.filter { it.categoryId == selectedFilter }
      }

      filteredProjects.forEach { project ->
        ProjectCardDetailed(
          project = project,
          onViewDetails = { onNavigate(Screen.ProjectDetail(project.slug)) }
        )
        Spacer(modifier = Modifier.height(14.dp))
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCardDetailed(
  project: Project,
  onViewDetails: () -> Unit
) {
  Card(
    colors = CardDefaults.cardColors(containerColor = CardBackground),
    shape = RoundedCornerShape(16.dp),
    border = BorderStroke(1.dp, CardBorder),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("project_item_${project.slug}")
  ) {
    Column(modifier = Modifier.padding(18.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          color = PrimaryBlue.copy(alpha = 0.2f),
          border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f)),
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = project.categoryName,
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
          )
        }

        Text(
          text = "Benchmark",
          fontSize = 11.sp,
          color = MutedText
        )
      }

      Spacer(modifier = Modifier.height(12.dp))

      Text(
        text = project.title,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        color = MainText
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = project.shortDescription,
        fontSize = 13.sp,
        color = SecondaryText,
        lineHeight = 19.sp
      )

      Spacer(modifier = Modifier.height(12.dp))

      // Technologies
      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
      ) {
        project.technologies.forEach { tech ->
          Surface(
            color = SurfaceContainerHigh,
            shape = RoundedCornerShape(4.dp)
          ) {
            Text(
              text = tech,
              fontSize = 10.sp,
              color = SecondaryText,
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Button(
        onClick = onViewDetails,
        colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().height(42.dp)
      ) {
        Icon(Icons.Default.Visibility, contentDescription = null, modifier = Modifier.size(16.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("View Project & Architecture", fontSize = 12.sp, fontWeight = FontWeight.Bold)
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectDetailScreen(
  slug: String,
  onNavigate: (Screen) -> Unit,
  onBack: () -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val project = CompanyData.PROJECTS.find { it.slug == slug } ?: CompanyData.PROJECTS.first()

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MainBackground)
  ) {
    // Breadcrumb top bar
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
          Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back to portfolio", tint = MainText)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column {
          Text(text = "Portfolio / ${project.categoryName}", fontSize = 11.sp, color = ElectricBlue)
          Text(text = project.title, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = MainText)
        }
      }
    }

    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      // Main Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Surface(
            color = PrimaryBlue.copy(alpha = 0.2f),
            shape = RoundedCornerShape(6.dp),
            border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f))
          ) {
            Text(
              text = project.categoryName,
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = ElectricBlue,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = project.title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            color = MainText
          )

          Spacer(modifier = Modifier.height(10.dp))

          Text(
            text = project.fullDescription,
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 21.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Key Features
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Star, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Key System Capabilities",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = MainText
            )
          }
          Spacer(modifier = Modifier.height(12.dp))
          project.keyFeatures.forEach { feature ->
            Row(
              modifier = Modifier.padding(vertical = 4.dp),
              verticalAlignment = Alignment.Top
            ) {
              Icon(Icons.Default.CheckCircle, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp).padding(top = 2.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text(text = feature, fontSize = 12.sp, color = SecondaryText, lineHeight = 18.sp)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Architecture Highlights
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Code, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(18.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "Architectural Highlights",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = MainText
            )
          }
          Spacer(modifier = Modifier.height(12.dp))
          project.architectureHighlights.forEach { highlight ->
            Row(
              modifier = Modifier.padding(vertical = 4.dp),
              verticalAlignment = Alignment.Top
            ) {
              Icon(Icons.Default.Check, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp).padding(top = 2.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Text(text = highlight, fontSize = 12.sp, color = SecondaryText, lineHeight = 18.sp)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Technologies Used
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Technologies Deployed",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(10.dp))
          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            project.technologies.forEach { tech ->
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

      Spacer(modifier = Modifier.height(20.dp))

      // CTA
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
        Text("Request Similar Solution", fontWeight = FontWeight.Bold, fontSize = 13.sp)
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}
