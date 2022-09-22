package com.example.groceryapp.database.repository

import com.example.groceryapp.database.entitys.Products
import com.example.groceryapp.database.GroceryDatabase

class ProductRepository(private val db: GroceryDatabase) {
    suspend fun insert(items:Products) = db.getProductDao().insert(items)
    suspend fun delete(items: Products) = db.getProductDao().delete(items)

    fun getAllItems() = db.getProductDao().getAllProducts()
}