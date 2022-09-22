package com.example.groceryapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.groceryapp.database.dao.GroceryDao
import com.example.groceryapp.database.dao.ProductDao
import com.example.groceryapp.database.dao.UserDao
import com.example.groceryapp.database.entitys.GroceryItems
import com.example.groceryapp.database.entitys.Products
import com.example.groceryapp.database.entitys.User

@Database(entities = [GroceryItems::class, Products::class,User::class], version = 4)
abstract class GroceryDatabase : RoomDatabase() {

    abstract fun getGroceryDao(): GroceryDao
    abstract fun getProductDao(): ProductDao
    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var instant: GroceryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instant ?: synchronized(LOCK) {
            instant ?: createDatabase(context).also {
                instant = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                GroceryDatabase::class.java,
                "Grocery.db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }


}