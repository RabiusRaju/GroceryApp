package com.example.groceryapp.Features.GroceryModule.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryapp.Database.Entitys.GroceryItems
import com.example.groceryapp.Database.Repository.GroceryRepository
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