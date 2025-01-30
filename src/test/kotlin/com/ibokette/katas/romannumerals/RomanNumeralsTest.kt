package com.ibokette.katas.romannumerals

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*


class RomanNumeralsTest {
    @BeforeEach
    fun setUp() {}

    @AfterEach
    fun tearDown() {}

    @Nested
    @DisplayName("Tests for the RomanNumeralsByIteration.convert() method")
    inner class IterationConvertTests {
        private val rn = RomanNumeralsByIteration()

        @Test
        fun `test I`() {
            assertEquals(1, rn.convert("I"))
        }

        @Test
        fun `test II`() {
            assertEquals(2, rn.convert("II"))
        }

        @Test
        fun `test IV`() {
            assertEquals(4, rn.convert("IV"))
        }

        @Test
        fun `test X`() {
            assertEquals(10, rn.convert("X"))
        }

        @Test
        fun `test 44`() {
            assertEquals(44, rn.convert("XLIV"))
        }

        @Test
        fun `test 1944`() {
            assertEquals(1944, rn.convert("MCMXLIV"))
        }
    }

    @Nested
    @DisplayName("Tests for the RomanNumeralsByIteration.convert() method")
    inner class RecursionConvertTests {
        private val rn = RomanNumeralsByRecursion()

        @Test
        fun `test I`() {
            assertEquals(1, rn.convert("I"))
        }

        @Test
        fun `test II`() {
            assertEquals(2, rn.convert("II"))
        }

        @Test
        fun `test IV`() {
            assertEquals(4, rn.convert("IV"))
        }

        @Test
        fun `test X`() {
            assertEquals(10, rn.convert("X"))
        }

        @Test
        fun `test 44`() {
            assertEquals(44, rn.convert("XLIV"))
        }

        @Test
        fun `test 1944`() {
            assertEquals(1944, rn.convert("MCMXLIV"))
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
