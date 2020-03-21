package com.sekiya9311.measureenvironment.feature.environmentgraph

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EnvironmentGraphViewModelFactory(
    private val dateString: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(EnvironmentGraphViewModel::class.java)) {
            return EnvironmentGraphViewModel(dateString) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
