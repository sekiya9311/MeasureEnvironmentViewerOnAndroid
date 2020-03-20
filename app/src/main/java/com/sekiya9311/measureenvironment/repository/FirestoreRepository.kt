package com.sekiya9311.measureenvironment.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.sekiya9311.measureenvironment.model.Environment
import com.sekiya9311.measureenvironment.model.Environments
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import java.util.*

class FirestoreRepository() {

    private val auth by lazy {
        FirebaseAuth.getInstance()
    }

    private val firestore by lazy {
        FirebaseFirestore.getInstance()
    }

    val inLogin = auth.currentUser != null

    fun addAuthStateListener(listener: (FirebaseAuth) -> Unit) {
        auth.addAuthStateListener(listener)
    }

    fun removeAuthStateListener(listener: (FirebaseAuth) -> Unit) {
        auth.removeAuthStateListener(listener)
    }

    suspend fun getEnvironments(from: Date): Flow<Environments> {
        return flow {
            val snapshot = firestore
                .collection(MEASURE_ITEM_COLLECTION_NAME)
                .whereGreaterThan("created_at", from)
                .get()
                .await()
            val list = snapshot.map {
                val co2 = it.getDouble("co2") ?: return@map null
                val createdAt = it.getTimestamp("created_at") ?: return@map null

                Environment(co2, createdAt.toDate())
            }.filterNotNull().sortedByDescending { it.createdAt }

            emit(Environments(list))
        }
    }

    suspend fun getLatestEnvironment(): Flow<Environment> {
        return callbackFlow {
            val listener = firestore
                .collection(MEASURE_ITEM_COLLECTION_NAME)
                .orderBy("created_at", Query.Direction.DESCENDING)
                .limit(1)
                .addSnapshotListener { snapshot, e ->
                    if (e != null) {
                        close(e)
                        return@addSnapshotListener
                    }

                    val value = snapshot?.firstOrNull() ?: return@addSnapshotListener
                    val co2 = value.getDouble("co2") ?: return@addSnapshotListener
                    val createdAt =
                        value.getTimestamp("created_at") ?: return@addSnapshotListener
                    offer(Environment(co2, createdAt.toDate()))
                }
            awaitClose { listener.remove() }
        }
    }

    companion object {
        private const val MEASURE_ITEM_COLLECTION_NAME = "measure_items"
    }
}