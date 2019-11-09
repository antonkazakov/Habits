package com.green.coreapi.dto

import org.junit.Assert.assertEquals
import org.junit.Test

class DaysArrayConverterTest {

    private val daysArrayConverter = DaysArrayConverter()

    @Test
    fun daysToString() {
        val days = daysArrayConverter.daysToString(listOf(0, 1, 2, 3, 4, 5, 6))
        val expected = "0,1,2,3,4,5,6"
        assertEquals(expected, days)
    }

    @Test
    fun fromStringToDays() {
        val actual = daysArrayConverter.fromStringToDays("0,1,2,3,4,5,6")
        val expected = listOf(0, 1, 2, 3, 4, 5, 6)
        assertEquals(expected, actual)
    }
}