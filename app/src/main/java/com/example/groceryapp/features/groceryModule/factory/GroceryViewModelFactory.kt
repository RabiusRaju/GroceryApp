package com.example.groceryapp.features.groceryModule.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.database.repository.GroceryRepository
import com.example.groceryapp.features.groceryModule.viewModel.GroceryViewModel

class GroceryViewModelFactory(private val repository: GroceryRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GroceryViewModel(repository) as T
    }
}