package com.example.groceryapp.Features.GroceryModule.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.Database.Repository.GroceryRepository
import com.example.groceryapp.Features.GroceryModule.viewModel.GroceryViewModel

class GroceryViewModelFactory(private val repository: GroceryRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroceryViewModel(repository) as T
    }
}