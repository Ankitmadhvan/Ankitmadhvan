package com.example.fooddeliveryapp.ui.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.example.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme

@Composable
fun AppBottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onItemSelected: (NavigationItem) -> Unit
) {
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(item.title) },
                selected = currentRoute == item.route,
                onClick = { onItemSelected(item) },
                alwaysShowLabel = true // Or false, depending on design preference
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppBottomNavigationBarPreview() {
    var currentSelectedItem by remember { mutableStateOf<NavigationItem>(NavigationItem.Home) }
    FoodDeliveryAppTheme {
        AppBottomNavigationBar(
            items = bottomNavItems,
            currentRoute = currentSelectedItem.route,
            onItemSelected = { selectedItem ->
                currentSelectedItem = selectedItem
                // In a real app, you'd navigate here
                println("Selected: ${selectedItem.title}")
            }
        )
    }
}
