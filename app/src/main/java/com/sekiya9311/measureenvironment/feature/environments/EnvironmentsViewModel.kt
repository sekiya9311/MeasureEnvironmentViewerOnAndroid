package com.sekiya9311.measureenvironment.feature.environments

import androidx.lifecycle.ViewModel
import com.sekiya9311.measureenvironment.repository.FirestoreRepository

class EnvironmentsViewModel : ViewModel() {

    private val firestore by lazy {
        FirestoreRepository()
    }

    val environments = firestore.environments
}
