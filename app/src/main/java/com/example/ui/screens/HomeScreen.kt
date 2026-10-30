package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.RocketLaunch
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.data.CompanyData
import com.example.data.Project
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

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val context = LocalContext.current
  var selectedProjectFilter by remember { mutableStateOf("all") }
  var expandedFaqIndex by remember { mutableStateOf<Int?>(0) }

  Column(
    modifier = Modifier
      .fillMaxWidth()
      .background(MainBackground)
  ) {
    // ----------------------------------------------------
    // A. HERO SECTION
    // ----------------------------------------------------
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
      Column(modifier = Modifier.fillMaxWidth()) {
        // Tagline badge
        Surface(
          color = PrimaryBlue.copy(alpha = 0.15f),
          border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.4f)),
          shape = RoundedCornerShape(20.dp),
          modifier = Modifier.padding(bottom = 12.dp)
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
          ) {
            Box(
              modifier = Modifier
                .size(8.dp)
                .clip(CircleShape)
                .background(ElectricBlue)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "AMJARK DIGITAL • ${CompanyData.BRAND_TAGLINE}",
              fontSize = 11.sp,
              fontWeight = FontWeight.Bold,
              color = ElectricBlue,
              letterSpacing = 1.sp
            )
          }
        }

        // Main Headline
        Text(
          text = "Turning Ideas Into Digital Reality.",
          fontSize = 28.sp,
          fontWeight = FontWeight.Black,
          color = MainText,
          lineHeight = 36.sp,
          letterSpacing = (-0.5).sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Supporting Description
        Text(
          text = "We combine technology, creativity and innovation to build powerful digital experiences that help businesses move forward.",
          fontSize = 14.sp,
          color = SecondaryText,
          lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Hero Visual Image with Glassmorphism Border
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(16.dp),
          border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.4f)),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("hero_tech_image_card")
        ) {
          Box {
            Image(
              painter = painterResource(id = R.drawable.img_hero_tech_1793357676470),
              contentDescription = "Sophisticated technology-themed visual showcasing digital neural networks and analytics",
              modifier = Modifier
                .fillMaxWidth()
                .height(210.dp),
              contentScale = ContentScale.Crop
            )
            // Gradient Overlay
            Box(
              modifier = Modifier
                .fillMaxWidth()
                .height(210.dp)
                .background(
                  Brush.verticalGradient(
                    listOf(Color.Transparent, MainBackground.copy(alpha = 0.75f))
                  )
                )
            )
            // Floating Pill Tag
            Surface(
              color = MainBackground.copy(alpha = 0.85f),
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, CardBorder),
              modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(12.dp)
            ) {
              Text(
                text = "Next-Gen Software & Digital Identity",
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = MainText,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
              )
            }
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // CTAs
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          Button(
            onClick = { onNavigate(Screen.Services) },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .weight(1f)
              .height(48.dp)
              .testTag("hero_explore_services_button")
          ) {
            Text("Explore Services", fontSize = 13.sp, fontWeight = FontWeight.Bold)
          }

          OutlinedButton(
            onClick = onOpenQuoteModal,
            colors = ButtonDefaults.outlinedButtonColors(contentColor = ElectricBlue),
            border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.6f)),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .weight(1f)
              .height(48.dp)
              .testTag("hero_start_project_button")
          ) {
            Icon(Icons.Default.RocketLaunch, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(6.dp))
            Text("Start Project", fontSize = 13.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(12.dp))

    // ----------------------------------------------------
    // B. COMPANY INTRODUCTION
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
      Text(
        text = "ABOUT AMJARK DIGITAL",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )
      Spacer(modifier = Modifier.height(6.dp))
      Text(
        text = "Technology Meets Creativity.",
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = MainText
      )
      Spacer(modifier = Modifier.height(10.dp))
      Text(
        text = "AMJark Digital is a digital technology and creative company focused on developing innovative digital experiences, software solutions, applications, websites and creative brand identities. Founded by Mohammad Amjad, we build digital ecosystems that merge architectural engineering precision with visionary creative direction.",
        fontSize = 14.sp,
        color = SecondaryText,
        lineHeight = 22.sp
      )

      Spacer(modifier = Modifier.height(14.dp))

      // Brand personality pills
      val brandPillars = listOf("Professional", "Innovative", "Trustworthy", "Modern", "Creative", "Technology-driven")
      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        brandPillars.forEach { pillar ->
          Surface(
            color = CardBackground,
            border = BorderStroke(1.dp, CardBorder),
            shape = RoundedCornerShape(16.dp)
          ) {
            Row(
              verticalAlignment = Alignment.CenterVertically,
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
            ) {
              Icon(
                Icons.Default.Check,
                contentDescription = null,
                tint = ElectricBlue,
                modifier = Modifier.size(12.dp)
              )
              Spacer(modifier = Modifier.width(5.dp))
              Text(
                text = pillar,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = MainText
              )
            }
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // ----------------------------------------------------
    // C. SERVICES SECTION (6 Categories)
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(SecondaryBackground)
        .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "OUR EXPERTISE",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp
          )
          Text(
            text = "Specialized Services",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
        }
        Text(
          text = "View All",
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          color = ElectricBlue,
          modifier = Modifier
            .clickable { onNavigate(Screen.Services) }
            .padding(8.dp)
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      CompanyData.SERVICES.forEach { service ->
        ServiceCardPreview(
          service = service,
          onClick = { onNavigate(Screen.ServiceDetail(service.slug)) },
          onQuoteClick = onOpenQuoteModal
        )
        Spacer(modifier = Modifier.height(12.dp))
      }
    }

    // ----------------------------------------------------
    // D. FEATURED PROJECTS (Portfolio)
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "PORTFOLIO & WORK",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp
          )
          Text(
            text = "Featured Projects",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
        }
        Text(
          text = "Explore All",
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          color = ElectricBlue,
          modifier = Modifier
            .clickable { onNavigate(Screen.Projects) }
            .padding(8.dp)
        )
      }

      Spacer(modifier = Modifier.height(8.dp))

      // Clear demonstration disclaimer (compliance with no fake client claims)
      Card(
        colors = CardDefaults.cardColors(containerColor = SurfaceContainerHigh),
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Row(
          modifier = Modifier.padding(10.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Icon(Icons.Default.Shield, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(8.dp))
          Text(
            text = "Demonstration Projects: Showcasing AMJark Digital's architecture, UI/UX execution, and engineering standards.",
            fontSize = 11.sp,
            color = SecondaryText,
            lineHeight = 16.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      // Category filter chips
      val filterCategories = listOf(
        Pair("all", "All Works"),
        Pair("app-dev", "App Dev"),
        Pair("web-dev", "Web Dev"),
        Pair("ai-automation", "AI & Automation"),
        Pair("creative-design", "Creative")
      )

      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        filterCategories.forEach { (catId, catLabel) ->
          FilterChip(
            selected = selectedProjectFilter == catId,
            onClick = { selectedProjectFilter = catId },
            label = { Text(catLabel, fontSize = 11.sp) },
            colors = FilterChipDefaults.filterChipColors(
              selectedContainerColor = PrimaryBlue,
              selectedLabelColor = Color.White,
              containerColor = CardBackground,
              labelColor = SecondaryText
            ),
            border = FilterChipDefaults.filterChipBorder(
              enabled = true,
              selected = selectedProjectFilter == catId,
              borderColor = if (selectedProjectFilter == catId) ElectricBlue else CardBorder
            )
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      val filteredProjects = if (selectedProjectFilter == "all") {
        CompanyData.PROJECTS.take(3)
      } else {
        CompanyData.PROJECTS.filter { it.categoryId == selectedProjectFilter }.ifEmpty { CompanyData.PROJECTS.take(2) }
      }

      filteredProjects.forEach { project ->
        ProjectCardPreview(
          project = project,
          onClick = { onNavigate(Screen.ProjectDetail(project.slug)) }
        )
        Spacer(modifier = Modifier.height(12.dp))
      }
    }

    // ----------------------------------------------------
    // E. WHY CHOOSE AMJARK DIGITAL?
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(SecondaryBackground)
        .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
      Text(
        text = "WHY PARTNER WITH US",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = "Built on Principles of Excellence",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = MainText
      )
      Spacer(modifier = Modifier.height(16.dp))

      CompanyData.CORE_PRINCIPLES.forEach { (title, desc) ->
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(12.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
        ) {
          Row(
            modifier = Modifier.padding(14.dp),
            verticalAlignment = Alignment.Top
          ) {
            Box(
              modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(PrimaryBlue.copy(alpha = 0.15f))
                .border(1.dp, ElectricBlue.copy(alpha = 0.4f), RoundedCornerShape(8.dp)),
              contentAlignment = Alignment.Center
            ) {
              Icon(Icons.Default.Star, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp))
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
              Text(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = MainText
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = desc,
                fontSize = 12.sp,
                color = SecondaryText,
                lineHeight = 18.sp
              )
            }
          }
        }
      }
    }

    // ----------------------------------------------------
    // F. OUR PROCESS (Visual Timeline)
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "HOW WE DELIVER",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp
          )
          Text(
            text = "Our 6-Step Process",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
        }
        Text(
          text = "Full Details",
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          color = ElectricBlue,
          modifier = Modifier
            .clickable { onNavigate(Screen.Process) }
            .padding(8.dp)
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      CompanyData.PROCESS_STEPS.forEach { step ->
        Row(
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
          verticalAlignment = Alignment.Top
        ) {
          Box(
            modifier = Modifier
              .size(32.dp)
              .clip(CircleShape)
              .background(Brush.linearGradient(listOf(PrimaryBlue, ElectricBlue))),
            contentAlignment = Alignment.Center
          ) {
            Text(
              text = step.stepNumber.toString(),
              color = Color.White,
              fontWeight = FontWeight.Bold,
              fontSize = 13.sp
            )
          }

          Spacer(modifier = Modifier.width(12.dp))

          Column {
            Text(
              text = step.title,
              fontWeight = FontWeight.Bold,
              fontSize = 14.sp,
              color = MainText
            )
            Spacer(modifier = Modifier.height(3.dp))
            Text(
              text = step.description,
              fontSize = 12.sp,
              color = SecondaryText,
              lineHeight = 18.sp
            )
          }
        }
      }
    }

    // ----------------------------------------------------
    // G. FOUNDER SECTION
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(SecondaryBackground)
        .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
      Text(
        text = "EXECUTIVE LEADERSHIP",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = "Meet Our Founder",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = MainText
      )
      Spacer(modifier = Modifier.height(16.dp))

      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
              painter = painterResource(id = R.drawable.img_founder_avatar_1793357693131),
              contentDescription = "Mohammad Amjad - Founder & CEO of AMJark Digital",
              modifier = Modifier
                .size(72.dp)
                .clip(CircleShape)
                .border(2.dp, ElectricBlue, CircleShape),
              contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(14.dp))

            Column {
              Text(
                text = CompanyData.FOUNDER_NAME,
                fontWeight = FontWeight.Black,
                fontSize = 18.sp,
                color = MainText
              )
              Text(
                text = CompanyData.FOUNDER_TITLE,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp,
                color = ElectricBlue
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = "AMJark Digital",
                fontSize = 11.sp,
                color = SecondaryText
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = "Mohammad Amjad founded AMJark Digital with the clear mission of uniting cutting-edge software engineering with refined visual craft. Leading the organization's strategic vision, technology roadmap, and commitment to client excellence, he drives the development of transformative digital products across mobile, web, AI and creative branding.",
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 20.sp
          )

          Spacer(modifier = Modifier.height(16.dp))

          // Social and Contact Row for Founder
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            OutlinedButton(
              onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                  data = Uri.parse("mailto:${CompanyData.CONTACT_EMAIL}")
                  putExtra(Intent.EXTRA_SUBJECT, "Direct Inquiry to Mohammad Amjad — AMJark Digital")
                }
                context.startActivity(Intent.createChooser(intent, "Send Email"))
              },
              border = BorderStroke(1.dp, CardBorder),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.weight(1f).height(40.dp)
            ) {
              Icon(Icons.Default.Email, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Direct Email", fontSize = 11.sp, color = MainText)
            }

            OutlinedButton(
              onClick = {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CompanyData.OFFICIAL_DOMAIN))
                context.startActivity(intent)
              },
              border = BorderStroke(1.dp, CardBorder),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.weight(1f).height(40.dp)
            ) {
              Icon(Icons.Default.OpenInNew, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(6.dp))
              Text("Website", fontSize = 11.sp, color = MainText)
            }
          }
        }
      }
    }

    // ----------------------------------------------------
    // H. TESTIMONIALS (Factual Transparency)
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 24.dp)
    ) {
      Text(
        text = "CLIENT COMMITMENT",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = "Client Testimonials & Feedback",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        color = MainText
      )
      Spacer(modifier = Modifier.height(12.dp))

      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(16.dp)) {
          Text(
            text = "Genuine Feedback Policy",
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp,
            color = MainText
          )
          Spacer(modifier = Modifier.height(6.dp))
          Text(
            text = "In adherence to AMJark Digital's core values of honesty and transparency, we do not fabricate client testimonials or business statistics. Verified client reviews will be published here upon official conclusion of commercial engagements.",
            fontSize = 12.sp,
            color = SecondaryText,
            lineHeight = 18.sp
          )
        }
      }
    }

    // ----------------------------------------------------
    // I. FAQ PREVIEW
    // ----------------------------------------------------
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .background(SecondaryBackground)
        .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Column {
          Text(
            text = "FREQUENTLY ASKED",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp
          )
          Text(
            text = "Common Questions",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
        }
        Text(
          text = "All FAQs",
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          color = ElectricBlue,
          modifier = Modifier
            .clickable { onNavigate(Screen.Faq) }
            .padding(8.dp)
        )
      }

      Spacer(modifier = Modifier.height(14.dp))

      CompanyData.FAQS.take(4).forEachIndexed { index, faq ->
        val isExpanded = expandedFaqIndex == index
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(12.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
        ) {
          Column(
            modifier = Modifier
              .clickable { expandedFaqIndex = if (isExpanded) null else index }
              .padding(14.dp)
          ) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = faq.question,
                fontWeight = FontWeight.SemiBold,
                fontSize = 13.sp,
                color = if (isExpanded) ElectricBlue else MainText,
                modifier = Modifier.weight(1f)
              )
              Icon(
                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null,
                tint = SecondaryText
              )
            }
            AnimatedVisibility(visible = isExpanded) {
              Column {
                Spacer(modifier = Modifier.height(10.dp))
                HorizontalDivider(color = CardBorder.copy(alpha = 0.5f))
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                  text = faq.answer,
                  fontSize = 12.sp,
                  color = SecondaryText,
                  lineHeight = 18.sp
                )
              }
            }
          }
        }
      }
    }

    // ----------------------------------------------------
    // J. CONTACT CTA BANNER
    // ----------------------------------------------------
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)
    ) {
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.6f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(
          modifier = Modifier.padding(20.dp),
          horizontalAlignment = Alignment.CenterHorizontally
        ) {
          Text(
            text = "Let's Build Something Great Together.",
            fontWeight = FontWeight.Black,
            fontSize = 20.sp,
            color = MainText,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "Have an ambitious software concept, web platform, or creative branding requirement? Let's discuss your roadmap.",
            fontSize = 13.sp,
            color = SecondaryText,
            textAlign = androidx.compose.ui.text.style.TextAlign.Center,
            lineHeight = 19.sp
          )
          Spacer(modifier = Modifier.height(16.dp))
          Button(
            onClick = { onNavigate(Screen.Contact) },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.height(46.dp)
          ) {
            Text("Start Your Project", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
          }
        }
      }
    }

    // ----------------------------------------------------
    // K. FOOTER
    // ----------------------------------------------------
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@Composable
fun ServiceCardPreview(
  service: ServiceCategory,
  onClick: () -> Unit,
  onQuoteClick: () -> Unit
) {
  Card(
    colors = CardDefaults.cardColors(containerColor = CardBackground),
    shape = RoundedCornerShape(14.dp),
    border = BorderStroke(1.dp, CardBorder),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("service_card_${service.slug}")
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
          modifier = Modifier
            .size(36.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(PrimaryBlue.copy(alpha = 0.15f))
            .border(1.dp, ElectricBlue.copy(alpha = 0.4f), RoundedCornerShape(8.dp)),
          contentAlignment = Alignment.Center
        ) {
          Icon(service.icon, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(20.dp))
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
          Text(
            text = service.title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MainText
          )
          Text(
            text = service.shortTagline,
            fontSize = 11.sp,
            color = SecondaryText,
            maxLines = 1
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      // Sub-services preview
      service.subServices.take(3).forEach { sub ->
        Row(
          modifier = Modifier.padding(vertical = 2.dp),
          verticalAlignment = Alignment.CenterVertically
        ) {
          Box(modifier = Modifier.size(4.dp).clip(CircleShape).background(ElectricBlue))
          Spacer(modifier = Modifier.width(8.dp))
          Text(text = sub, fontSize = 12.sp, color = SecondaryText, maxLines = 1)
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "Explore Details →",
          color = ElectricBlue,
          fontSize = 12.sp,
          fontWeight = FontWeight.Bold,
          modifier = Modifier.clickable { onClick() }
        )

        OutlinedButton(
          onClick = onQuoteClick,
          shape = RoundedCornerShape(8.dp),
          border = BorderStroke(1.dp, CardBorder),
          contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 12.dp, vertical = 4.dp),
          modifier = Modifier.height(32.dp)
        ) {
          Text("Get Quote", fontSize = 11.sp, color = MainText)
        }
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProjectCardPreview(
  project: Project,
  onClick: () -> Unit
) {
  Card(
    colors = CardDefaults.cardColors(containerColor = CardBackground),
    shape = RoundedCornerShape(14.dp),
    border = BorderStroke(1.dp, CardBorder),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("project_preview_${project.slug}")
  ) {
    Column(modifier = Modifier.padding(16.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Surface(
          color = PrimaryBlue.copy(alpha = 0.15f),
          shape = RoundedCornerShape(6.dp),
          border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.4f))
        ) {
          Text(
            text = project.categoryName,
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
          )
        }

        Surface(
          color = SecondaryBackground,
          shape = RoundedCornerShape(6.dp)
        ) {
          Text(
            text = "Demonstration Project",
            fontSize = 10.sp,
            color = MutedText,
            modifier = Modifier.padding(horizontal = 6.dp, vertical = 3.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(10.dp))

      Text(
        text = project.title,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = MainText
      )

      Spacer(modifier = Modifier.height(4.dp))

      Text(
        text = project.shortDescription,
        fontSize = 12.sp,
        color = SecondaryText,
        lineHeight = 18.sp
      )

      Spacer(modifier = Modifier.height(10.dp))

      // Technologies pills
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
              modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = SurfaceContainerHighest),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.fillMaxWidth().height(36.dp)
      ) {
        Icon(Icons.Default.Visibility, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
        Spacer(modifier = Modifier.width(6.dp))
        Text("View Project Details", fontSize = 12.sp, fontWeight = FontWeight.SemiBold, color = MainText)
      }
    }
  }
}
