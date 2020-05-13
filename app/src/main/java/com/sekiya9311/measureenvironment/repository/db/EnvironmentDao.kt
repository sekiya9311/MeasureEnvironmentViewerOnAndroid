package com.sekiya9311.measureenvironment.repository.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import java.util.*

@Dao
interface EnvironmentDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(value: EnvironmentEntity)

    @Query("SELECT * FROM environments ORDER BY created_at DESC")
    fun getAllLiveData(): LiveData<List<EnvironmentEntity>>

    @Query("SELECT * FROM environments WHERE created_at BETWEEN :from AND :to ORDER BY created_at DESC")
    fun getBetweenDatesLiveData(from: Calendar, to: Calendar): LiveData<List<EnvironmentEntity>>

    @Query("SELECT * FROM environments ORDER BY created_at DESC LIMIT 1")
    fun fetchLatestLiveData(): LiveData<EnvironmentEntity>
}
