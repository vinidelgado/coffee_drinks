package com.vini.coffeedrink.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vini.coffeedrink.data.CoffeeDrinkItemMapper
import com.vini.coffeedrink.data.CoffeeDrinkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CoffeeDrinkDetailViewModel @Inject constructor(
    private val repository: CoffeeDrinkRepository,
    private val mapper: CoffeeDrinkItemMapper,
) : ViewModel() {

    private val _state = MutableStateFlow<CoffeeDrinkDetailState>(CoffeeDrinkDetailState.Loading)
    val state = _state.asStateFlow()

    private val coffeeDrinkId = MutableStateFlow<Long>(-1)
    fun setCoffeeDrinkId(id: Long) {
        coffeeDrinkId.value = id
    }

    fun getCoffeeDrinkDetail() {
        viewModelScope.launch {
            repository.getCoffeeDrink(coffeeDrinkId.value)
                .catch { exception ->
                    _state.update {
                        CoffeeDrinkDetailState.Error(exception.message ?: "Error")
                    }
                }.collect { coffeeDrinks ->
                    if (coffeeDrinks != null) {
                        _state.update {
                            CoffeeDrinkDetailState.Success(
                                data = mapper.map(
                                    coffeeDrinks
                                )
                            )
                        }
                    } else {
                        _state.update {
                            CoffeeDrinkDetailState.Error("Coffee Detail not found")
                        }
                    }
                }
        }
    }
}