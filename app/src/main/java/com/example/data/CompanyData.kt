package com.example.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.DesignServices
import androidx.compose.material.icons.filled.Hub
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

data class ServiceCategory(
  val id: String,
  val slug: String,
  val title: String,
  val shortTagline: String,
  val icon: ImageVector,
  val subServices: List<String>,
  val overview: String,
  val benefits: List<String>,
  val deliverables: List<String>,
  val technologies: List<String>,
  val processSteps: List<String>
)

data class Project(
  val id: String,
  val slug: String,
  val title: String,
  val categoryId: String,
  val categoryName: String,
  val shortDescription: String,
  val fullDescription: String,
  val technologies: List<String>,
  val keyFeatures: List<String>,
  val architectureHighlights: List<String>,
  val isDemonstration: Boolean = true
)

data class ProcessStep(
  val stepNumber: Int,
  val title: String,
  val description: String,
  val deliverables: List<String>
)

data class TeamMember(
  val name: String,
  val role: String,
  val bio: String,
  val isFounder: Boolean = false,
  val linkedIn: String = "",
  val github: String = "",
  val twitter: String = "",
  val email: String = ""
)

data class FaqItem(
  val category: String,
  val question: String,
  val answer: String
)

data class ContactInquiry(
  val id: String,
  val name: String,
  val email: String,
  val phone: String = "",
  val company: String = "",
  val serviceCategory: String,
  val budgetRange: String = "",
  val projectDescription: String,
  val timestamp: Long = System.currentTimeMillis()
)

object CompanyData {
  const val COMPANY_NAME = "AMJark Digital"
  const val FOUNDER_NAME = "Mohammad Amjad"
  const val FOUNDER_TITLE = "Founder & CEO"
  const val BRAND_TAGLINE = "Build. Innovate. Transform."
  const val OFFICIAL_DOMAIN = "https://amjarkdigital.com"
  const val CONTACT_EMAIL = "contact@amjarkdigital.com"
  const val WHATSAPP_NUMBER = "+1 (555) 839-2041"
  const val WHATSAPP_LINK = "https://wa.me/15558392041"
  const val LOCATION = "Digital First • Global Reach"
  const val COPYRIGHT = "© 2026 AMJark Digital. All Rights Reserved."

  const val BRAND_DESCRIPTION =
    "AMJark Digital is a digital technology and creative company focused on developing innovative digital experiences, software solutions, applications, websites and creative brand identities."

  val CORE_PRINCIPLES = listOf(
    Pair("Creative Thinking", "Pushing creative boundaries to deliver distinctive brand identity and unforgettable digital design."),
    Pair("Modern Technology", "Architecting resilient, performant systems with contemporary frameworks, cloud computing, and AI."),
    Pair("User-Focused Development", "Prioritizing human ergonomics, intuitive navigation, accessibility, and high engagement."),
    Pair("Quality-Oriented Approach", "Enforcing strict code quality, continuous validation, security compliance, and meticulous polish."),
    Pair("Transparent Communication", "Fostering direct, transparent collaboration with structured milestones and zero ambiguity."),
    Pair("Continuous Improvement", "Iteratively refining products, adopting emerging technical paradigms, and scaling seamlessly.")
  )

  val SERVICES = listOf(
    ServiceCategory(
      id = "app-dev",
      slug = "app-development",
      title = "App Development",
      shortTagline = "Native & cross-platform mobile ecosystems engineered for scale.",
      icon = Icons.Default.PhoneAndroid,
      subServices = listOf(
        "Android applications (Native Jetpack Compose & Kotlin)",
        "iOS applications (Swift & SwiftUI)",
        "Cross-platform applications (Flutter / React Native)",
        "Custom software & enterprise client systems"
      ),
      overview = "We engineer native and cross-platform mobile applications that provide intuitive user experiences, blazing speed, and enterprise reliability. From concept to app store deployment, our engineering standards guarantee fluid gestures, offline durability, and elegant responsiveness.",
      benefits = listOf(
        "Modern edge-to-edge adaptive architecture for phones, foldables and tablets",
        "Reactive state management and robust offline-first synchronization",
        "Strict adherence to official Android & Apple design guidelines",
        "High performance rendering and optimized battery consumption"
      ),
      deliverables = listOf(
        "Production-ready APK, AAB, and iOS archive builds",
        "Clean, documented source code repository with CI/CD configuration",
        "App Store & Google Play submission packages",
        "Comprehensive API integration documentation & schemas"
      ),
      technologies = listOf("Kotlin", "Jetpack Compose", "Swift", "Flutter", "Kotlin Multiplatform", "Room / SQLite"),
      processSteps = listOf(
        "Platform Architecture & Technical Feasibility",
        "Interactive UI/UX Mobile Prototyping",
        "Core Feature Development & State Setup",
        "Device Matrix Testing & Store Optimization"
      )
    ),
    ServiceCategory(
      id = "web-dev",
      slug = "web-development",
      title = "Web Development",
      shortTagline = "High-performance digital web portals, web apps, and modern storefronts.",
      icon = Icons.Default.Code,
      subServices = listOf(
        "Business websites & corporate digital headquarters",
        "E-commerce websites & custom checkout workflows",
        "Portfolio websites & interactive case study hubs",
        "Web applications & SaaS portals",
        "Admin dashboards & telemetry control rooms"
      ),
      overview = "Our web engineering team designs bespoke, lightning-fast web solutions that merge architectural precision with fluid visual design. Every web solution is crafted to maximize Core Web Vitals, conversion rates, and search visibility.",
      benefits = listOf(
        "Zero-compromise speed and lightning-fast load times",
        "Semantic, accessible HTML & accessible UI controls",
        "Modular component-driven architectures built to scale",
        "Built-in search engine optimization and social metadata"
      ),
      deliverables = listOf(
        "Full-stack responsive application codebase",
        "Dynamic content management and administrative dashboard",
        "Integrated analytics, SEO tags, sitemaps, and robots configuration",
        "Automated deployment workflows and cloud hosting configuration"
      ),
      technologies = listOf("React", "Next.js", "TypeScript", "Tailwind CSS", "Node.js", "GraphQL", "PostgreSQL"),
      processSteps = listOf(
        "Information Architecture & Sitemap Planning",
        "Responsive Wireframing & Design System Creation",
        "Frontend & Backend API Implementation",
        "Speed Optimization & Production Deployment"
      )
    ),
    ServiceCategory(
      id = "creative-design",
      slug = "creative-design",
      title = "Graphic & Creative Design",
      shortTagline = "Memorable visual identities, brand systems, and creative digital assets.",
      icon = Icons.Default.DesignServices,
      subServices = listOf(
        "Logo design & brand symbol craftsmanship",
        "Brand identity & full visual style guidelines",
        "Social media graphics & visual communication packages",
        "Posters, banners, and digital marketing materials",
        "YouTube thumbnails & high-impact content covers"
      ),
      overview = "Design is the visual signature of your brand's ethos. We craft distinctive identities that resonate with your audience, establish instant credibility, and convey clarity across digital and physical touchpoints.",
      benefits = listOf(
        "Cohesive visual language across all platforms and collateral",
        "Custom vector logomarks with versatile horizontal, stacked and icon variations",
        "Comprehensive brand book including color codes, typography, and usage rules",
        "High-resolution vector assets prepared for print and screen"
      ),
      deliverables = listOf(
        "Master vector files (.AI, .EPS, .SVG, .PDF)",
        "Complete Brand Guidelines book",
        "Social media kit with standardized templates",
        "Print-ready promotional collateral packages"
      ),
      technologies = listOf("Figma", "Adobe Illustrator", "Photoshop", "Vector Systems", "Design Tokens"),
      processSteps = listOf(
        "Brand Discovery & Visual Exploration",
        "Concept Sketching & Vector Refinement",
        "Design System & Color Theory Application",
        "Final Asset Packaging & Brand Guideline Delivery"
      )
    ),
    ServiceCategory(
      id = "ai-automation",
      slug = "ai-automation",
      title = "AI & Automation",
      shortTagline = "Intelligent workflows, custom AI integrations, and automated pipelines.",
      icon = Icons.Default.AutoAwesome,
      subServices = listOf(
        "AI integrations & enterprise language models",
        "Intelligent applications & conversational engines",
        "Workflow automation & event-driven pipelines",
        "Custom AI solutions & internal operations acceleration"
      ),
      overview = "Harness the power of machine intelligence to eliminate manual bottlenecks, enhance customer interactions, and unlock intelligent data synthesis. We deliver production-grade AI integrations with robust error handling and verifiable output.",
      benefits = listOf(
        "Significant reduction in repetitive manual tasks and operational costs",
        "Smart data synthesis, retrieval-augmented search, and contextual assistance",
        "Secure credential management and privacy-respecting architectures",
        "Real-time monitoring, rate limit handling, and graceful degradation"
      ),
      deliverables = listOf(
        "Integrated AI microservices with secure endpoint routing",
        "Automated workflow scripts and trigger pipelines",
        "Evaluation test suites for prompt and model output stability",
        "Administration dashboard for prompt management and usage tracking"
      ),
      technologies = listOf("Gemini API", "Python", "LangChain", "Vector Databases", "Cloud Functions", "REST / gRPC"),
      processSteps = listOf(
        "Workflow Analysis & AI Opportunity Mapping",
        "Prompt Engineering & Schema Definition",
        "Pipeline Integration & Security Hardening",
        "Accuracy Benchmarking & Production Rollout"
      )
    ),
    ServiceCategory(
      id = "video-production",
      slug = "video-production",
      title = "Video Production",
      shortTagline = "High-impact video storytelling, promotional reels, and motion design.",
      icon = Icons.Default.VideoLibrary,
      subServices = listOf(
        "Professional video editing & post-production",
        "Promotional videos & product launch films",
        "Reels, Shorts, and vertical social content",
        "Motion graphics & animated interface demos"
      ),
      overview = "Video is the most captivating medium in digital marketing. We deliver cinematic, dynamic motion design and video editing that capture viewer attention within the first three seconds and drive meaningful action.",
      benefits = listOf(
        "Fast-paced, narrative-driven editing tailored for high viewer retention",
        "Custom kinetic typography, sound design, and color grading",
        "Multi-aspect ratio formatting (16:9 widescreen, 9:16 vertical, 1:1 square)",
        "Seamless integration with company branding and audio signatures"
      ),
      deliverables = listOf(
        "Full HD and 4K Master Exports in ProRes and MP4",
        "Platform-specific cutdowns (Reels, TikTok, YouTube Shorts)",
        "Animated logo stingers and lower-third graphic templates",
        "Royalty-free licensed soundtrack and sound effects mix"
      ),
      technologies = listOf("After Effects", "Premiere Pro", "DaVinci Resolve", "Blender", "Motion Graphics"),
      processSteps = listOf(
        "Storyboarding & Creative Treatment",
        "Footage Ingestion, Assembly & Rough Cut",
        "Color Grading, Sound Design & Motion Graphics",
        "Final Multi-Resolution Master Delivery"
      )
    ),
    ServiceCategory(
      id = "digital-solutions",
      slug = "digital-solutions",
      title = "Digital Solutions",
      shortTagline = "Strategic digital transformation, technology consulting, and custom products.",
      icon = Icons.Default.Hub,
      subServices = listOf(
        "Digital consulting & technical roadmapping",
        "Business technology solutions & system modernization",
        "Custom digital products & specialized SaaS tooling"
      ),
      overview = "Navigating modern digital infrastructure requires holistic strategic vision and engineering expertise. AMJark Digital partners with forward-thinking organizations to assess digital readiness, modernize legacy systems, and build custom digital products.",
      benefits = listOf(
        "Actionable technical roadmaps aligned with business objectives",
        "Audit reports uncovering performance bottlenecks and security gaps",
        "Vendor-neutral architecture selection designed for long-term scalability",
        "Direct access to senior engineering and design leadership"
      ),
      deliverables = listOf(
        "Comprehensive Architecture Blueprint & Strategy Document",
        "Technology Stack Recommendation & Migration Plan",
        "Proof of Concept (PoC) Prototype implementation",
        "Quarterly Technology Advisory & Roadmap Reviews"
      ),
      technologies = listOf("Cloud Architectures", "Microservices", "API Gateways", "Enterprise DevOps", "Security Auditing"),
      processSteps = listOf(
        "Organizational Discovery & Technology Audit",
        "Strategic Solution Architecture & Scoping",
        "Phased Implementation & Validation",
        "Knowledge Transfer & Operational Handover"
      )
    )
  )

  val PROJECTS = listOf(
    Project(
      id = "p-1",
      slug = "nexus-erp-mobile",
      title = "Nexus ERP Mobile Suite",
      categoryId = "app-dev",
      categoryName = "App Development",
      shortDescription = "Modern inventory tracking and logistics management suite with offline synchronization.",
      fullDescription = "Nexus ERP is a demonstration enterprise mobility solution engineered to show our architectural capability in building high-performance, offline-first mobile applications. Built using Kotlin and Jetpack Compose, the system delivers real-time warehouse scanning, batch verification, and background synchronization with enterprise resource servers.",
      technologies = listOf("Kotlin", "Jetpack Compose", "Room DB", "Coroutines Flow", "M3 Design"),
      keyFeatures = listOf(
        "Instant local caching with conflict-free background synchronization",
        "Barcode / QR code camera scanning engine",
        "Dynamic multi-warehouse stock telemetry and heatmaps",
        "Biometric authentication and role-based operational permissions"
      ),
      architectureHighlights = listOf(
        "Clean Architecture with strict repository and use-case separation",
        "Zero-lag rendering across low-memory Android devices",
        "Modular Gradle structure for rapid testing and independent feature deployments"
      )
    ),
    Project(
      id = "p-2",
      slug = "pulse-ai-analytics",
      title = "Pulse AI Analytics Hub",
      categoryId = "ai-automation",
      categoryName = "AI & Automation",
      shortDescription = "Real-time intelligent telemetry hub with automated anomaly detection and predictive summaries.",
      fullDescription = "Pulse AI is a demonstration analytics dashboard built to exhibit our capabilities in integrating machine intelligence with enterprise telemetry. It consumes incoming event streams, computes trend anomalies, and synthesizes executive bullet points using structured generative AI endpoints.",
      technologies = listOf("Gemini AI API", "TypeScript", "Next.js", "Tailwind CSS", "WebSockets"),
      keyFeatures = listOf(
        "Automated natural language executive briefings generated on demand",
        "Live sensor and transaction stream monitoring",
        "Custom rule-based triggers and automated Slack / Email alerts",
        "Interactive data visualizations and predictive trend forecasting"
      ),
      architectureHighlights = listOf(
        "Resilient rate-limiting and fallback model routing",
        "End-to-end type safety with strict schema validation",
        "Sub-100ms streaming responses via WebSocket channels"
      )
    ),
    Project(
      id = "p-3",
      slug = "aura-creative-brand",
      title = "Aura Creative Brand Identity",
      categoryId = "creative-design",
      categoryName = "Graphic & Creative Design",
      shortDescription = "Complete corporate identity system, geometric logo architecture, and digital design tokens.",
      fullDescription = "Aura represents AMJark Digital's meticulous creative design ethos. This brand demonstration demonstrates the construction of an entire corporate visual language, from mathematical golden-ratio vector mark construction to multi-platform digital design token systems.",
      technologies = listOf("Figma", "Adobe Illustrator", "Design Tokens", "Typography Systems"),
      keyFeatures = listOf(
        "Adaptive vector logomark functional at 16px favicon up to billboard scale",
        "Harmonious 12-color semantic palette optimized for dark and light modes",
        "Complete typography hierarchy with custom line-height and letter-spacing standards",
        "Comprehensive brand playbook detailing correct and incorrect brand applications"
      ),
      architectureHighlights = listOf(
        "Vector-perfect SVG paths with minimal anchor points",
        "Design tokens exported directly to CSS and Compose theme files",
        "Accessible contrast compliance across all text/background pairings"
      )
    ),
    Project(
      id = "p-4",
      slug = "aerocommerce-storefront",
      title = "AeroCommerce Multi-Tenant Storefront",
      categoryId = "web-dev",
      categoryName = "Web Development",
      shortDescription = "Next-generation headless e-commerce storefront delivering instant page loads and seamless checkout.",
      fullDescription = "AeroCommerce is a high-speed demonstration storefront showcasing modern headless commerce architecture. Engineered for high-conversion brands, it decouples the presentation layer to deliver near-instant page transitions, instant search, and streamlined multi-step checkout.",
      technologies = listOf("React", "Next.js App Router", "Tailwind CSS", "Stripe API", "Edge Functions"),
      keyFeatures = listOf(
        "Sub-second global time to first byte via edge rendering",
        "Instant predictive search with autocomplete and filter faceting",
        "Optimized one-page checkout flow with automatic address validation",
        "Dynamic cart persistence and multi-currency calculation"
      ),
      architectureHighlights = listOf(
        "Server-side rendering with incremental static regeneration",
        "Zero-layout-shift image optimization and responsive picture elements",
        "Full test coverage for payment and order dispatch routines"
      )
    ),
    Project(
      id = "p-5",
      slug = "vivid-motion-showcase",
      title = "Vivid Motion Brand Video Reel",
      categoryId = "video-production",
      categoryName = "Video Production",
      shortDescription = "Kinetic typography, 3D product motion graphics, and high-retention promotional sequence.",
      fullDescription = "Vivid Motion demonstrates AMJark Digital's post-production and motion graphics capabilities. Featuring dynamic 3D camera sweeps, kinetic typography, and precision beat-matched sound effects, this production showcases how video assets elevate brand authority.",
      technologies = listOf("After Effects", "Blender 3D", "Premiere Pro", "Sound Engineering"),
      keyFeatures = listOf(
        "Pacing engineered for 80%+ viewer retention in the first 5 seconds",
        "Seamless match cuts between UI mockups and 3D device renders",
        "Custom sound design layered with Foley and cinematic impacts",
        "Ready-to-deploy vertical (9:16) and widescreen (16:9) master exports"
      ),
      architectureHighlights = listOf(
        "Color-accurate ACES color management pipeline",
        "Modular project structure enabling fast text/asset swaps",
        "Optimized compression settings preserving fine line clarity"
      )
    ),
    Project(
      id = "p-6",
      slug = "omnicloud-enterprise",
      title = "OmniCloud Business Architecture",
      categoryId = "digital-solutions",
      categoryName = "Digital Solutions",
      shortDescription = "Cloud migration blueprint and microservice modernization framework for enterprise scalability.",
      fullDescription = "OmniCloud represents our consultative technical capabilities. This architectural demonstration illustrates how legacy monolithic systems are broken down into resilient, containerized microservices with zero downtime, comprehensive observability, and automated disaster recovery.",
      technologies = listOf("Docker", "Kubernetes", "Terraform", "Prometheus", "Cloud Architecture"),
      keyFeatures = listOf(
        "Infrastructure as Code templates for automated multi-region deployment",
        "Zero-trust network architecture with mutual TLS between services",
        "Comprehensive OpenTelemetry distributed tracing and metrics dashboards",
        "Automated backup and failover testing pipelines"
      ),
      architectureHighlights = listOf(
        "High availability SLA design target of 99.99%",
        "Reduced cloud consumption costs through intelligent autoscaling",
        "Documented disaster recovery runbooks with under 5-minute RPO/RTO"
      )
    )
  )

  val PROCESS_STEPS = listOf(
    ProcessStep(
      stepNumber = 1,
      title = "Understanding Requirements",
      description = "We initiate every project with a thorough discovery session. We analyze your core business objectives, audience expectations, technical constraints, and long-term targets to construct an actionable project blueprint.",
      deliverables = listOf("Project Scope Document", "Technical Requirements Specification", "Milestone Roadmap")
    ),
    ProcessStep(
      stepNumber = 2,
      title = "Research & Planning",
      description = "Our team conducts competitive landscape research, analyzes architectural trade-offs, and designs database schemas, API structures, and technology stacks tailored to your project's performance criteria.",
      deliverables = listOf("Architecture Blueprint", "Data Schema Models", "Technical Stack Matrix")
    ),
    ProcessStep(
      stepNumber = 3,
      title = "Design & Prototyping",
      description = "We craft intuitive, human-centered UI/UX prototypes that reflect your brand ethos. Interactive wireframes allow you to experience user journeys, test ergonomics, and iterate before writing production code.",
      deliverables = listOf("Figma Interactive Prototype", "Design System Tokens", "User Journey Flowcharts")
    ),
    ProcessStep(
      stepNumber = 4,
      title = "Development",
      description = "Using modern development practices, clean modular architecture, and rigorous version control, our engineers write clean, maintainable, and type-safe code that adheres to industry standards.",
      deliverables = listOf("Modular Source Code", "CI/CD Deployment Pipelines", "Sprint Progress Demos")
    ),
    ProcessStep(
      stepNumber = 5,
      title = "Testing & Quality Assurance",
      description = "Every release undergoes comprehensive quality assurance: unit tests, UI testing, security audits, accessibility verifications, and stress testing across devices and network conditions.",
      deliverables = listOf("QA Audit Report", "Accessibility & Performance Pass", "Cross-Device Verification")
    ),
    ProcessStep(
      stepNumber = 6,
      title = "Delivery & Support",
      description = "We deploy your product to production servers or app stores with zero downtime. We conduct thorough knowledge transfer and provide post-launch maintenance, monitoring, and iterative enhancements.",
      deliverables = listOf("Production Deployment", "Operations Runbook", "Ongoing Maintenance & SLA Support")
    )
  )

  val TEAM_MEMBERS = listOf(
    TeamMember(
      name = FOUNDER_NAME,
      role = FOUNDER_TITLE,
      bio = "Mohammad Amjad founded AMJark Digital with the vision of uniting cutting-edge software engineering with refined visual craft. Leading the organization's strategic vision, technology roadmap, and commitment to client excellence, he drives the development of transformative digital products.",
      isFounder = true,
      linkedIn = "https://linkedin.com",
      github = "https://github.com",
      twitter = "https://twitter.com",
      email = CONTACT_EMAIL
    ),
    TeamMember(
      name = "Software Engineering & Architecture",
      role = "Core Engineering Department",
      bio = "Our engineering department is comprised of dedicated mobile, web, and cloud engineers who specialize in Kotlin, Jetpack Compose, TypeScript, microservices, and AI integrations, focusing on high availability and clean architecture.",
      isFounder = false
    ),
    TeamMember(
      name = "Creative & Brand Design Studio",
      role = "UI/UX & Brand Design Department",
      bio = "Our creative studio shapes the visual voice of our digital products. With deep expertise in design systems, typography, vector branding, and interactive motion, they ensure every product is aesthetically captivating.",
      isFounder = false
    ),
    TeamMember(
      name = "Quality Assurance & DevOps",
      role = "QA & Infrastructure Operations",
      bio = "Guarantors of software stability and rapid deployment. This team manages automated CI/CD pipelines, container orchestration, zero-downtime releases, and comprehensive regression test suites.",
      isFounder = false
    )
  )

  val FAQS = listOf(
    FaqItem(
      category = "Services",
      question = "What core services does AMJark Digital provide?",
      answer = "AMJark Digital provides six specialized service categories: App Development (Android, iOS, Cross-platform, custom software), Web Development (corporate websites, web apps, e-commerce, dashboards), Graphic & Creative Design (branding, logo design, marketing collateral), AI & Automation (AI integrations, intelligent apps, workflow automation), Video Production (commercial editing, reels, motion graphics), and Digital Solutions (strategic consulting and custom enterprise products)."
    ),
    FaqItem(
      category = "Project Timelines",
      question = "How long does a typical project take from start to delivery?",
      answer = "Timelines depend on project complexity, scope, and requested deliverables. A focused website or brand identity typically spans 2 to 4 weeks, while a comprehensive mobile application or custom enterprise software solution usually spans 6 to 12 weeks. We provide a detailed milestone roadmap with clear delivery dates during the planning phase."
    ),
    FaqItem(
      category = "Pricing & Quotes",
      question = "How are project prices determined?",
      answer = "Because every digital project has distinct technical specifications and design requirements, we do not believe in rigid, one-size-fits-all pricing. We offer tailored quotes based on scope, feature complexity, third-party integrations, and timeline. You can submit your requirements via our 'Get a Quote' tool or contact us directly for an itemized estimate."
    ),
    FaqItem(
      category = "Custom Development",
      question = "Do you build custom solutions from scratch or use templates?",
      answer = "We engineer bespoke, custom solutions tailored specifically to each client's unique operational needs and brand identity. We do not use generic, cookie-cutter templates. Every line of code and visual asset is created to ensure optimal performance, security, and distinction."
    ),
    FaqItem(
      category = "Revisions",
      question = "What is your revision and feedback policy during development?",
      answer = "We operate through iterative, transparent milestones. During the design and prototyping phases, you have dedicated review rounds to test ergonomics, typography, and layout. Development proceeds in agile sprints with regular staging demonstrations, ensuring adjustments are incorporated well before the final release."
    ),
    FaqItem(
      category = "Payments",
      question = "What are your payment terms and milestones?",
      answer = "Standard contracts are structured around transparent milestone-based payments (for example, an initial kickoff deposit, milestone completion stages, and final handover upon sign-off). All terms, schedules, and deliverables are clearly documented in the project agreement prior to starting."
    ),
    FaqItem(
      category = "Maintenance",
      question = "Do you provide post-launch maintenance and technical support?",
      answer = "Yes. Following launch, we provide comprehensive warranty support to guarantee smooth operation. We also offer ongoing maintenance agreements (SLAs) covering security patches, dependency updates, OS compatibility checks (such as new Android/iOS versions), server monitoring, and feature enhancements."
    ),
    FaqItem(
      category = "Project Inquiries",
      question = "How do I start a new project with AMJark Digital?",
      answer = "You can start immediately by navigating to our Contact Us or Get a Quote screen. Select your service interest, share a brief overview of your goals and timeline, and our team will get in touch to schedule an initial discovery consultation."
    )
  )

  val PRIVACY_POLICY = """
    AMJark Digital — Privacy Policy
    Last Updated: 2026

    1. Commitment to Privacy
    AMJark Digital ("we", "our", or "us"), founded by Mohammad Amjad, is dedicated to safeguarding your personal data and upholding high standards of privacy and transparency. This Privacy Policy outlines how we collect, process, and protect information when you visit our website (https://amjarkdigital.com), communicate with us, or utilize our corporate digital applications.

    2. Information We Collect
    We collect information that you voluntarily provide when you submit a project inquiry, request a quote, or contact our team. This may include:
    - Contact Information: Full name, professional email address, telephone number, and company name.
    - Project Details: Service requirements, estimated budget parameters, project timelines, and technical notes.
    - Technical Diagnostics: Standard network logs, application performance data, and device characteristics necessary to ensure application security and stability.

    3. How We Use Your Information
    Information collected is utilized exclusively for genuine business purposes:
    - To evaluate your project requirements and prepare accurate quotations.
    - To communicate regarding project status, milestones, and technical inquiries.
    - To maintain the security, integrity, and operational availability of our services.
    - To comply with applicable legal obligations and enforce contractual terms.

    4. Data Protection & Confidentiality
    We implement enterprise-grade security protocols, encryption in transit and at rest, and strict access control mechanisms. We never sell, rent, or trade your personal information to third parties. Information shared with us is treated with strict confidentiality.

    5. Third-Party Services
    We may utilize trusted infrastructure providers (such as secure cloud hosting and communication gateways) strictly to deliver our services. These providers are bound by confidentiality agreements and privacy standards.

    6. Your Rights
    You maintain the right to access, rectify, or request the deletion of your personal data held by AMJark Digital. To exercise these rights, please contact our privacy representative at contact@amjarkdigital.com.
  """.trimIndent()

  val TERMS_AND_CONDITIONS = """
    AMJark Digital — Terms & Conditions
    Last Updated: 2026

    1. Acceptance of Terms
    By accessing or using the digital services, applications, and web properties of AMJark Digital (https://amjarkdigital.com), you acknowledge and agree to be bound by these Terms and Conditions. If you do not agree with any portion of these terms, please refrain from using our platforms.

    2. Intellectual Property Rights
    All materials published by AMJark Digital—including software source code, visual branding, logos, trademarks, design systems, and documentation—are the exclusive intellectual property of AMJark Digital and are protected by applicable intellectual property laws. Deliverables developed for clients are governed by explicit individual service agreements.

    3. Service Inquiries & Quotations
    Submitting an inquiry or utilizing the Quote Calculator within our platforms constitutes a preliminary request for information and does not establish a binding contract. Formal engagements commence only upon mutual execution of a Master Services Agreement (MSA) and Statement of Work (SOW).

    4. Acceptable Use
    You agree to use our digital applications strictly for lawful purposes. You shall not attempt to reverse engineer, disrupt server integrity, transmit malicious software, or compromise security perimeters of AMJark Digital infrastructure.

    5. Limitation of Liability
    AMJark Digital provides this corporate application on an "as is" and "as available" basis. While we strive for uncompromising accuracy and uptime, AMJark Digital shall not be liable for indirect, incidental, or consequential damages resulting from platform use.

    6. Governing Law
    These terms shall be governed by and construed in accordance with applicable laws governing commercial business operations.

    7. Contact Information
    For inquiries regarding these Terms and Conditions, please contact:
    Email: contact@amjarkdigital.com
    Official Website: https://amjarkdigital.com
  """.trimIndent()
}
