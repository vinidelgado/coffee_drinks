package com.vini.coffeedrink.navigation

sealed class ScreenRoutes(val route: String) {
    object HomeScreen : ScreenRoutes("home_screen")
    object CoffeeDrinkDetailScreen : ScreenRoutes("coffee_drink_detail_screen")
}