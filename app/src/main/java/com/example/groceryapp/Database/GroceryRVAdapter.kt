package com.example.groceryapp.Database

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.R

class GroceryRVAdapter(
    var list: List<GroceryItems>,
    val groceryItemClickInterface: GroceryItemClickInterface
) : RecyclerView.Adapter<GroceryRVAdapter.GroceryViewHolder>() {


    interface GroceryItemClickInterface {
        fun onItemClick(groceryItems: GroceryItems)
    }

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTV = itemView.findViewById<TextView>(R.id.idTvItemName)
        val quantityTV = itemView.findViewById<TextView>(R.id.idTvQuantity)
        val rateTV = itemView.findViewById<TextView>(R.id.idTvRate)
        val amountTV = itemView.findViewById<TextView>(R.id.idTVTotalAmount)
        val deleteTV = itemView.findViewById<ImageView>(R.id.idIvDelete)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_rv_item,parent,false)
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        val itemTotal : Int = list[position].itemPrice * list[position].itemQuantity

        holder.nameTV.text = list[position].itemName
        holder.quantityTV.text = list[position].itemQuantity.toString()
        holder.rateTV.text = "Rs . ${list[position].itemPrice}"
        holder.amountTV.text = "Rs . $itemTotal"
        holder.deleteTV.setOnClickListener{
            groceryItemClickInterface.onItemClick(list[position])
        }


    }

    override fun getItemCount(): Int {
        return list.size
    }
}