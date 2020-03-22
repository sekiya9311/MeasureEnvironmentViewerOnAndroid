package com.sekiya9311.measureenvironment.feature.environmentgraph

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao

class EnvironmentGraphViewModelFactory(
    private val dateString: String,
    private val environmentDao: EnvironmentDao
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(EnvironmentGraphViewModel::class.java)) {
            return EnvironmentGraphViewModel(dateString, environmentDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
