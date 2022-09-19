package com.example.groceryapp.Features.ProductModule.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryapp.Database.Entitys.Products
import com.example.groceryapp.Database.Repository.ProductRepository
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