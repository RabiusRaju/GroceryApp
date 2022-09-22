package com.example.groceryapp.features.userModule.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.database.repository.UserRepository
import com.example.groceryapp.features.userModule.viewModel.UserViewModel

/**
 * Created by MD.Rabius sani raju on 9/20/22.
 */
class UserViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}