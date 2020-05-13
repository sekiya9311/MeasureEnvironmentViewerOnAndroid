package com.sekiya9311.measureenvironment.model

import com.sekiya9311.measureenvironment.getDay
import com.sekiya9311.measureenvironment.getMonth
import com.sekiya9311.measureenvironment.getYear
import java.util.*

data class Environment(
    val co2: Double,
    val createdAt: Calendar
) {
    val year = createdAt.getYear()
    val month = createdAt.getMonth()
    val day = createdAt.getDay()
}
