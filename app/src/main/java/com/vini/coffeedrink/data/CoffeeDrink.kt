package com.vini.coffeedrink.data

import androidx.annotation.DrawableRes

data class CoffeeDrink(
    val id: Long,
    val name: String,
    @DrawableRes val imageUrl: Int,
    val description: String,
    val ingredients: String,
    val isFavourite: Boolean
)