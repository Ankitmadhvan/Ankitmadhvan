package com.example.fooddeliveryapp.ui.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.fooddeliveryapp.ui.theme.FoodDeliveryAppTheme

data class PromotionItem(
    val id: Int,
    val title: String,
    val description: String,
    val backgroundColor: Color
)

val samplePromotions = listOf(
    PromotionItem(1, "Flat 20% Off", "On orders above $200", Color.Yellow.copy(alpha = 0.7f)),
    PromotionItem(2, "Free Delivery", "On selected restaurants", Color.Cyan.copy(alpha = 0.7f)),
    PromotionItem(3, "Special Combo", "Burger + Fries + Coke at $99", Color.Magenta.copy(alpha = 0.5f)),
    PromotionItem(4, "Weekend Special", "Pizza BOGO", Color.Green.copy(alpha = 0.6f))
)

@Composable
fun PromotionsSection(
    promotions: List<PromotionItem> = samplePromotions,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = "Offers For You",
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(promotions) { promotion ->
                PromotionCard(promotion)
            }
        }
    }
}

@Composable
fun PromotionCard(promotion: PromotionItem) {
    Box(
        modifier = Modifier
            .width(280.dp)
            .height(140.dp)
            .clip(MaterialTheme.shapes.medium)
            .background(promotion.backgroundColor)
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart // Aligns text to the start (left)
    ) {
        Column {
            Text(
                text = promotion.title,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                color = Color.Black.copy(alpha = 0.8f)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = promotion.description,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Black.copy(alpha = 0.7f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PromotionsSectionPreview() {
    FoodDeliveryAppTheme {
        PromotionsSection()
    }
}

@Preview(showBackground = true)
@Composable
fun PromotionCardPreview() {
    FoodDeliveryAppTheme {
        PromotionCard(samplePromotions.first())
    }
}
