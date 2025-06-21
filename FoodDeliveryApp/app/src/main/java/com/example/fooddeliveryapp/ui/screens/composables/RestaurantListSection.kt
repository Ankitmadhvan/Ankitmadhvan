package com.example.fooddeliveryapp.ui.screens.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryapp.data.model.Restaurant
import com.example.fooddeliveryapp.data.model.sampleRestaurants
import com.example.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme

@Composable
fun RestaurantListSection(
    restaurants: List<Restaurant> = sampleRestaurants,
    onRestaurantClick: (Restaurant) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Nearby Restaurants",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items
        ) {
            items(restaurants, key = { it.id }) { restaurant ->
                RestaurantListItem(
                    restaurant = restaurant,
                    onClick = onRestaurantClick
                )
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 600)
@Composable
fun RestaurantListSectionPreview() {
    FoodDeliveryAppTheme {
        RestaurantListSection(onRestaurantClick = {})
    }
}
