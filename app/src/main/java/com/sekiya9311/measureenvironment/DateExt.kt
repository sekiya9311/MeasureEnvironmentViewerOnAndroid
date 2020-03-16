package com.sekiya9311.measureenvironment

import java.text.SimpleDateFormat
import java.util.*

private val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.US)

fun Date.toDateString() = dateFormat.format(this)

fun Date.getYearValue() = this.toDateString().split("/")[0].toInt()

fun Date.getMonthValue() = this.toDateString().split("/")[1].toInt()

fun Date.getDayValue() = this.toDateString().split("/")[2].toInt()
