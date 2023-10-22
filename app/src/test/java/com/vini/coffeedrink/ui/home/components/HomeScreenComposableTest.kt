package com.vini.coffeedrink.ui.home.components

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onRoot
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.ExperimentalRoborazziApi
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.RoborazziOptions
import com.github.takahirom.roborazzi.captureRoboImage
import com.vini.barista.R
import com.vini.coffeedrink.MainActivity
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.ui.home.HomeContent
import com.vini.coffeedrink.ui.home.HomeState
import com.vini.coffeedrink.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode

@OptIn(ExperimentalRoborazziApi::class)
@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(sdk = [33], qualifiers = RobolectricDeviceQualifiers.Pixel5)
class HomeScreenComposableTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule(MainActivity::class.java)

    @Test
    fun screenTest() {composeTestRule.activity.
        setContent {
            AppTheme {
                HomeContent(
                    HomeState.Success(
                        data = listOf(
                            CoffeeDrinkItem(
                                id = 12L,
                                name = "Teste",
                                imageUrl = R.drawable.ic_barista_frapuccino,
                                description = "Cortado is a beverage that consists of espresso mixed with a roughly equal amount of warm milk to reduce the acidity. ",
                                ingredients = "Espresso, Warm Milk",
                                isFavourite = false
                            ),
                            CoffeeDrinkItem(
                                id = 13L,
                                name = "Ristretto",
                                imageUrl = R.drawable.ic_barista_frapuccino,
                                description = "Ristretto is traditionally a short shot of espresso coffee made with the normal amount of ground coffee but extracted with about half the amount of water.",
                                ingredients = "Espresso",
                                isFavourite = false
                            ),
                            CoffeeDrinkItem(
                                id = 14L,
                                name = "Red Eye",
                                imageUrl = R.drawable.ic_barista_frapuccino,
                                description = "Red Eye is a coffee drink made by combining drip coffee with a shot of espresso.",
                                ingredients = "Drip Coffee, Espresso",
                                isFavourite = false
                            ),
                            CoffeeDrinkItem(
                                id = 15L,
                                name = "Breve",
                                imageUrl = R.drawable.ic_barista_frapuccino,
                                description = "Breve is an espresso-based coffee drink that is made with steamed half-and-half mixture of milk and cream.",
                                ingredients = "Espresso, Half-and-Half",
                                isFavourite = false
                            )
                        )
                    ), onCoffeeDrinkClicked = {

                    }
                )
            }
        }

        val methodName = Thread.currentThread().stackTrace[1].methodName
        val className = Thread.currentThread().stackTrace[1].className
        composeTestRule.onRoot().captureRoboImage(
            filePath = "src/test/screenshots/$className/${className}_${methodName}.png",
            roborazziOptions = RoborazziOptions(
                recordOptions =
                RoborazziOptions.RecordOptions(resizeScale = 0.5)
            )
        )
    }
}