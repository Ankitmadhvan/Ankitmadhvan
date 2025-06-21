package com.example.fooddeliveryapp.ui.screens.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme

data class CategoryChipItem(
    val id: Int,
    val name: String
)

val sampleCategories = listOf(
    CategoryChipItem(1, "All"),
    CategoryChipItem(2, "Pizza"),
    CategoryChipItem(3, "Burgers"),
    CategoryChipItem(4, "Sushi"),
    CategoryChipItem(5, "Desserts"),
    CategoryChipItem(6, "Healthy"),
    CategoryChipItem(7, "Indian"),
    CategoryChipItem(8, "Chinese")
)

@Composable
fun CategoryChipsSection(
    categories: List<CategoryChipItem> = sampleCategories,
    onCategorySelected: (CategoryChipItem) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull()) }

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Categories",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categories) { category ->
                CategoryChip(
                    category = category,
                    isSelected = category == selectedCategory,
                    onClick = {
                        selectedCategory = category
                        onCategorySelected(category)
                    }
                )
            }
        }
    }
}

@Composable
fun CategoryChip(
    category: CategoryChipItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        shape = MaterialTheme.shapes.medium, // Rounded corners
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 2.dp,
            pressedElevation = 4.dp
        )
    ) {
        Text(text = category.name, style = MaterialTheme.typography.labelMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryChipsSectionPreview() {
    FoodDeliveryAppTheme {
        CategoryChipsSection()
    }
}

@Preview(showBackground = true, name = "Selected Chip")
@Composable
fun CategoryChipSelectedPreview() {
    FoodDeliveryAppTheme {
        CategoryChip(category = sampleCategories[1], isSelected = true, onClick = {})
    }
}

@Preview(showBackground = true, name = "Unselected Chip")
@Composable
fun CategoryChipUnselectedPreview() {
    FoodDeliveryAppTheme {
        CategoryChip(category = sampleCategories[2], isSelected = false, onClick = {})
    }
}
