package com.sekiya9311.measureenvironment.model

class Environments(
    private val list: List<Environment>
) : List<Environment> by list {

    fun getEnvironmentADay(year: Int, month: Int, day: Int): EnvironmentADay {
        return EnvironmentADay(filter { it.year == year && it.month == month && it.day == day })
    }

}
