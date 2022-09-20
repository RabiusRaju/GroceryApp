package com.example.groceryapp.Features.UserModule.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.groceryapp.Database.Repository.UserRepository
import com.example.groceryapp.Features.UserModule.viewModel.UserViewModel

/**
 * Created by MD.Rabius sani raju on 9/20/22.
 */
class UserViewModelFactory(private val repository: UserRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserViewModel(repository) as T
    }
}