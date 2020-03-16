package com.sekiya9311.measureenvironment.model

class EnvironmentADay(
    private val list: List<Environment>
) : List<Environment> by list {
    val createdAt = list.firstOrNull()?.createdAt
}
