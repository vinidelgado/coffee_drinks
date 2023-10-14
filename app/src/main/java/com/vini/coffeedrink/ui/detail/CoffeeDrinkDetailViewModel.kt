package com.vini.coffeedrink.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vini.coffeedrink.data.CoffeeDrinkItemMapper
import com.vini.coffeedrink.data.CoffeeDrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
internal class CoffeeDrinkDetailViewModel @Inject constructor(
    repository: CoffeeDrinkRepository,
    mapper: CoffeeDrinkItemMapper,
) : ViewModel() {

//    private val coffeeDrinkId = MutableStateFlow<Long>(-1)
//    fun setCoffeeDrinkId(id: Long) {
//        coffeeDrinkId.value = id
//    }

    val state = repository.getCoffeeDrink(id = 2)
        .map { coffeeDrinks ->
            CoffeeDrinkDetailState.Success(data = mapper.map(coffeeDrinks))
        }
        .catch {
            CoffeeDrinkDetailState.Error(it.message ?: "Error")
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = CoffeeDrinkDetailState.Loading
        )
}