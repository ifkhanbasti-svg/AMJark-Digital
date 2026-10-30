package com.example.ui.screens

import android.content.Intent
import android.net.Uri
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
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.data.TeamMember
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
fun AboutScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val context = LocalContext.current

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
            text = "ABOUT AMJARK DIGITAL",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Technology, Craft & Vision",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "AMJark Digital is a digital technology and creative development company founded by Mohammad Amjad. We architect intelligent applications, web portals, creative brand identities, and high-impact digital solutions.",
          fontSize = 14.sp,
          color = SecondaryText,
          lineHeight = 22.sp
        )
      }
    }

    // Who We Are & Our Story
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 12.dp)
    ) {
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Who We Are",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "We are a multidisciplinary digital technology firm operating at the intersection of modern software engineering and visual identity design. Our teams bridge technical complexity and elegant design to build software experiences that empower businesses to scale sustainably.",
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 20.sp
          )

          Spacer(modifier = Modifier.height(16.dp))
          HorizontalDivider(color = CardBorder)
          Spacer(modifier = Modifier.height(16.dp))

          Text(
            text = "Our Story",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(8.dp))
          Text(
            text = "Founded by Mohammad Amjad, AMJark Digital was established to challenge the compromise between robust engineering and creative sophistication. Starting with a clear focus on modern native mobile apps and bespoke web ecosystems, we have systematically expanded our capabilities into AI workflow automation, visual branding, and digital transformation.",
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 20.sp
          )
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Mission & Vision
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(14.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier.weight(1f)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Our Mission",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = ElectricBlue
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "To empower innovative enterprises by engineering reliable, state-of-the-art software systems and cultivating distinctive brand assets.",
              fontSize = 12.sp,
              color = SecondaryText,
              lineHeight = 18.sp
            )
          }
        }

        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(14.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier.weight(1f)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = "Our Vision",
              fontSize = 16.sp,
              fontWeight = FontWeight.Bold,
              color = ElectricBlue
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = "To stand as an internationally recognized technology partner renowned for uncompromising code quality, ethical engineering, and creative excellence.",
              fontSize = 12.sp,
              color = SecondaryText,
              lineHeight = 18.sp
            )
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Our Values
      Card(
        colors = CardDefaults.cardColors(containerColor = CardBackground),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, CardBorder),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "Our Core Values",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(12.dp))

          CompanyData.CORE_PRINCIPLES.forEach { (title, desc) ->
            Row(
              modifier = Modifier.padding(vertical = 4.dp),
              verticalAlignment = Alignment.Top
            ) {
              Icon(Icons.Default.Check, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(16.dp).padding(top = 2.dp))
              Spacer(modifier = Modifier.width(8.dp))
              Column {
                Text(text = title, fontWeight = FontWeight.Bold, fontSize = 13.sp, color = MainText)
                Text(text = desc, fontSize = 12.sp, color = SecondaryText, lineHeight = 17.sp)
              }
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Founder Introduction Card
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f)),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "FOUNDER INTRODUCTION",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp
          )
          Spacer(modifier = Modifier.height(12.dp))

          Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
              painter = painterResource(id = R.drawable.img_founder_avatar_1793357693131),
              contentDescription = "Mohammad Amjad portrait",
              modifier = Modifier
                .size(68.dp)
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
              Text(
                text = "AMJark Digital",
                fontSize = 11.sp,
                color = SecondaryText
              )
            }
          }

          Spacer(modifier = Modifier.height(12.dp))

          Text(
            text = "Mohammad Amjad spearheads AMJark Digital with a steadfast commitment to high engineering standards, client collaboration, and modern product design. Under his leadership, the company delivers solutions that balance aesthetic finesse with enterprise robustness.",
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 20.sp
          )

          Spacer(modifier = Modifier.height(14.dp))

          Button(
            onClick = { onNavigate(Screen.Team) },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier.fillMaxWidth().height(42.dp)
          ) {
            Icon(Icons.Default.Groups, contentDescription = null, modifier = Modifier.size(16.dp))
            Spacer(modifier = Modifier.width(8.dp))
            Text("View Full Team & Departments", fontSize = 12.sp, fontWeight = FontWeight.Bold)
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}

@Composable
fun TeamScreen(
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit
) {
  val context = LocalContext.current

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
            text = "OUR TEAM & TALENT",
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            color = ElectricBlue,
            letterSpacing = 1.sp,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
          text = "Leadership & Departments",
          fontSize = 26.sp,
          fontWeight = FontWeight.Black,
          color = MainText
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Meet the executive leadership and technical departments driving AMJark Digital's product delivery, architectural standards, and design excellence.",
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
      // Founder Featured Card
      val founder = CompanyData.TEAM_MEMBERS.first { it.isFounder }
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.6f)),
        modifier = Modifier.fillMaxWidth().testTag("founder_team_card")
      ) {
        Column(modifier = Modifier.padding(20.dp)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
              painter = painterResource(id = R.drawable.img_founder_avatar_1793357693131),
              contentDescription = "${founder.name} photograph",
              modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .border(2.5.dp, ElectricBlue, CircleShape),
              contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
              Surface(
                color = PrimaryBlue.copy(alpha = 0.2f),
                shape = RoundedCornerShape(6.dp)
              ) {
                Text(
                  text = "FOUNDER & EXECUTIVE LEADER",
                  fontSize = 9.sp,
                  fontWeight = FontWeight.Bold,
                  color = ElectricBlue,
                  modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp)
                )
              }
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = founder.name,
                fontWeight = FontWeight.Black,
                fontSize = 20.sp,
                color = MainText
              )
              Text(
                text = founder.role,
                fontWeight = FontWeight.Bold,
                fontSize = 13.sp,
                color = ElectricBlue
              )
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = founder.bio,
            fontSize = 13.sp,
            color = SecondaryText,
            lineHeight = 21.sp
          )

          Spacer(modifier = Modifier.height(16.dp))
          HorizontalDivider(color = CardBorder)
          Spacer(modifier = Modifier.height(14.dp))

          // Links
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            OutlinedButton(
              onClick = {
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                  data = Uri.parse("mailto:${CompanyData.CONTACT_EMAIL}")
                  putExtra(Intent.EXTRA_SUBJECT, "Direct Inquiry for Mohammad Amjad")
                }
                context.startActivity(Intent.createChooser(intent, "Send Email"))
              },
              border = BorderStroke(1.dp, CardBorder),
              shape = RoundedCornerShape(8.dp),
              modifier = Modifier.weight(1f).height(40.dp)
            ) {
              Icon(Icons.Default.Email, contentDescription = null, tint = ElectricBlue, modifier = Modifier.size(14.dp))
              Spacer(modifier = Modifier.width(4.dp))
              Text("Email", fontSize = 11.sp, color = MainText)
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
              Spacer(modifier = Modifier.width(4.dp))
              Text("Website", fontSize = 11.sp, color = MainText)
            }
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))

      Text(
        text = "OPERATIONAL DEPARTMENTS",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )
      Spacer(modifier = Modifier.height(10.dp))

      // Department leads
      CompanyData.TEAM_MEMBERS.filter { !it.isFounder }.forEach { member ->
        Card(
          colors = CardDefaults.cardColors(containerColor = CardBackground),
          shape = RoundedCornerShape(14.dp),
          border = BorderStroke(1.dp, CardBorder),
          modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 5.dp)
        ) {
          Column(modifier = Modifier.padding(16.dp)) {
            Text(
              text = member.name,
              fontWeight = FontWeight.Bold,
              fontSize = 16.sp,
              color = MainText
            )
            Text(
              text = member.role,
              fontWeight = FontWeight.SemiBold,
              fontSize = 12.sp,
              color = ElectricBlue
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
              text = member.bio,
              fontSize = 12.sp,
              color = SecondaryText,
              lineHeight = 18.sp
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))
    AmjarkFooter(onNavigate = onNavigate, onOpenQuote = onOpenQuoteModal)
  }
}
