package com.example.groceryapp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.groceryapp.database.entitys.Products

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Products)

    @Delete
    suspend fun delete(item: Products)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Products>>
}