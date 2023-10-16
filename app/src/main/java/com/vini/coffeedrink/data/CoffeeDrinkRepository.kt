package com.vini.coffeedrink.data

import kotlinx.coroutines.flow.Flow

interface CoffeeDrinkRepository {

    fun getCoffeeDrinks(): Flow<List<CoffeeDrink>>

    fun getCoffeeDrink(id: Long): Flow<CoffeeDrink?>

    suspend fun updateFavouriteState(id: Long, newFavouriteState: Boolean): Flow<Boolean>
}
