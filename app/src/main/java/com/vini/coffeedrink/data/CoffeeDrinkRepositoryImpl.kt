package com.vini.coffeedrink.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class CoffeeDrinkRepositoryImpl: CoffeeDrinkRepository {
    override fun getCoffeeDrinks(): Flow<List<CoffeeDrink>> {
        return flowOf(FakeCoffeeDrinkDataSource().getCoffeeDrinks() as MutableList<CoffeeDrink>)
    }

    override fun getCoffeeDrink(id: Long): Flow<CoffeeDrink> {
        return flowOf(
            FakeCoffeeDrinkDataSource().getCoffeeDrinks().first { it.id == id }
        )
    }

    override suspend fun updateFavouriteState(id: Long, newFavouriteState: Boolean): Flow<Boolean> {
        TODO("Not yet implemented")
    }
}