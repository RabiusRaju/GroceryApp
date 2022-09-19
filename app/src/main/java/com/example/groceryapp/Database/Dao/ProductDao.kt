package com.example.groceryapp.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.groceryapp.Database.Entitys.Products

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Products)

    @Delete
    suspend fun delete(item: Products)

    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<Products>>
}