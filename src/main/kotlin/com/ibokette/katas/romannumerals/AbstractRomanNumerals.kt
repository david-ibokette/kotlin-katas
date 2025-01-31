package com.ibokette.katas.romannumerals

abstract class AbstractRomanNumerals {
    fun convert(roman: String): Int {
        return wholeStringToAdditiveParts(roman)
            .map{stringPartToInt(it)}
            .sum()
    }

    abstract fun wholeStringToAdditiveParts(roman: String): List<String>

    private fun stringPartToInt(roman: String): Int {
        require(roman.length in 1.. 2) { "Invalid Roman part {$roman}" }

        return if (roman.length == 1)
            singleCharToInt (roman)
        else
            singleCharToInt(roman[1].toString()) - singleCharToInt(roman[0].toString())
    }

    fun singleCharToInt(c: String): Int {
        return when (c) {
            "I" -> 1
            "V" -> 5
            "X" -> 10
            "L" -> 50
            "C" -> 100
            "D" -> 500
            "M" -> 1000
            else -> throw IllegalArgumentException("Invalid Roman numeral")
        }
    }
}