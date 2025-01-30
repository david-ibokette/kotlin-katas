package com.ibokette.katas.romannumerals

class RomanNumeralsByIteration {
    fun convert(roman: String): Int {
        return wholeStringToAdditiveParts(roman)
            .map{stringPartToInt(it)}
            .sum()
    }

    private fun wholeStringToAdditiveParts(roman: String): List<String> {
        val romanAsStringList = roman.toList().map{it.toString()}
        val result = mutableListOf<String>()
        var lastElement = ""
        for (element in romanAsStringList) {
            // No previous element to account for (either beginning of string
            // or previous element was used in a tuple)
            if (lastElement == "") {
                lastElement = element
                continue
            }

            val lastInt = singleCharToInt(lastElement)
            val thisInt = singleCharToInt(element)

            // This is a tuple
            if (lastInt < thisInt) {
                result.add(lastElement + element)
                lastElement = ""
                continue
            }

            // That last element was a single - add it and now this one is the last
            result.add(lastElement)
            lastElement = element
        }

        if (lastElement != "") {
            result.add(lastElement)
        }

        return result
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