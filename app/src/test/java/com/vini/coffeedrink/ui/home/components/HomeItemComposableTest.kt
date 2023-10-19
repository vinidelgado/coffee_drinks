package com.vini.coffeedrink.ui.home.components

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.DEFAULT_ROBORAZZI_OUTPUT_DIR_PATH
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import com.vini.barista.R
import com.vini.coffeedrink.MainActivity
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.ui.home.HomeDrinkItem
import com.vini.coffeedrink.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [33], qualifiers = RobolectricDeviceQualifiers.Pixel5)
class HomeItemComposableTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    val directoryName = "MainActivityKtTest"

    @Test
    fun testComponent() {
        composeTestRule.setContent {
            AppTheme {
                HomeDrinkItem(
                    data = CoffeeDrinkItem(
                        id = 4L,
                        name = "Espresso Moccha",
                        imageUrl = R.drawable.ic_barista_macchiato,
                        description = "Espresso Macchiato is a coffee beverage (a single or double espresso topped with a dollop of heated, foamed milk).",
                        ingredients = "Espresso, Foamed milk",
                        isFavourite = false
                    )
                )
            }
        }

        val methodName = Thread.currentThread().stackTrace[1].methodName
        val className = Thread.currentThread().stackTrace[1].className
        composeTestRule.onRoot().captureRoboImage(
            filePath = "src/test/screenshots/$directoryName/${className}_${methodName}.png",
            roborazziOptions = RoborazziOptions(
                recordOptions =
                RoborazziOptions.RecordOptions(resizeScale = 0.5)
            )
        )
    }
}
