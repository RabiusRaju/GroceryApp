package com.example.groceryapp.Features.ProductModule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.Database.Entitys.Products
import com.example.groceryapp.R
import com.example.groceryapp.databinding.GroceryAddDialogBinding
import com.example.groceryapp.databinding.GroceryRvItemBinding

class ProductRVAdapter (
    var list: List<Products>,
    val productItemClickInterface : ProductItemClickInterface

): RecyclerView.Adapter<ProductRVAdapter.ProductViewHolder>() {

    private lateinit var binding : GroceryRvItemBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRVAdapter.ProductViewHolder {
        binding =  GroceryRvItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return  ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductRVAdapter.ProductViewHolder, position: Int) {
        holder.binding.idTvItemName.text = list[position].productName
        holder.binding.idTvQuantity.text = list[position].quantity.toString()
        holder.binding.idIvDelete.setOnClickListener{
            productItemClickInterface.onItemClick(list[position])
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ProductViewHolder(var binding: GroceryRvItemBinding) : RecyclerView.ViewHolder(binding.root)

    interface ProductItemClickInterface {
        fun onItemClick(products: Products)
    }
}


