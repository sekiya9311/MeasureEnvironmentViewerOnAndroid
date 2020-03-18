package com.sekiya9311.measureenvironment.feature.environments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sekiya9311.measureenvironment.repository.FirestoreRepository
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao

class EnvironmentsViewModelFactory(
    private val firestore: FirestoreRepository,
    private val environmentsDao: EnvironmentDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EnvironmentsViewModel::class.java)) {
            @Suppress("unchecked_cast")
            return EnvironmentsViewModel(firestore, environmentsDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}