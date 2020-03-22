package com.sekiya9311.measureenvironment.model

import kotlin.math.max

data class EnvironmentADay(
    private val list: List<Environment>
) : List<Environment> by list {
    val createdAt = list.firstOrNull()?.createdAt

    val co2Average = sumByDouble { it.co2 } / max(1, size)

    companion object {
        val EMPTY = EnvironmentADay(listOf())
    }
}
