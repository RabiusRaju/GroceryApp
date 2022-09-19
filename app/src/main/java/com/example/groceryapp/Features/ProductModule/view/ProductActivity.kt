package com.example.groceryapp.Features.ProductModule.view

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.groceryapp.Database.Entitys.GroceryItems
import com.example.groceryapp.Database.Entitys.Products
import com.example.groceryapp.Database.GroceryDatabase
import com.example.groceryapp.Database.Repository.ProductRepository
import com.example.groceryapp.Features.ProductModule.adapter.ProductRVAdapter
import com.example.groceryapp.Features.ProductModule.factory.ProductViewModelFactory
import com.example.groceryapp.Features.ProductModule.viewModel.ProductViewModel
import com.example.groceryapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ProductActivity : AppCompatActivity(), ProductRVAdapter.ProductItemClickInterface {

    lateinit var itemsRV : RecyclerView
    lateinit var addFAB : FloatingActionButton
    lateinit var list: List<Products>
    lateinit var productRVAdapter: ProductRVAdapter
    lateinit var productViewModel: ProductViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        itemsRV = findViewById(R.id.idRVItems)
        addFAB = findViewById(R.id.idFABAdd)

        list = ArrayList<Products>()
        productRVAdapter = ProductRVAdapter(list,this)
        itemsRV.layoutManager = LinearLayoutManager(this)
        itemsRV.adapter = productRVAdapter

        val productRepository = ProductRepository(GroceryDatabase(this))
        val factory = ProductViewModelFactory(productRepository)
        productViewModel = ViewModelProvider(this,factory)[ProductViewModel::class.java]
        productViewModel.getAllProductItems().observe(this, Observer {
            productRVAdapter.list = it
            productRVAdapter.notifyDataSetChanged()
        })


        addFAB.setOnClickListener {
            openDialog()
        }

    }

    private fun openDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.grocery_add_dialog)

        val cancelBtn = dialog.findViewById<Button>(R.id.idButtonCancel)
        val addBtn = dialog.findViewById<Button>(R.id.idButtonAdd)

        val itemEdt = dialog.findViewById<EditText>(R.id.idEditItemName)
        val itemPriceEdt = dialog.findViewById<EditText>(R.id.idEditItemRate)
        val itemQuantityEdt = dialog.findViewById<EditText>(R.id.idEditItemQuantity)

        cancelBtn.setOnClickListener {
            dialog.dismiss()
        }

        addBtn.setOnClickListener {
            val itemName: String = itemEdt.text.toString()
            val itemPrice: Int = itemPriceEdt.text.toString().toInt()
            val itemQuantity: Int = itemQuantityEdt.text.toString().toInt()

            if (itemName.isNotEmpty() && itemPrice > 0 && itemQuantity > 0) {
                val item = Products(itemName, itemQuantity, itemPrice)
                productViewModel.insert(item)
                Toast.makeText(applicationContext, "Item Inserted..", Toast.LENGTH_SHORT).show()
                productRVAdapter.notifyDataSetChanged()
                dialog.dismiss()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Please Enter All The Data..",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
        dialog.show()
    }


    override fun onItemClick(products: Products) {
        productViewModel.delete(products)
        productRVAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "Item Deleted..", Toast.LENGTH_SHORT).show()

    }
}