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

    @TestFactory
    fun `dynamic convert by iteration`(): Collection<DynamicTest> {
        val rn = RomanNumeralsByIteration()
        return romanToIntMap.entries.map {
            DynamicTest.dynamicTest("${it.key} test") { assertEquals(it.value, rn.convert(it.key)) }
        }
    }

    @TestFactory
    fun `dynamic convert by recursion`(): Collection<DynamicTest> {
        val rn = RomanNumeralsByRecursion()
        return romanToIntMap.entries.map {
            DynamicTest.dynamicTest("${it.key} test") { assertEquals(it.value, rn.convert(it.key)) }
        }
    }

    @Nested
    @DisplayName("Tests for the RomanNumeralsByRecursion.wholeStringToAdditiveParts() method")
    inner class WholeStringTests {
        private val rn = RomanNumeralsByRecursion()

        @Test
        fun `wholeString I`() {
            assertEquals(listOf("I"), rn.wholeStringToAdditiveParts("I"), )
        }

        @Test
        fun `wholeString II`() {
            assertEquals(listOf("I", "I"), rn.wholeStringToAdditiveParts("II"), )
        }

        @Test
        fun `wholeString XII`() {
            assertEquals(listOf("X", "I", "I"), rn.wholeStringToAdditiveParts("XII"), )
        }

        @Test
        fun `wholeString IV`() {
            assertEquals(listOf("IV"), rn.wholeStringToAdditiveParts("IV"), )
        }

        @Test
        fun `wholeString XIV`() {
            assertEquals(listOf("X", "IV"), rn.wholeStringToAdditiveParts("XIV"))
        }

        @Test
        fun `wholeString MCMXLIV`() {
            assertEquals(listOf("M", "CM", "XL", "IV"), rn.wholeStringToAdditiveParts("MCMXLIV"))
        }
    }

}
