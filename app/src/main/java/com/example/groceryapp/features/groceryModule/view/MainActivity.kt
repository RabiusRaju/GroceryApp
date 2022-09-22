package com.example.groceryapp.features.groceryModule.view

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
import com.example.groceryapp.database.*
import com.example.groceryapp.database.entitys.GroceryItems
import com.example.groceryapp.database.repository.GroceryRepository
import com.example.groceryapp.features.groceryModule.adapter.GroceryRVAdapter
import com.example.groceryapp.features.groceryModule.viewModel.GroceryViewModel
import com.example.groceryapp.features.groceryModule.factory.GroceryViewModelFactory
import com.example.groceryapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(), GroceryRVAdapter.GroceryItemClickInterface {


    private val list: List<GroceryItems> by lazy { ArrayList() }
    private val groceryRVAdapter by lazy { GroceryRVAdapter(list,this) }
    private val groceryRepository by lazy { GroceryRepository(GroceryDatabase(this)) }
    private val groceryViewModelFactory by lazy { GroceryViewModelFactory(groceryRepository) }

    lateinit var itemsRV: RecyclerView
    lateinit var addFAB: FloatingActionButton

    //lateinit var groceryRVAdapter: GroceryRVAdapter
    lateinit var groceryViewModel: GroceryViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        itemsRV = findViewById(R.id.idRVItems)
        addFAB = findViewById(R.id.idFABAdd)


        //groceryRVAdapter = GroceryRVAdapter(list, this);
        itemsRV.layoutManager = LinearLayoutManager(this)
        itemsRV.adapter = groceryRVAdapter


        //val groceryRepository = GroceryRepository(GroceryDatabase(this))
        //val factory = GroceryViewModelFactory(groceryRepository)

        groceryViewModel = ViewModelProvider(this, groceryViewModelFactory)[GroceryViewModel::class.java]
        groceryViewModel.getAllGroceryItems().observe(this, Observer {
            groceryRVAdapter.list = it
            groceryRVAdapter.notifyDataSetChanged()
        })

        addFAB.setOnClickListener {
            openDialog()
        }

        //Timber.e("MainActivity")
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
                val item = GroceryItems(itemName, itemQuantity, itemPrice)
                groceryViewModel.insert(item)
                Toast.makeText(applicationContext, "Item Inserted..", Toast.LENGTH_SHORT).show()
                groceryRVAdapter.notifyDataSetChanged()
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

    override fun onItemClick(groceryItems: GroceryItems) {
        groceryViewModel.delete(groceryItems)
        groceryRVAdapter.notifyDataSetChanged()
        Toast.makeText(applicationContext, "Item Deleted..", Toast.LENGTH_SHORT).show()
    }
}