package com.ibokette.katas.romannumerals

class RomanNumeralsByRecursion {
    fun convert(roman: String): Int {
        return wholeStringToAdditiveParts(roman)
            .map{stringPartToInt(it)}
            .sum()
    }

    fun wholeStringToAdditiveParts(roman: String): List<String> {
        // Def only part - return it.
        if (roman.length < 2) return listOf(roman)

        var size = 1

        val leftInt = singleCharToInt(roman.substring(0, 1))
        val rightInt = singleCharToInt(roman.substring(1, 2))
        if (leftInt < rightInt) {
            size = 2
        }

        // With new size the only part - return it.
        if (size == 2 && roman.length < 3) return listOf(roman.substring(0, 2))

        return wholeStringToAdditiveParts(roman.substring(0, size)) + wholeStringToAdditiveParts(roman.substring(size))
    }

    private fun stringPartToInt(roman: String): Int {
        require(roman.length in 1.. 2) { "Invalid Roman part {$roman}" }

        if (roman.length == 1) return singleCharToInt(roman)

        return singleCharToInt(roman[1].toString()) - singleCharToInt(roman[0].toString())
    }

    private fun singleCharToInt(c: String): Int {
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