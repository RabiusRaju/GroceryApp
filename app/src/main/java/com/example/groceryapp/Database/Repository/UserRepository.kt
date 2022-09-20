package com.example.groceryapp.Database.Repository

import com.example.groceryapp.Database.Entitys.User
import com.example.groceryapp.Database.GroceryDatabase

/**
 * Created by MD.Rabius sani raju on 9/20/22.
 */
class UserRepository (private val db: GroceryDatabase){
    suspend fun insert(item:User) = db.getUserDao().insert(item)
    suspend fun delete(item: User) = db.getUserDao().delete(item)

    fun getAllUsers() = db.getUserDao().getAllUsers()

}