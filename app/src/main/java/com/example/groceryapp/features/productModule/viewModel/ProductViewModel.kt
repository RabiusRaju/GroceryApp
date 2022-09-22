package com.example.groceryapp.features.productModule.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryapp.database.entitys.Products
import com.example.groceryapp.database.repository.ProductRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository) : ViewModel() {
    fun insert(items: Products) = GlobalScope.launch {
        repository.insert(items)
    }

    fun delete(items: Products) = GlobalScope.launch {
        repository.delete(items)
    }

    fun getAllProductItems() = repository.getAllItems()
}