package com.ibokette.katas

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RomanNumeralsTest {

    private val rn = RomanNumerals()

    @BeforeEach
    fun setUp() {}

    @AfterEach
    fun tearDown() {}

    @Test
    fun `test I`() {
        assertEquals(rn.convert("I"), 1)
    }

    @Test
    fun `test II`() {
        assertEquals(rn.convert("II"), 2)
    }

    @Test
    fun `test IV`() {
        assertEquals(rn.convert("IV"), 4)
    }

    @Test
    fun `test X`() {
        assertEquals(rn.convert("X"), 10)
    }

    @Test
    fun `test 44`() {
        assertEquals(rn.convert("XLIV"), 44)
    }

    @Test
    fun `test 1944`() {
        assertEquals(rn.convert("MCMXLIV"), 1944)
    }
}
