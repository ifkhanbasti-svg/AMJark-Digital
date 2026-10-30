package com.example.ui.navigation

sealed class Screen(val route: String, val title: String) {
  object Home : Screen("home", "Home")
  object About : Screen("about", "About Us")
  object Services : Screen("services", "Services")
  data class ServiceDetail(val slug: String) : Screen("services/$slug", "Service Details")
  object Projects : Screen("projects", "Projects")
  data class ProjectDetail(val slug: String) : Screen("projects/$slug", "Project Details")
  object Team : Screen("team", "Our Team")
  object Process : Screen("process", "Our Process")
  object Pricing : Screen("pricing", "Pricing & Quote")
  object Contact : Screen("contact", "Contact Us")
  object Faq : Screen("faq", "FAQ")
  object PrivacyPolicy : Screen("privacy-policy", "Privacy Policy")
  object Terms : Screen("terms", "Terms & Conditions")
}
