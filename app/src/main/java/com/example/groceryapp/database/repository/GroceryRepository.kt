package com.example.groceryapp.database.repository

import com.example.groceryapp.database.entitys.GroceryItems
import com.example.groceryapp.database.GroceryDatabase

class GroceryRepository(private val db: GroceryDatabase) {
    suspend fun insert(items: GroceryItems) = db.getGroceryDao().insert(items)
    suspend fun delete(items: GroceryItems) = db.getGroceryDao().delete(items)

    fun getAllItems() = db.getGroceryDao().getAllGroceryItems()
}