package com.example.groceryapp.Database.Repository

import com.example.groceryapp.Database.Entitys.Products
import com.example.groceryapp.Database.GroceryDatabase

class ProductRepository(private val db: GroceryDatabase) {
    suspend fun insert(items:Products) = db.getProductDao().insert(items)
    suspend fun delete(items: Products) = db.getProductDao().delete(items)

    fun getAllItems() = db.getProductDao().getAllProducts()
}