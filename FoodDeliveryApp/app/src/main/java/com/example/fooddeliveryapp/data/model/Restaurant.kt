package com.example.fooddeliveryapp.data.model

data class Restaurant(
    val id: String,
    val name: String,
    val cuisineTypes: List<String>,
    val rating: Double,
    val estimatedDeliveryTime: String, // e.g., "25-35 min"
    val imageUrl: String? = null, // Placeholder for actual image loading
    val distance: String? = null, // e.g. "2.5 km"
    val offers: List<String>? = null // e.g. ["20% OFF", "Free Delivery"]
)

val sampleRestaurants = listOf(
    Restaurant(
        id = "1",
        name = "The Gourmet Place",
        cuisineTypes = listOf("Italian", "Pizza"),
        rating = 4.5,
        estimatedDeliveryTime = "25-35 min",
        imageUrl = "https://via.placeholder.com/150/FFC107/000000?Text=Restaurant1",
        distance = "1.2 km",
        offers = listOf("20% OFF up to $50")
    ),
    Restaurant(
        id = "2",
        name = "Burger Queen",
        cuisineTypes = listOf("Burgers", "Fast Food"),
        rating = 4.2,
        estimatedDeliveryTime = "20-30 min",
        imageUrl = "https://via.placeholder.com/150/4CAF50/FFFFFF?Text=Restaurant2",
        distance = "0.8 km",
        offers = listOf("Free Delivery")
    ),
    Restaurant(
        id = "3",
        name = "Sushi Central",
        cuisineTypes = listOf("Japanese", "Sushi"),
        rating = 4.8,
        estimatedDeliveryTime = "30-40 min",
        imageUrl = "https://via.placeholder.com/150/E91E63/FFFFFF?Text=Restaurant3",
        distance = "2.5 km"
    ),
    Restaurant(
        id = "4",
        name = "Curry House",
        cuisineTypes = listOf("Indian", "Curry"),
        rating = 4.6,
        estimatedDeliveryTime = "35-45 min",
        imageUrl = "https://via.placeholder.com/150/9C27B0/FFFFFF?Text=Restaurant4",
        distance = "3.1 km",
        offers = listOf("Combo Deals Available")
    ),
    Restaurant(
        id = "5",
        name = "Healthy Bites",
        cuisineTypes = listOf("Salads", "Smoothies", "Healthy"),
        rating = 4.3,
        estimatedDeliveryTime = "15-25 min",
        imageUrl = "https://via.placeholder.com/150/00BCD4/000000?Text=Restaurant5",
        distance = "1.0 km"
    )
)
