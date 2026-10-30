package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.ContactSupport
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Folder
import androidx.compose.material.icons.outlined.Groups
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Layers
import androidx.compose.material.icons.outlined.Mail
import androidx.compose.material.icons.outlined.Payments
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.Timeline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.R
import com.example.data.CompanyData
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmjarkTopAppBar(
  currentScreen: Screen,
  onNavigate: (Screen) -> Unit,
  onOpenQuoteModal: () -> Unit,
  onOpenMenu: () -> Unit
) {
  Surface(
    color = MainBackground.copy(alpha = 0.95f),
    tonalElevation = 2.dp,
    border = BorderStroke(1.dp, CardBorder.copy(alpha = 0.6f))
  ) {
    TopAppBar(
      title = {
        Row(
          verticalAlignment = Alignment.CenterVertically,
          modifier = Modifier
            .clickable { onNavigate(Screen.Home) }
            .testTag("app_brand_logo_title")
        ) {
          Box(
            modifier = Modifier
              .size(36.dp)
              .clip(RoundedCornerShape(8.dp))
              .background(
                Brush.linearGradient(listOf(PrimaryBlue, ElectricBlue))
              )
              .border(1.dp, ElectricBlue.copy(alpha = 0.6f), RoundedCornerShape(8.dp)),
            contentAlignment = Alignment.Center
          ) {
            Image(
              painter = painterResource(id = R.drawable.ic_launcher_amjark_1793357664582),
              contentDescription = "AMJark Digital Logo",
              modifier = Modifier.size(34.dp).clip(RoundedCornerShape(7.dp))
            )
          }

          Spacer(modifier = Modifier.width(10.dp))

          Column {
            Text(
              text = "AMJARK",
              color = MainText,
              fontWeight = FontWeight.Black,
              fontSize = 17.sp,
              letterSpacing = 1.sp
            )
            Text(
              text = "DIGITAL",
              color = ElectricBlue,
              fontWeight = FontWeight.Bold,
              fontSize = 10.sp,
              letterSpacing = 2.sp
            )
          }
        }
      },
      actions = {
        Button(
          onClick = onOpenQuoteModal,
          colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryBlue,
            contentColor = Color.White
          ),
          shape = RoundedCornerShape(20.dp),
          contentPadding = androidx.compose.foundation.layout.PaddingValues(horizontal = 14.dp, vertical = 6.dp),
          modifier = Modifier
            .height(36.dp)
            .testTag("topbar_quote_button")
        ) {
          Icon(
            imageVector = Icons.Default.Calculate,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "Get a Quote",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold
          )
        }

        IconButton(
          onClick = onOpenMenu,
          modifier = Modifier
            .padding(start = 4.dp)
            .testTag("menu_drawer_button")
        ) {
          Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Open Navigation Menu",
            tint = MainText
          )
        }
      },
      colors = TopAppBarDefaults.topAppBarColors(
        containerColor = Color.Transparent
      )
    )
  }
}

@Composable
fun AmjarkBottomNavigation(
  currentScreen: Screen,
  onNavigate: (Screen) -> Unit
) {
  NavigationBar(
    containerColor = SecondaryBackground,
    tonalElevation = 6.dp,
    modifier = Modifier.border(BorderStroke(1.dp, CardBorder.copy(alpha = 0.5f)))
  ) {
    val items = listOf(
      Triple(Screen.Home, "Home", Icons.Outlined.Home),
      Triple(Screen.Services, "Services", Icons.Outlined.Layers),
      Triple(Screen.Projects, "Projects", Icons.Outlined.Folder),
      Triple(Screen.About, "About", Icons.Outlined.Info),
      Triple(Screen.Contact, "Contact", Icons.Outlined.Mail)
    )

    items.forEach { (screen, label, icon) ->
      val isSelected = when (screen) {
        Screen.Home -> currentScreen == Screen.Home
        Screen.Services -> currentScreen == Screen.Services || currentScreen is Screen.ServiceDetail
        Screen.Projects -> currentScreen == Screen.Projects || currentScreen is Screen.ProjectDetail
        Screen.About -> currentScreen == Screen.About || currentScreen == Screen.Team
        Screen.Contact -> currentScreen == Screen.Contact || currentScreen == Screen.Pricing
        else -> currentScreen == screen
      }

      NavigationBarItem(
        selected = isSelected,
        onClick = { onNavigate(screen) },
        icon = {
          Icon(
            imageVector = icon,
            contentDescription = label,
            modifier = Modifier.size(22.dp)
          )
        },
        label = {
          Text(
            text = label,
            fontSize = 11.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal
          )
        },
        colors = NavigationBarItemDefaults.colors(
          selectedIconColor = MainBackground,
          selectedTextColor = ElectricBlue,
          indicatorColor = ElectricBlue,
          unselectedIconColor = SecondaryText,
          unselectedTextColor = SecondaryText
        ),
        modifier = Modifier.testTag("bottom_nav_${screen.route}")
      )
    }
  }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmjarkNavigationMenuSheet(
  isOpen: Boolean,
  currentScreen: Screen,
  onDismiss: () -> Unit,
  onNavigate: (Screen) -> Unit,
  onOpenQuote: () -> Unit
) {
  if (isOpen) {
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(
      onDismissRequest = onDismiss,
      sheetState = sheetState,
      containerColor = SecondaryBackground,
      contentColor = MainText,
      tonalElevation = 8.dp
    ) {
      Column(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 20.dp, vertical = 12.dp)
          .verticalScroll(rememberScrollState())
      ) {
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
              modifier = Modifier
                .size(32.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(Brush.linearGradient(listOf(PrimaryBlue, ElectricBlue))),
              contentAlignment = Alignment.Center
            ) {
              Image(
                painter = painterResource(id = R.drawable.ic_launcher_amjark_1793357664582),
                contentDescription = null,
                modifier = Modifier.size(30.dp)
              )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column {
              Text(
                text = "AMJark Digital",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = MainText
              )
              Text(
                text = "Navigation Menu",
                fontSize = 11.sp,
                color = ElectricBlue
              )
            }
          }

          IconButton(onClick = onDismiss) {
            Icon(
              imageVector = Icons.Default.Close,
              contentDescription = "Close Menu",
              tint = SecondaryText
            )
          }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
          onClick = {
            onDismiss()
            onOpenQuote()
          },
          colors = ButtonDefaults.buttonColors(
            containerColor = PrimaryBlue,
            contentColor = Color.White
          ),
          shape = RoundedCornerShape(12.dp),
          modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .testTag("drawer_quote_cta")
        ) {
          Icon(Icons.Default.Calculate, contentDescription = null, modifier = Modifier.size(18.dp))
          Spacer(modifier = Modifier.width(8.dp))
          Text("Get a Custom Project Quote", fontWeight = FontWeight.Bold, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
          text = "CORE PAGES",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = MutedText,
          letterSpacing = 1.sp,
          modifier = Modifier.padding(bottom = 8.dp)
        )

        val corePages = listOf(
          Triple(Screen.Home, "Home", Icons.Outlined.Home),
          Triple(Screen.About, "About Us", Icons.Outlined.Info),
          Triple(Screen.Services, "Services", Icons.Outlined.Layers),
          Triple(Screen.Projects, "Projects & Portfolio", Icons.Outlined.Folder),
          Triple(Screen.Team, "Our Team", Icons.Outlined.Groups),
          Triple(Screen.Process, "Our Process", Icons.Outlined.Timeline),
          Triple(Screen.Pricing, "Pricing & Quotation", Icons.Outlined.Payments),
          Triple(Screen.Contact, "Contact Us", Icons.Outlined.Mail),
          Triple(Screen.Faq, "FAQ", Icons.Outlined.ContactSupport)
        )

        corePages.forEach { (screen, title, icon) ->
          MenuItemRow(
            title = title,
            icon = icon,
            isSelected = currentScreen == screen,
            onClick = {
              onDismiss()
              onNavigate(screen)
            }
          )
        }

        Spacer(modifier = Modifier.height(16.dp))
        HorizontalDivider(color = CardBorder)
        Spacer(modifier = Modifier.height(16.dp))

        Text(
          text = "LEGAL & COMPLIANCE",
          fontSize = 11.sp,
          fontWeight = FontWeight.Bold,
          color = MutedText,
          letterSpacing = 1.sp,
          modifier = Modifier.padding(bottom = 8.dp)
        )

        val legalPages = listOf(
          Triple(Screen.PrivacyPolicy, "Privacy Policy", Icons.Outlined.PrivacyTip),
          Triple(Screen.Terms, "Terms & Conditions", Icons.Outlined.Description)
        )

        legalPages.forEach { (screen, title, icon) ->
          MenuItemRow(
            title = title,
            icon = icon,
            isSelected = currentScreen == screen,
            onClick = {
              onDismiss()
              onNavigate(screen)
            }
          )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
          text = CompanyData.COPYRIGHT,
          fontSize = 11.sp,
          color = MutedText,
          modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))
      }
    }
  }
}

@Composable
fun MenuItemRow(
  title: String,
  icon: ImageVector,
  isSelected: Boolean,
  onClick: () -> Unit
) {
  Surface(
    onClick = onClick,
    color = if (isSelected) CardBackground else Color.Transparent,
    shape = RoundedCornerShape(10.dp),
    border = if (isSelected) BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f)) else null,
    modifier = Modifier
      .fillMaxWidth()
      .padding(vertical = 3.dp)
      .testTag("menu_item_${title.lowercase().replace(" ", "_")}")
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 14.dp, vertical = 12.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Icon(
        imageVector = icon,
        contentDescription = null,
        tint = if (isSelected) ElectricBlue else SecondaryText,
        modifier = Modifier.size(20.dp)
      )
      Spacer(modifier = Modifier.width(14.dp))
      Text(
        text = title,
        color = if (isSelected) ElectricBlue else MainText,
        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
        fontSize = 14.sp
      )
      Spacer(modifier = Modifier.weight(1f))
      Icon(
        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
        contentDescription = null,
        tint = if (isSelected) ElectricBlue else MutedText.copy(alpha = 0.6f),
        modifier = Modifier.size(16.dp)
      )
    }
  }
}

@Composable
fun AmjarkFooter(
  onNavigate: (Screen) -> Unit,
  onOpenQuote: () -> Unit
) {
  val context = LocalContext.current

  Surface(
    color = MainBackground,
    border = BorderStroke(1.dp, CardBorder),
    modifier = Modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 32.dp)
    ) {
      // Brand Header
      Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
          modifier = Modifier
            .size(40.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Brush.linearGradient(listOf(PrimaryBlue, ElectricBlue))),
          contentAlignment = Alignment.Center
        ) {
          Image(
            painter = painterResource(id = R.drawable.ic_launcher_amjark_1793357664582),
            contentDescription = null,
            modifier = Modifier.size(38.dp)
          )
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column {
          Text(
            text = CompanyData.COMPANY_NAME,
            fontWeight = FontWeight.Black,
            fontSize = 18.sp,
            color = MainText
          )
          Text(
            text = CompanyData.BRAND_TAGLINE,
            fontWeight = FontWeight.Medium,
            fontSize = 11.sp,
            color = ElectricBlue
          )
        }
      }

      Spacer(modifier = Modifier.height(14.dp))

      Text(
        text = CompanyData.BRAND_DESCRIPTION,
        color = SecondaryText,
        fontSize = 13.sp,
        lineHeight = 19.sp
      )

      Spacer(modifier = Modifier.height(20.dp))

      // Contact Fast Action Buttons
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        OutlinedButton(
          onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
              data = Uri.parse("mailto:${CompanyData.CONTACT_EMAIL}")
              putExtra(Intent.EXTRA_SUBJECT, "Project Inquiry — AMJark Digital")
            }
            context.startActivity(Intent.createChooser(intent, "Send Email"))
          },
          border = BorderStroke(1.dp, CardBorder),
          shape = RoundedCornerShape(10.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = ElectricBlue),
          modifier = Modifier.weight(1f).height(44.dp)
        ) {
          Icon(Icons.Default.Email, contentDescription = null, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("Email Us", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }

        OutlinedButton(
          onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CompanyData.WHATSAPP_LINK))
            context.startActivity(intent)
          },
          border = BorderStroke(1.dp, CardBorder),
          shape = RoundedCornerShape(10.dp),
          colors = ButtonDefaults.outlinedButtonColors(contentColor = ElectricBlue),
          modifier = Modifier.weight(1f).height(44.dp)
        ) {
          Icon(Icons.AutoMirrored.Filled.Chat, contentDescription = null, modifier = Modifier.size(16.dp))
          Spacer(modifier = Modifier.width(6.dp))
          Text("WhatsApp", fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
        }
      }

      Spacer(modifier = Modifier.height(24.dp))
      HorizontalDivider(color = CardBorder)
      Spacer(modifier = Modifier.height(20.dp))

      // Navigation Quick Links
      Text(
        text = "NAVIGATION",
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        color = ElectricBlue,
        letterSpacing = 1.sp
      )

      Spacer(modifier = Modifier.height(10.dp))

      val links = listOf(
        Pair("Home", Screen.Home),
        Pair("About Us", Screen.About),
        Pair("Services", Screen.Services),
        Pair("Projects & Portfolio", Screen.Projects),
        Pair("Our Team", Screen.Team),
        Pair("Our Process", Screen.Process),
        Pair("Pricing & Quotes", Screen.Pricing),
        Pair("Contact Us", Screen.Contact),
        Pair("FAQ", Screen.Faq)
      )

      links.chunked(2).forEach { rowPairs ->
        Row(
          modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
          horizontalArrangement = Arrangement.SpaceBetween
        ) {
          rowPairs.forEach { (label, screen) ->
            Text(
              text = "• $label",
              color = SecondaryText,
              fontSize = 13.sp,
              modifier = Modifier
                .clickable { onNavigate(screen) }
                .padding(vertical = 4.dp)
            )
          }
          if (rowPairs.size == 1) {
            Spacer(modifier = Modifier.weight(1f))
          }
        }
      }

      Spacer(modifier = Modifier.height(20.dp))
      HorizontalDivider(color = CardBorder)
      Spacer(modifier = Modifier.height(20.dp))

      // Founder Attribution & Legal Notice
      Text(
        text = "Leadership: ${CompanyData.FOUNDER_NAME} (${CompanyData.FOUNDER_TITLE})",
        color = MainText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 13.sp
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = "Official Domain: ${CompanyData.OFFICIAL_DOMAIN}",
        color = ElectricBlue,
        fontSize = 12.sp,
        modifier = Modifier.clickable {
          val intent = Intent(Intent.ACTION_VIEW, Uri.parse(CompanyData.OFFICIAL_DOMAIN))
          context.startActivity(intent)
        }
      )

      Spacer(modifier = Modifier.height(16.dp))

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
      ) {
        Text(
          text = "Privacy Policy",
          color = SecondaryText,
          fontSize = 12.sp,
          modifier = Modifier.clickable { onNavigate(Screen.PrivacyPolicy) }
        )
        Text(text = "•", color = MutedText, fontSize = 12.sp)
        Text(
          text = "Terms & Conditions",
          color = SecondaryText,
          fontSize = 12.sp,
          modifier = Modifier.clickable { onNavigate(Screen.Terms) }
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      Text(
        text = CompanyData.COPYRIGHT,
        color = MutedText,
        fontSize = 11.sp
      )
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun QuoteCalculatorDialog(
  isOpen: Boolean,
  onDismiss: () -> Unit,
  onProceedToContact: (service: String, summary: String) -> Unit
) {
  if (isOpen) {
    var selectedService by remember { mutableStateOf("App Development") }
    var selectedTier by remember { mutableStateOf("Standard Commercial") }
    val selectedAddons = remember { mutableStateOf(setOf("High Performance Optimization")) }

    val serviceOptions = listOf(
      "App Development",
      "Web Development",
      "Graphic & Creative Design",
      "AI & Automation",
      "Video Production",
      "Digital Solutions"
    )

    val tierOptions = listOf(
      Pair("MVP / Prototype", "Focused essential deliverables & rapid validation (2-4 weeks)"),
      Pair("Standard Commercial", "Full-featured production-ready release with testing (4-8 weeks)"),
      Pair("Advanced Enterprise", "Multi-tenant scale, cloud infrastructure & high SLA (8-14 weeks)")
    )

    val addonOptions = listOf(
      "AI & Automation Integration",
      "Multi-platform Support (Android & iOS / Web)",
      "Continuous Maintenance & Support SLA",
      "High Performance Optimization",
      "Design System & Brand Identity Kit"
    )

    Dialog(onDismissRequest = onDismiss) {
      Card(
        colors = CardDefaults.cardColors(containerColor = SecondaryBackground),
        shape = RoundedCornerShape(18.dp),
        border = BorderStroke(1.dp, ElectricBlue.copy(alpha = 0.5f)),
        modifier = Modifier
          .fillMaxWidth()
          .padding(8.dp)
      ) {
        Column(
          modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
          ) {
            Column {
              Text(
                text = "Project Quote Calculator",
                fontWeight = FontWeight.Bold,
                fontSize = 17.sp,
                color = MainText
              )
              Text(
                text = "Tailored project estimate by AMJark Digital",
                fontSize = 11.sp,
                color = ElectricBlue
              )
            }
            IconButton(onClick = onDismiss) {
              Icon(Icons.Default.Close, contentDescription = "Close", tint = SecondaryText)
            }
          }

          Spacer(modifier = Modifier.height(14.dp))

          Text(
            text = "1. Select Service Category",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(6.dp))

          FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
          ) {
            serviceOptions.forEach { service ->
              FilterChip(
                selected = selectedService == service,
                onClick = { selectedService = service },
                label = { Text(service, fontSize = 11.sp) },
                colors = FilterChipDefaults.filterChipColors(
                  selectedContainerColor = PrimaryBlue,
                  selectedLabelColor = Color.White,
                  containerColor = CardBackground,
                  labelColor = SecondaryText
                ),
                border = FilterChipDefaults.filterChipBorder(
                  enabled = true,
                  selected = selectedService == service,
                  borderColor = if (selectedService == service) ElectricBlue else CardBorder
                )
              )
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

          Text(
            text = "2. Project Scale & Tier",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(6.dp))

          tierOptions.forEach { (tier, desc) ->
            val isSelected = selectedTier == tier
            Surface(
              onClick = { selectedTier = tier },
              color = if (isSelected) PrimaryBlue.copy(alpha = 0.15f) else CardBackground,
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
                    .size(18.dp)
                    .clip(CircleShape)
                    .border(2.dp, if (isSelected) ElectricBlue else SecondaryText, CircleShape)
                    .background(if (isSelected) ElectricBlue else Color.Transparent),
                  contentAlignment = Alignment.Center
                ) {
                  if (isSelected) {
                    Icon(
                      Icons.Default.Check,
                      contentDescription = null,
                      tint = MainBackground,
                      modifier = Modifier.size(12.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                  Text(
                    text = tier,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 13.sp,
                    color = if (isSelected) ElectricBlue else MainText
                  )
                  Text(
                    text = desc,
                    fontSize = 11.sp,
                    color = SecondaryText
                  )
                }
              }
            }
          }

          Spacer(modifier = Modifier.height(16.dp))

          Text(
            text = "3. Select Desired Add-ons",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = MainText
          )
          Spacer(modifier = Modifier.height(6.dp))

          addonOptions.forEach { addon ->
            val isChecked = selectedAddons.value.contains(addon)
            Surface(
              onClick = {
                val current = selectedAddons.value.toMutableSet()
                if (isChecked) current.remove(addon) else current.add(addon)
                selectedAddons.value = current
              },
              color = CardBackground,
              shape = RoundedCornerShape(8.dp),
              border = BorderStroke(1.dp, if (isChecked) ElectricBlue.copy(alpha = 0.6f) else CardBorder),
              modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 3.dp)
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
                    Icon(
                      Icons.Default.Check,
                      contentDescription = null,
                      tint = MainBackground,
                      modifier = Modifier.size(12.dp)
                    )
                  }
                }
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                  text = addon,
                  fontSize = 12.sp,
                  color = if (isChecked) MainText else SecondaryText
                )
              }
            }
          }

          Spacer(modifier = Modifier.height(18.dp))

          // Summary Note (Honest, factual estimation without fake static pricing)
          Card(
            colors = CardDefaults.cardColors(containerColor = SurfaceContainerHigh),
            shape = RoundedCornerShape(10.dp),
            border = BorderStroke(1.dp, CardBorder)
          ) {
            Column(modifier = Modifier.padding(12.dp)) {
              Text(
                text = "Scope Summary:",
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = ElectricBlue
              )
              Text(
                text = "$selectedService ($selectedTier) with ${selectedAddons.value.size} add-on(s). Our engineering team prepares bespoke, itemized proposals based on exact specifications.",
                fontSize = 11.sp,
                color = SecondaryText,
                modifier = Modifier.padding(top = 4.dp)
              )
            }
          }

          Spacer(modifier = Modifier.height(18.dp))

          Button(
            onClick = {
              val summary = "Inquiry generated from Project Quote Calculator:\n" +
                "• Service Category: $selectedService\n" +
                "• Scale / Tier: $selectedTier\n" +
                "• Addons: ${if (selectedAddons.value.isEmpty()) "None" else selectedAddons.value.joinToString(", ")}\n" +
                "Please review and provide an itemized proposal."
              onProceedToContact(selectedService, summary)
            },
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryBlue),
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
              .fillMaxWidth()
              .height(48.dp)
              .testTag("quote_submit_inquiry_button")
          ) {
            Text("Request Detailed Quotation", fontWeight = FontWeight.Bold, fontSize = 13.sp)
            Spacer(modifier = Modifier.width(6.dp))
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = null, modifier = Modifier.size(16.dp))
          }
        }
      }
    }
  }
}
