package com.sekiya9311.measureenvironment.feature.environmentgraph

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.sekiya9311.measureenvironment.addDay
import com.sekiya9311.measureenvironment.addMilliseconds
import com.sekiya9311.measureenvironment.model.EnvironmentADay
import com.sekiya9311.measureenvironment.repository.db.EnvironmentDao
import com.sekiya9311.measureenvironment.repository.db.EnvironmentEntity
import com.sekiya9311.measureenvironment.repository.db.toEnvironment
import com.sekiya9311.measureenvironment.toCalendar

class EnvironmentGraphViewModel(
    val dateString: String,
    private val environmentDao: EnvironmentDao
) : ViewModel() {

    val environmentADay: LiveData<EnvironmentADay>
        get() {
            val firstDate = dateString.toCalendar()
                ?: return liveData { EnvironmentADay.EMPTY }
            val lastDate = firstDate
                .addDay(1)
                .addMilliseconds(-1)

            return environmentDao
                .getBetweenDatesLiveData(
                    firstDate,
                    lastDate
                ).map {
                    EnvironmentADay(
                        it.map(EnvironmentEntity::toEnvironment)
                    )
                }
        }

}
