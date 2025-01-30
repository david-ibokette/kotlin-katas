package com.ibokette.katas

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RomanNumeralsTest {

    @BeforeEach
    fun setUp() {}

    @AfterEach
    fun tearDown() {}

    @Test
    fun `test I`() {
        assertTrue(true)
        val rn = RomanNumerals()
        assertEquals(rn.convert("I"), 1)
    }

    @Test
    fun `test II`() {
        assertTrue(true)
        val rn = RomanNumerals()
        assertEquals(rn.convert("II"), 2)
    }

    @Test
    fun `test IV`() {
        assertTrue(true)
        val rn = RomanNumerals()
        assertEquals(rn.convert("IV"), 4)
    }

    @Test
    fun `test X`() {
        assertTrue(true)
        val rn = RomanNumerals()
        assertEquals(rn.convert("X"), 10)
    }

    @Test
    fun `test 44`() {
        assertTrue(true)
        val rn = RomanNumerals()
        assertEquals(rn.convert("XLIV"), 44)
    }

    @Test
    fun `test 1944`() {
        assertTrue(true)
        val rn = RomanNumerals()
        assertEquals(rn.convert("MCMXLIV"), 1944)
    }
}
