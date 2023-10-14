package com.vini.coffeedrink.data

data class CoffeeDrinkItem(
    val id: Long,
    val name: String,
    val imageUrl: Int,
    val ingredients: String,
    val description: String,
    val isFavourite: Boolean
)