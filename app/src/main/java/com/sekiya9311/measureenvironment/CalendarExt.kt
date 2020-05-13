package com.sekiya9311.measureenvironment

import java.util.*

fun Calendar.toDateString() = "%04d/%02d/%02d".format(getYear(), getMonth(), getDay())

fun Calendar.toTimeString() = "%02d/%02d".format(getHour(), getMinute())

fun Calendar.getYear() = this[Calendar.YEAR]

fun Calendar.getMonth() = this[Calendar.MONTH] + 1

fun Calendar.getDay() = this[Calendar.DAY_OF_MONTH]

fun Calendar.getHour() = this[Calendar.HOUR_OF_DAY]

fun Calendar.getMinute() = this[Calendar.MINUTE]

fun Calendar.getSecond() = this[Calendar.SECOND]

fun Calendar.addDay(amount: Int): Calendar {
    add(Calendar.DAY_OF_MONTH, amount)
    return this
}

fun Calendar.addMilliseconds(amount: Int): Calendar {
    add(Calendar.MILLISECOND, amount)
    return this
}

fun Date.toCalendar() = Calendar.getInstance().also {
    it.timeInMillis = this.time
}

fun String.toCalendar() = Calendar.getInstance().also {
    it.clear()
    it.add(Calendar.YEAR, this.substring(0, 4).toInt())
    it.add(Calendar.MONTH, this.substring(5, 7).toInt())
    it.add(Calendar.DAY_OF_MONTH, this.substring(8, 10).toInt())
}
