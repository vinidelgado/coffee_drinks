package com.vini.coffeedrink.di

import com.vini.coffeedrink.data.CoffeeDrinkItemMapper
import com.vini.coffeedrink.data.CoffeeDrinkRepository
import com.vini.coffeedrink.data.CoffeeDrinkRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModules {
    @Provides
    fun provideCoffeeDrinkRepository(): CoffeeDrinkRepository = CoffeeDrinkRepositoryImpl()

    @Provides
    fun provideCoffeeDrinkItemMapper(): CoffeeDrinkItemMapper = CoffeeDrinkItemMapper()
}