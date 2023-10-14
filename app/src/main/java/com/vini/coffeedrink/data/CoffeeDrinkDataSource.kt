package com.vini.coffeedrink.data

interface CoffeeDrinkDataSource {
    fun getCoffeeDrinks(): List<CoffeeDrink>
}