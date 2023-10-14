package com.vini.coffeedrink.ui.detail

import com.vini.coffeedrink.data.CoffeeDrinkItem

sealed interface CoffeeDrinkDetailState {
    object Loading : CoffeeDrinkDetailState
    data class Success(val data: CoffeeDrinkItem ) : CoffeeDrinkDetailState
    data class Error(val data: String ) : CoffeeDrinkDetailState
}