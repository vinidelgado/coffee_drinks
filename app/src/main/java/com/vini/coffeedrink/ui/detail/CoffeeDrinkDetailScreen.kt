package com.vini.coffeedrink.ui.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.vini.barista.R
import com.vini.coffeedrink.data.CoffeeDrinkItem
import com.vini.coffeedrink.ui.annotation.UiModePreviews
import com.vini.coffeedrink.ui.theme.AppTheme
import com.vini.coffeedrink.ui.theme.seed

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun CoffeeDrinkDetailScreen(
    navController: NavController,
    viewModel: CoffeeDrinkDetailViewModel = hiltViewModel(),
    id:Long
) {
//    viewModel.setCoffeeDrinkId(id)
    val state by viewModel.state.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = seed),
                title = {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp, start = 15.dp),
                        text = "American Coffee",
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier
                            .size(24.dp, 24.dp)
                            .clickable {
                                navController.navigateUp()
                            },
                        tint = Color.White
                    )
                }
            )
        },

        content = {
            CoffeeDrinkDetailContent(state)
        }
    )
}

@Composable
internal fun CoffeeDrinkDetailContent(state: CoffeeDrinkDetailState) {
    when (state) {
        is CoffeeDrinkDetailState.Loading -> {
            CoffeeDrinkDetailContentLoading()
        }

        is CoffeeDrinkDetailState.Success -> {
            CoffeeDrinkDetailContentSuccess(data = state.data)
        }

        is CoffeeDrinkDetailState.Error -> {
            CoffeeDrinkDetailContentError(state.data)
        }
    }
}

@Composable
fun CoffeeDrinkDetailContentLoading() {
    Text(stringResource(R.string.loading))
}

@Composable
fun CoffeeDrinkDetailContentError(data: String) {
    Text(data)
}

@Composable
private fun CoffeeDrinkDetailContentSuccess(data: CoffeeDrinkItem) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
    ) {
        item {
            data.apply {

                val dogImage: Painter = painterResource(id = R.drawable.blue_dog)
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(346.dp),
                    painter = dogImage,
                    alignment = Alignment.CenterStart,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Spacer(modifier = Modifier.height(16.dp))
                Column(verticalArrangement = Arrangement.Center) {
                    Text(
                        text = name,
                        modifier = Modifier.padding(0.dp, 0.dp, 12.dp, 0.dp),
                        color = MaterialTheme.colorScheme.surface,
                        fontWeight = FontWeight.Bold,
                        style = MaterialTheme.typography.headlineMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@UiModePreviews
@Composable
private fun CoffeeDrinkDetailContentSuccessPreview() {
    AppTheme {
        CoffeeDrinkDetailContentSuccess(
            data = CoffeeDrinkItem(
                id = 4L,
                name = "Espresso Macchiato",
                imageUrl = R.drawable.ic_barista_macchiato,
                description = "Espresso Macchiato is a coffee beverage (a single or double espresso topped with a dollop of heated, foamed milk).",
                ingredients = "Espresso, Foamed milk",
                isFavourite = false
            )
        )
    }
}
