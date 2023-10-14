package com.vini.coffeedrink.data

class CoffeeDrinkItemMapper {

    fun map(coffeeDrink: CoffeeDrink): CoffeeDrinkItem {
        return CoffeeDrinkItem(
            id = coffeeDrink.id,
            name = coffeeDrink.name,
            imageUrl = coffeeDrink.imageUrl,
            ingredients = coffeeDrink.ingredients,
            description = coffeeDrink.description,
            isFavourite = coffeeDrink.isFavourite
        )
    }
}