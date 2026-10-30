package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.CompanyData
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("AMJark Digital", appName)
  }

  @Test
  fun `verify company data model contains 6 core services`() {
    assertEquals(6, CompanyData.SERVICES.size)
    assertEquals("Mohammad Amjad", CompanyData.FOUNDER_NAME)
    assertEquals("Build. Innovate. Transform.", CompanyData.BRAND_TAGLINE)
    assertTrue(CompanyData.PROJECTS.isNotEmpty())
  }
}
