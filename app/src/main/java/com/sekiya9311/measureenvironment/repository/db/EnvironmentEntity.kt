package com.sekiya9311.measureenvironment.repository.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "environments")
data class EnvironmentEntity(
    @ColumnInfo(name = "co2")
    val co2: Double,
    @PrimaryKey
    @ColumnInfo(name = "created_at")
    val createdAt: Date
)
