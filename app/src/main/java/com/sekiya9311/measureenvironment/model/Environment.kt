package com.sekiya9311.measureenvironment.model

import com.sekiya9311.measureenvironment.getDayValue
import com.sekiya9311.measureenvironment.getMonthValue
import com.sekiya9311.measureenvironment.getYearValue
import java.util.*

data class Environment(
    val co2: Double,
    val createdAt: Date
) {
    val year = createdAt.getYearValue()
    val month = createdAt.getMonthValue()
    val day = createdAt.getDayValue()
}
