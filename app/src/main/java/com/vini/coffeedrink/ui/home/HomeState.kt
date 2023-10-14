package com.vini.coffeedrink.ui.home

import com.vini.coffeedrink.data.CoffeeDrinkItem
//
//internal data class HomeState(
//    val drinks: List<CoffeeDrinkItem> = emptyList()
//)

sealed interface HomeState {
    object Loading : HomeState
    data class Success(val data: List<CoffeeDrinkItem> ) : HomeState
    data class Error(val data: String ) : HomeState
}