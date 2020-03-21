package com.sekiya9311.measureenvironment.feature.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sekiya9311.measureenvironment.repository.FirestoreRepository

class LoginViewModelFactory(
    private val firestore: FirestoreRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("unchecked_cast")
            return LoginViewModel(firestore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
