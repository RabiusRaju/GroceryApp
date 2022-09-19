package com.example.groceryapp.Features.ProductModule.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.Database.Entitys.Products
import com.example.groceryapp.R

class ProductRVAdapter (
    var list: List<Products>,
    val productItemClickInterface : ProductItemClickInterface

): RecyclerView.Adapter<ProductRVAdapter.ProductViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductRVAdapter.ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return  ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductRVAdapter.ProductViewHolder, position: Int) {
        holder.nameTV.text = list[position].productName
        holder.quantityTV.text = list[position].quantity.toString()
        holder.deleteTV.setOnClickListener {
            productItemClickInterface.onItemClick(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV = itemView.findViewById<TextView>(R.id.idTvItemName)
        val quantityTV = itemView.findViewById<TextView>(R.id.idTvQuantity)
        val rateTV = itemView.findViewById<TextView>(R.id.idTvRate)
        val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalAmount)
        val deleteTV = itemView.findViewById<ImageView>(R.id.idIvDelete)
    }

    interface ProductItemClickInterface {
        fun onItemClick(products: Products)
    }
}


