package com.ibokette.lftest

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LftestApplication(
	private val feedFileService: FeedFileService,
) : CommandLineRunner {
	override fun run(vararg args: String?) {
		// 4999 rows - partner1
		feedFileService.readAndLoadFile(
			"/Users/dibokette/leadfeeder/partner1/ofc/p1_CoveredInsurance_2023_10_19_030000.csv",
			"partner1"
		)

		// 4999 rows - partner2
//		feedFileService.readAndLoadFile(
//			"/Users/dibokette/leadfeeder/partner2/ofc/CoveredInsurance_2023_10_10_030000.csv",
//			"partner2"
//		)

		// 600K+ rows - partner2
//		feedFileService.readAndLoadFile(
//			"/Users/dibokette/leadfeeder/partner2/ofc/CoveredInsurance_2023_10_10_064918.csv",
//			"partner2"
//		)
	}
}

fun main(args: Array<String>) {
	runApplication<LftestApplication>(*args)
}
