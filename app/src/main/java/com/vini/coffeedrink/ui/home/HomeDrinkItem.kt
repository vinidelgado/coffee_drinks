package com.vini.coffeedrink.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.vini.barista.R
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.ui.annotation.UiModePreviews
import com.vini.coffeedrink.ui.theme.AppTheme

@Composable
fun HomeDrinkItem(data: CoffeeDrinkItem) {
    Card(colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)) {
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
            Column {
                Text(
                    text = data.name,
                    modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    maxLines = 1
                )
                Text(
                    text = data.ingredients,
                    modifier = Modifier.padding(end = 8.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Light),
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