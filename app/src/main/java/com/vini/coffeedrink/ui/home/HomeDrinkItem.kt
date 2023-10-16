package com.vini.coffeedrink.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vini.barista.R
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.ui.annotation.UiModePreviews
import com.vini.coffeedrink.ui.theme.AppTheme
import com.vini.coffeedrink.ui.theme.primary_text_color_dark
import com.vini.coffeedrink.ui.theme.primary_text_color_light
import com.vini.coffeedrink.ui.theme.secondary_text_color

@Composable
fun HomeDrinkItem(data: CoffeeDrinkItem) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.onBackground)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = data.imageUrl),
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                contentDescription = null,
                modifier = Modifier
                    .size(52.dp)
                    .clip(shape = MaterialTheme.shapes.small),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.width(16.dp))
            val primaryTextColor = if (isSystemInDarkTheme()) {
                primary_text_color_dark
            } else {
                primary_text_color_light
            }
            Column {
                Text(
                    text = data.name,
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = primaryTextColor,
                    maxLines = 1
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    text = data.ingredients,
                    modifier = Modifier.padding(end = 4.dp),
                    color = secondary_text_color,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelSmall,
                )
            }
        }
    }
}

@UiModePreviews
@Composable
internal fun HomeDrinkItemPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
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