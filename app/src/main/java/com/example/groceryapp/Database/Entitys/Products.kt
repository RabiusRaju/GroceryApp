package com.example.groceryapp.Database.Entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Products(
    @ColumnInfo(name = "productName")
    var productName:String,

    @ColumnInfo(name = "quantity")
    var quantity:Int,

    @ColumnInfo(name = "price")
    var price:Int

){

    @PrimaryKey(autoGenerate = true)
    var id :Int?=null
}
