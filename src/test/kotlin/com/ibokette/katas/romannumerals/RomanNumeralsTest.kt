package com.ibokette.katas.romannumerals

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*


class RomanNumeralsTest {
    @BeforeEach
    fun setUp() {}

    @AfterEach
    fun tearDown() {}

    private val romanToIntMap = mapOf(
        "I" to 1,
        "II" to 2,
        "IV" to 4,
        "X" to 10,
        "XLIV" to 44,
        "MCMXLIV" to 1944,
    )

    private val romanToAdditivePartsMap = mapOf(
        "I" to listOf("I"),
        "II" to listOf("I", "I"),
        "IV" to listOf("IV"),
        "X" to listOf("X"),
        "XLIV" to listOf("XL", "IV"),
        "MCMXLIV" to listOf("M", "CM", "XL", "IV"),
    )

    @Nested
    @DisplayName("Tests for the RomanNumeralsByIteration")
    inner class RomanNumeralsByIterationTests {
        private val rn = RomanNumeralsByIteration()

        @TestFactory
        fun `dynamic convert by iteration`(): Collection<DynamicTest> {
            return romanToIntMap.entries.map {
                DynamicTest.dynamicTest("${it.key} convert test") { assertEquals(it.value, rn.convert(it.key)) }
            }
        }

        @TestFactory
        fun `dynamic wholeStringToAdditiveParts by iteration`(): Collection<DynamicTest> {
            return romanToAdditivePartsMap.entries.map {
                DynamicTest.dynamicTest("${it.key} wholetoadditive test") { assertEquals(it.value, rn.wholeStringToAdditiveParts(it.key)) }
            }
        }
    }

    @Nested
    @DisplayName("Tests for the RomanNumeralsByRecursion")
    inner class RomanNumeralsByRecursionTests {
        private val rn = RomanNumeralsByRecursion()

        @TestFactory
        fun `dynamic convert by recursion`(): Collection<DynamicTest> {
            return romanToIntMap.entries.map {
                DynamicTest.dynamicTest("${it.key} convert test") { assertEquals(it.value, rn.convert(it.key)) }
            }
        }

        @TestFactory
        fun `dynamic wholeStringToAdditiveParts by recursion`(): Collection<DynamicTest> {
            return romanToAdditivePartsMap.entries.map {
                DynamicTest.dynamicTest("${it.key} wholetoadditive test") { assertEquals(it.value, rn.wholeStringToAdditiveParts(it.key)) }
            }
        }
    }
}
