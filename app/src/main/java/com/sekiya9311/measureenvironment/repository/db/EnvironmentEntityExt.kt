package com.sekiya9311.measureenvironment.repository.db

import com.sekiya9311.measureenvironment.model.Environment
import com.sekiya9311.measureenvironment.model.EnvironmentADay
import com.sekiya9311.measureenvironment.model.Environments
import com.sekiya9311.measureenvironment.toDateString

fun EnvironmentEntity.toEnvironment(): Environment = Environment(co2, createdAt)

fun List<EnvironmentEntity>.toEnvironments(): Environments =
    Environments(this.map { it.toEnvironment() })

fun List<EnvironmentEntity>.toEnvironmentADay(): List<EnvironmentADay> {
    return this.map { it.toEnvironment() }
        .groupBy { it.createdAt.toDateString() }
        .map { EnvironmentADay(it.value) }
        .sortedByDescending { it.createdAt?.toDateString() ?: "" }
}

fun Environment.toEntity(): EnvironmentEntity = EnvironmentEntity(co2, createdAt)
