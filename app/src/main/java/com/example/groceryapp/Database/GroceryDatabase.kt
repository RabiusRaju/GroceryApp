package com.example.groceryapp.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.groceryapp.Database.Dao.GroceryDao
import com.example.groceryapp.Database.Dao.ProductDao
import com.example.groceryapp.Database.Entitys.GroceryItems
import com.example.groceryapp.Database.Entitys.Products

@Database(entities = [GroceryItems::class, Products::class], version = 2)
abstract class GroceryDatabase : RoomDatabase() {

    abstract fun getGroceryDao(): GroceryDao
    abstract fun getProductDao(): ProductDao

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