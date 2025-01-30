package com.ibokette.lftest

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LftestApplication(
) : CommandLineRunner {
	override fun run(vararg args: String?) {
		println("My LF command line runner is complete")
	}
}

fun main(args: Array<String>) {
	runApplication<LftestApplication>(*args)
}
