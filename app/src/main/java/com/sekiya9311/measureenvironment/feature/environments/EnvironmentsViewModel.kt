package com.sekiya9311.measureenvironment.feature.environments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.sekiya9311.measureenvironment.model.EnvironmentADay
import com.sekiya9311.measureenvironment.repository.FirestoreRepository
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao
import com.sekiya9311.measureenvironment.repository.db.toEntity
import com.sekiya9311.measureenvironment.repository.db.toEnvironments
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class EnvironmentsViewModel(
    private val firestore: FirestoreRepository,
    private val environmentsDao: EnvironmentDao
) : ViewModel() {
    val environmentsADay by lazy {
        environmentsDao.getAllLiveData().map { environmentEntities ->
            environmentEntities.toEnvironments()
                .groupBy { environment ->
                    environment.createdAt.toString()
                }.map {
                    EnvironmentADay(it.value)
                }
        }
    }

    init {
        setup()
    }

    private fun setup() {
        viewModelScope.launch {
            val latestDate = environmentsDao.fetchLatestLiveData().value?.createdAt
                ?: Date(0L)
            firestore.getEnvironments(latestDate).collect { source ->
                withContext(Dispatchers.IO) {
                    source
                        .map { it.toEntity() }
                        .forEach { environmentsDao.insert(it) }
                }
            }

            firestore.getLatestEnvironment().collect {
                withContext(Dispatchers.IO) {
                    environmentsDao.insert(it.toEntity())
                }
            }
        }
    }
}
