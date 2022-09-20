package com.example.groceryapp.Features.UserModule.viewModel

import androidx.lifecycle.ViewModel
import com.example.groceryapp.Database.Entitys.User
import com.example.groceryapp.Database.Repository.UserRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * Created by MD.Rabius sani raju on 9/20/22.
 */
class UserViewModel(private val repository: UserRepository) : ViewModel() {

    fun insert(item: User) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item:User) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllUserItems() = repository.getAllUsers()

}