package com.sekiya9311.measureenvironment.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FirebaseFirestore
import com.sekiya9311.measureenvironment.model.Environment
import com.sekiya9311.measureenvironment.model.Environments

class FirestoreRepository() {

    private val firestore by lazy {
        FirebaseFirestore.getInstance()
    }

    private val _environments = MutableLiveData<Environments>()
    val environments: LiveData<Environments> = _environments

    init {
        firestore
            .collection("measure_items")
            .addSnapshotListener { snapshot, e ->
                if (e != null) {
                    return@addSnapshotListener
                }

                val values = snapshot?.documents?.map {
                    val co2 = it.getDouble("co2") ?: return@map null
                    val createdAt = it.getTimestamp("created_at") ?: return@map null

                    Environment(co2, createdAt.toDate())

                }?.filterNotNull() ?: listOf()

                _environments.postValue(Environments(values))
            }
    }
}