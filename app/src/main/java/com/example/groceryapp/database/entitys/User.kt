package com.example.groceryapp.database.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by MD.Rabius sani raju on 9/20/22.
 */
@Entity(tableName = "tbl_user")
data class User (
    @ColumnInfo(name = "empName")
    var empName : String,

    @ColumnInfo(name = "empRole")
    var empRole : String,

    @ColumnInfo(name= "empRoleId")
    var empRoleId : Int,

    @ColumnInfo(name = "empDesignation")
    var empDesignation : String,
){
    @PrimaryKey(autoGenerate = true)
    var id:Int?=null
}