package com.sekiya9311.measureenvironment.feature.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.sekiya9311.measureenvironment.repository.FirestoreRepository

class LoginViewModel(
    private val firestore: FirestoreRepository
) : ViewModel() {
    private val _isAuthorized = MutableLiveData<Boolean?>(null)
    val isAuthorized: LiveData<Boolean?> = _isAuthorized

    private val firebaseLoginObserver = Observer<Boolean> { authorized ->
        _isAuthorized.postValue(authorized)
    }

    init {
        firestore.inLogin
            .observeForever(firebaseLoginObserver)
    }

    override fun onCleared() {
        firestore.inLogin
            .removeObserver(firebaseLoginObserver)
        super.onCleared()
    }
}
