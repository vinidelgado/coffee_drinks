package com.vini.coffeedrink.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vini.coffeedrink.data.CoffeeDrinkItemMapper
import com.vini.coffeedrink.data.CoffeeDrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    repository: CoffeeDrinkRepository,
    mapper: CoffeeDrinkItemMapper
) : ViewModel() {

    val state = repository.getCoffeeDrinks()
        .map { coffeeDrinks ->
            HomeState.Success(coffeeDrinks.map { mapper.map(it) })
        }
        .catch {
            HomeState.Error(it.message?: "Error")
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = HomeState.Loading
        )
}