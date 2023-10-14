package com.vini.coffeedrink.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vini.coffeedrink.ui.annotation.UiModePreviews
import com.vini.coffeedrink.ui.theme.AppTheme
import com.vini.coffeedrink.ui.theme.seed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoffeeDrinkShortAppBar(text:String = "Coffee Drinks") {
    MediumTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(containerColor = seed),
        title = {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, start = 15.dp),
                text = text,
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                textAlign = TextAlign.Start
            )
        },
    )
}

@UiModePreviews
@Composable
fun CoffeeDrinkShortAppBarPreview() {
    AppTheme {
        CoffeeDrinkShortAppBar("Coffee Drinks")
    }
}