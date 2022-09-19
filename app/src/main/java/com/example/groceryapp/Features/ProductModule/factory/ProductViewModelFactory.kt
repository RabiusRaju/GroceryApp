package com.example.groceryapp.Features.ProductModule.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.Database.Repository.ProductRepository
import com.example.groceryapp.Features.ProductModule.viewModel.ProductViewModel

class ProductViewModelFactory(private val repository: ProductRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ProductViewModel(repository) as T
    }
}