package com.sekiya9311.measureenvironment.repository.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "environments")
data class EnvironmentEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val co2: Double,
    val created_at: Date
)
