package com.sekiya9311.measureenvironment

import java.text.SimpleDateFormat
import java.util.*

private val dateFormat = SimpleDateFormat("yyyy/MM/dd", Locale.US)

fun Date.toDateString() = dateFormat.format(this)

fun Date.getYearValue() = this.toDateString().split("/")[0].toInt()

fun Date.getMonthValue() = this.toDateString().split("/")[1].toInt()

fun Date.getDayValue() = this.toDateString().split("/")[2].toInt()

private fun add(source: Date, field: Int, amount: Int): Date {
    return Calendar.getInstance().let {
        it.time = source
        it.add(field, amount)
        
        it.time
    }
}

fun Date.addDay(amount: Int) = add(this, Calendar.DAY_OF_MONTH, amount)

fun Date.addMilliseconds(amount: Int) = add(this, Calendar.MILLISECOND, amount)

fun String.toDate() = dateFormat.parse(this)
