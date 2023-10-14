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
                description = "A cappuccino is an espresso-based coffee drink that originated in Italy, and is traditionally prepared with steamed milk foam.",
                ingredients = "Espresso, Steamed milk foam",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 3L,
                name = "Espresso",
                imageUrl = R.drawable.ic_barista_espresso,
                description = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
                ingredients = "Ground coffee, Water",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 4L,
                name = "Espresso Macchiato",
                imageUrl = R.drawable.ic_barista_macchiato,
                description = "Espresso Macchiato is a coffee beverage (a single or double espresso topped with a dollop of heated, foamed milk).",
                ingredients = "Espresso, Foamed milk",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 5L,
                name = "Frappino",
                imageUrl = R.drawable.ic_barista_frapuccino,
                description = "Frappino is a blended coffee drinks. It consists of coffee base, blended with ice and other various ingredients, usually topped with whipped cream.",
                ingredients = "Espresso, Cold milk, Sugar, Ice cubes, Irish Cream flavoured syrup, Whipped cream, Chocolate sauce",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 6L,
                name = "Iced Mocha",
                imageUrl = R.drawable.ic_barista_mocca,
                description = "Iced Mocha is a coffee beverage. It based on Espresso and chocolate syrup with cold milk, foam and whipped cream or ice cream.",
                ingredients = "Cold coffee, Milk, Chocolate syrup, Whipped cream, Ice cream",
                isFavourite = false
            ),
            CoffeeDrink(
                id = 7L,
                name = "Latte",
                imageUrl = R.drawable.ic_barista_coffee_latte,
                description = "A latte is a coffee drink made with espresso and steamed milk.",
                ingredients = "Espresso, Steamed milk",
                isFavourite = false
            ),
        )
    }
}