package com.example.myapplication.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class FoodItem(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String
)

class CartViewModel : ViewModel() {
    private val _cartItems = MutableStateFlow<List<FoodItem>>(emptyList())
    val cartItems: StateFlow<List<FoodItem>> = _cartItems.asStateFlow()

    val foodItems = listOf(
        FoodItem(1, "Pizza", 12.99, "Delicious cheese pizza"),
        FoodItem(2, "Burger", 8.49, "Juicy beef burger"),
        FoodItem(3, "Pasta", 10.99, "Creamy alfredo pasta"),
        FoodItem(4, "Salad", 7.99, "Fresh garden salad"),
        FoodItem(5, "Sushi", 15.99, "Assorted sushi rolls"),
        FoodItem(6, "Tacos", 9.99, "Spicy beef tacos"),
        FoodItem(7, "Ice Cream", 4.99, "Vanilla bean ice cream"),
        FoodItem(8, "Steak", 24.99, "Grilled ribeye steak")
    )

    fun addToCart(item: FoodItem) {
        _cartItems.value = _cartItems.value + item
    }

    fun removeFromCart(item: FoodItem) {
        _cartItems.value = _cartItems.value - item
    }
}
