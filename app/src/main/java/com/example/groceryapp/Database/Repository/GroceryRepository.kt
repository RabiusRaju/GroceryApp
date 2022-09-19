package com.example.groceryapp.Database.Repository

import com.example.groceryapp.Database.Entitys.GroceryItems
import com.example.groceryapp.Database.GroceryDatabase

class GroceryRepository(private val db: GroceryDatabase) {
    suspend fun insert(items: GroceryItems) = db.getGroceryDao().insert(items)
    suspend fun delete(items: GroceryItems) = db.getGroceryDao().delete(items)

    fun getAllItems() = db.getGroceryDao().getAllGroceryItems()
}