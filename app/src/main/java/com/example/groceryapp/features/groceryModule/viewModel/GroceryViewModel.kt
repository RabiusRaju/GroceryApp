package com.example.groceryapp.features.groceryModule.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryapp.database.entitys.GroceryItems
import com.example.groceryapp.database.repository.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository: GroceryRepository) : ViewModel() {

    fun insert(items: GroceryItems) = GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items: GroceryItems) = GlobalScope.launch {
        repository.delete(items)
    }

    fun getAllGroceryItems() = repository.getAllItems()
}