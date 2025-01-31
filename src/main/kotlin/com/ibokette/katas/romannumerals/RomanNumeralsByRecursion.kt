package com.ibokette.katas.romannumerals

class RomanNumeralsByRecursion : AbstractRomanNumerals() {
    override fun wholeStringToAdditiveParts(roman: String): List<String> {
        // Def only part - return it.
        if (roman.length < 2) return listOf(roman)

        val leftInt = singleCharToInt(roman.substring(0, 1))
        val rightInt = singleCharToInt(roman.substring(1, 2))
        val size = if (leftInt < rightInt) 2 else 1

        // With new size the only part - return it.
        if (size == 2 && roman.length < 3) return listOf(roman.substring(0, 2))

        return wholeStringToAdditiveParts(roman.substring(0, size)) + wholeStringToAdditiveParts(roman.substring(size))
    }
}