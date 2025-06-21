package com.example.fooddeliveryapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
// Import for PromotionsSection was missing, let's ensure it's here or add it if it was accidentally removed
import com.example.fooddeliveryapp.ui.screens.composables.PromotionsSection
import com.example.fooddeliveryapp.ui.screens.composables.CategoryChipsSection
import com.example.fooddeliveryapp.ui.screens.composables.RestaurantListSection
import com.example.fooddeliveryapp.ui.navigation.AppBottomNavigationBar // Import Bottom Nav Bar
import com.example.fooddeliveryapp.ui.navigation.NavigationItem // Import Nav Items
import com.example.fooddeliveryapp.ui.navigation.bottomNavItems // Import Nav Items List


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var currentScreen by remember { mutableStateOf<NavigationItem>(NavigationItem.Home) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    TextField(
                        value = searchText,
                        onValueChange = { searchText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 8.dp) // Optional: add some padding if needed
                            .height(50.dp), // Adjust height as needed
                        placeholder = { Text("Search restaurants or cuisines...") },
                        leadingIcon = { Icon(Icons.Filled.Search, contentDescription = "Search Icon") },
                        colors = TextFieldDefaults.textFieldColors(
                            cursorColor = MaterialTheme.colorScheme.onSurface,
                            focusedIndicatorColor = Color.Transparent, // No underline when focused
                            unfocusedIndicatorColor = Color.Transparent // No underline when not focused
                        ),
                        singleLine = true
                    )
                }
                // Optional: Add navigation icon or actions here if needed
            )
        },
        bottomBar = {
            AppBottomNavigationBar(
                items = bottomNavItems,
                currentRoute = currentScreen.route,
                onItemSelected = { selectedItem ->
                    currentScreen = selectedItem
                    // In a real app, this would trigger navigation to the selectedItem.route
                    // For now, it just updates the state to highlight the selected tab
                    println("Bottom Nav Clicked: ${selectedItem.title}")
                }
            )
        }
    ) { innerPadding ->
        // Based on currentScreen, you would display different content.
        // For this example, we always show the main home content.
        // A more robust solution would use a NavHost here.
        Column(
            modifier = Modifier
                .padding(innerPadding) // Apply padding from Scaffold
                .fillMaxSize()
        ) {
            // For now, only Home screen content is shown regardless of bottom nav selection
            if (currentScreen == NavigationItem.Home) {
                PromotionsSection(modifier = Modifier.padding(top = 8.dp))
                CategoryChipsSection(modifier = Modifier.padding(top = 8.dp))
                RestaurantListSection(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    onRestaurantClick = { restaurant ->
                        println("Clicked on ${restaurant.name}")
                    }
                )
            } else {
                // Placeholder for other screens
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Content for ${currentScreen.title}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    FoodDeliveryAppTheme {
        HomeScreen()
    }
}
