package com.sekiya9311.measureenvironment

import android.content.Context
import com.sekiya9311.measureenvironment.repository.FirestoreRepository
import com.sekiya9311.measureenvironment.repository.db.AppDatabase
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao

object ServiceContainer {
    private val _container = HashMap<String, Any>()
    val container: Map<String, Any> = _container

    fun setup(context: Context) {
        if (_container.isNotEmpty())
            return

        val firestore = FirestoreRepository()
        val environmentDao = AppDatabase
            .getInstance(context)
            .environmentDao

        _container[FirestoreRepository::class.java.simpleName] = firestore
        _container[EnvironmentDao::class.java.simpleName] = environmentDao
    }

    fun <T> resolve(key: String, throwIfCantResolve: Boolean = false): T? {
        val res = _container[key] as? T
        if (res == null && throwIfCantResolve) {
            throw IllegalArgumentException("Can't resolve of key")
        }

        return res
    }
}
