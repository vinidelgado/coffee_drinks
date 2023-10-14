package com.vini.coffeedrink.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.vini.barista.R
import com.vini.coffeedrink.component.CoffeeDrinkShortAppBar
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.navigation.ScreenRoutes
import com.vini.coffeedrink.ui.annotation.UiModePreviews
import com.vini.coffeedrink.ui.theme.AppTheme

@Composable
internal fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Surface(color = MaterialTheme.colorScheme.background) {
        Column {
            CoffeeDrinkShortAppBar()
            HomeContent(state = state, onCoffeeDrinkClicked = {
                navController.navigate("${ScreenRoutes.CoffeeDrinkDetailScreen.route}/${it.id}")
            })
        }
    }
}

@Composable
internal fun HomeContent(state: HomeState, onCoffeeDrinkClicked: (CoffeeDrinkItem) -> Unit) {
    when (state) {
        is HomeState.Loading -> {
            HomeContentLoading()
        }

        is HomeState.Success -> {
            HomeContentDrinkList(data = state.data, onCoffeeDrinkClicked = onCoffeeDrinkClicked)
        }

        is HomeState.Error -> {
            HomeContentError(state.data)
        }
    }
}

@Composable
fun HomeContentLoading() {
    Text(stringResource(R.string.loading))
}

@Composable
fun HomeContentError(data: String) {
    Text(data)
}

@Composable
fun HomeContentDrinkList(
    data: List<CoffeeDrinkItem>,
    onCoffeeDrinkClicked: (CoffeeDrinkItem) -> Unit
) {
    val lazyListState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .testTag("Driver Standings List"),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            state = lazyListState
        ) {
            items(data.size) {
                Box(
                    modifier = Modifier.clickable(
                        onClick = {
                            onCoffeeDrinkClicked(data[it])
                        }
                    )
                ) {
                    HomeDrinkItem(data[it])
                }
            }
        }
    }
}

@UiModePreviews
@Composable
internal fun HomeScreenPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            HomeContent(
                state = HomeState.Success(
                    listOf(
                        CoffeeDrinkItem(
                            id = 3L,
                            name = "Espresso",
                            imageUrl = R.drawable.ic_barista_espresso,
                            description = "Espresso is coffee of Italian origin, brewed by forcing a small amount of nearly boiling water under pressure (expressing) through finely-ground coffee beans.",
                            ingredients = "Ground coffee, Water",
                            isFavourite = false
                        ),
                        CoffeeDrinkItem(
                            id = 4L,
                            name = "Espresso Macchiato",
                            imageUrl = R.drawable.ic_barista_macchiato,
                            description = "Espresso Macchiato is a coffee beverage (a single or double espresso topped with a dollop of heated, foamed milk).",
                            ingredients = "Espresso, Foamed milk",
                            isFavourite = false
                        ),
                        CoffeeDrinkItem(
                            id = 5L,
                            name = "Frappino",
                            imageUrl = R.drawable.ic_barista_frapuccino,
                            description = "Frappino is a blended coffee drinks. It consists of coffee base, blended with ice and other various ingredients, usually topped with whipped cream.",
                            ingredients = "Espresso, Cold milk, Sugar, Ice cubes, Irish Cream flavoured syrup, Whipped cream, Chocolate sauce",
                            isFavourite = false
                        ),
                    )
                ), onCoffeeDrinkClicked = {}
            )
        }
    }
}
