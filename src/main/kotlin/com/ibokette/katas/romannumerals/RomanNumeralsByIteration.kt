package com.ibokette.katas.romannumerals

class RomanNumeralsByIteration : AbstractRomanNumerals() {
    override fun wholeStringToAdditiveParts(roman: String): List<String> {
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
}