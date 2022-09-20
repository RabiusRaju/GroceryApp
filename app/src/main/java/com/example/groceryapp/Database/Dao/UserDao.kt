package com.example.groceryapp.Database.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.groceryapp.Database.Entitys.User

/**
 * Created by MD.Rabius sani raju on 9/20/22.
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item : User)

    @Delete
    suspend fun delete(item : User)

    @Query("Select * from tbl_user")
    fun getAllUsers() : LiveData<List<User>>

}
