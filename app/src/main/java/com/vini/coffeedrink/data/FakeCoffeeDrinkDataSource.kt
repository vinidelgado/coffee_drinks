package com.vini.coffeedrink.data

import com.vini.barista.R

class FakeCoffeeDrinkDataSource : CoffeeDrinkDataSource {

    override fun getCoffeeDrinks(): List<CoffeeDrink> {
        return mutableListOf(
            CoffeeDrink(
                id = 1L,
                name = "Americano",
                imageUrl = R.drawable.ic_barista_americano,
                description = "Americano is a type of coffee drink prepared by diluting an espresso with hot water, giving it a similar strength to, but different flavour from, traditionally brewed coffee. ",
                ingredients = "Espresso, Water",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 2L,
                name = "Cappuccino",
                imageUrl = R.drawable.ic_barista_capuccino,
                description = "Cappuccino is a coffee drink that is composed of double espresso and hot milk, with the surface topped with foamed milk.",
                ingredients = "Espresso, Steamed Milk, Milk Foam",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 3L,
                name = "Latte",
                imageUrl = R.drawable.ic_barista_macchiato,
                description = "Latte is a coffee drink made with espresso and steamed milk. It's typically topped with a small amount of milk foam.",
                ingredients = "Espresso, Steamed Milk",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 4L,
                name = "Mocha",
                imageUrl = R.drawable.ic_barista_mocca,
                description = "Mocha is a coffee drink that combines espresso with hot milk and chocolate. It is topped with whipped cream.",
                ingredients = "Espresso, Hot Milk, Chocolate, Whipped Cream",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 5L,
                name = "Espresso Macchiato",
                imageUrl = R.drawable.ic_barista_macchiato,
                description = "Espresso Macchiato is a coffee drink with a shot of espresso topped with a small amount of milk.",
                ingredients = "Espresso, Milk",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 6L,
                name = "Flat White",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Flat White is a coffee drink prepared by pouring microfoam (steamed milk with small, fine bubbles and a glossy or velvety consistency) over a shot of espresso.",
                ingredients = "Espresso, Microfoam",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 7L,
                name = "Affogato",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Affogato is a coffee-based dessert. It usually takes the form of a scoop of vanilla gelato or ice cream topped or 'drowned' with a shot of hot espresso.",
                ingredients = "Espresso, Vanilla Gelato",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 8L,
                name = "Turkish Coffee",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Turkish coffee is a method of preparing unfiltered coffee. Finely powdered coffee beans are boiled in a pot, with added sugar, and served in a cup where the grounds are allowed to settle.",
                ingredients = "Finely powdered coffee beans, Sugar",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 9L,
                name = "Irish Coffee",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Irish coffee is a cocktail consisting of hot coffee, Irish whiskey, and sugar, stirred, and topped with cream.",
                ingredients = "Coffee, Irish Whiskey, Sugar, Cream",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 10L,
                name = "Vienna",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Vienna coffee is the name of a popular traditional cream-based coffee beverage. ",
                ingredients = "Coffee, Whipped Cream",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 11L,
                name = "Espresso Con Panna",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Espresso Con Panna is a shot of espresso topped with whipped cream.",
                ingredients = "Espresso, Whipped Cream",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 12L,
                name = "Cortado",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Cortado is a beverage that consists of espresso mixed with a roughly equal amount of warm milk to reduce the acidity. ",
                ingredients = "Espresso, Warm Milk",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 13L,
                name = "Ristretto",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Ristretto is traditionally a short shot of espresso coffee made with the normal amount of ground coffee but extracted with about half the amount of water.",
                ingredients = "Espresso",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 14L,
                name = "Red Eye",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Red Eye is a coffee drink made by combining drip coffee with a shot of espresso.",
                ingredients = "Drip Coffee, Espresso",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 15L,
                name = "Breve",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Breve is an espresso-based coffee drink that is made with steamed half-and-half mixture of milk and cream.",
                ingredients = "Espresso, Half-and-Half",
                isFavourite = false
            )
        )
    }
}