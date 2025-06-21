package com.example.fooddeliveryapp.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavigationItem(val route: String, val icon: ImageVector, val title: String) {
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Orders : NavigationItem("orders", Icons.Filled.Receipt, "Orders")
    object Cart : NavigationItem("cart", Icons.Filled.ShoppingCart, "Cart")
    object Profile : NavigationItem("profile", Icons.Filled.Person, "Profile")
}

val bottomNavItems = listOf(
    NavigationItem.Home,
    NavigationItem.Orders,
    NavigationItem.Cart,
    NavigationItem.Profile
)
