package com.vini.coffeedrink.ui.home.components

import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams
import com.vini.barista.R
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.ui.home.HomeDrinkItem
import com.vini.coffeedrink.ui.theme.AppTheme
import org.junit.Rule
import org.junit.Test

class HomeItemComposableTest {
    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.NEXUS_5.copy(softButtons = false),
        renderingMode = SessionParams.RenderingMode.SHRINK
    )

    @Test
    fun testScreenShotHomeItemComposableTest() {
        paparazzi.snapshot {
            AppTheme {
                HomeDrinkItem(
                    data = CoffeeDrinkItem(
                        id = 4L,
                        name = "Espresso Macchiato",
                        imageUrl = R.drawable.ic_barista_macchiato,
                        description = "Espresso Macchiato is a coffee beverage (a single or double espresso topped with a dollop of heated, foamed milk).",
                        ingredients = "Espresso, Foamed milk",
                        isFavourite = false
                    )
                )
            }
        }
    }
}