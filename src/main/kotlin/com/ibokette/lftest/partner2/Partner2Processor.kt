package com.ibokette.lftest.partner2

import com.ibokette.lftest.AbstractPartnerProcessor
import com.opencsv.bean.CsvToBeanBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.nio.file.Files
import java.nio.file.Paths

@Service
class Partner2Processor(
    private val jdbcTemplate: JdbcTemplate,
) : AbstractPartnerProcessor() {
    var logger: Logger = LoggerFactory.getLogger(Partner2Processor::class.java)

    override fun getProcessingPartnerId(): String {
        return "partner2"
    }

    override fun processFile(filepath: String, filename: String, partnerId: String) {
        val chunkSize = 10000
        var totalCount = 0
        Files.newBufferedReader(Paths.get(filepath)).use{ reader ->
            val thisList = mutableListOf<Partner2FeedFileRow>()
            CsvToBeanBuilder<Partner2FeedFileRow>(reader)
                .withType(Partner2FeedFileRow::class.java)
                .withIgnoreLeadingWhiteSpace(true)
                .build()
                .stream().forEach {
                    thisList.add(it)
                    ++totalCount
                    if (thisList.size % chunkSize == 0) {
                        writeToDatabase(filename, partnerId, thisList, totalCount)
                        thisList.clear()
                    }
                }
            if (thisList.isNotEmpty()) {
                writeToDatabase(filename, partnerId, thisList, totalCount)
            }
        }
    }

    private fun writeToDatabase(filename: String, partnerId: String, rowList: List<Partner2FeedFileRow>, totalCount: Int) {
        logger.info("Writing ${rowList.size} rows to database")
        jdbcTemplate.batchUpdate(this.insertSQL, rowList, 10000) { ps, row ->
            var columnNum = 0
            ps.setString(++columnNum, filename)
            ps.setString(++columnNum, partnerId)
            ps.setString(++columnNum, row.loanNumber)
            ps.setString(++columnNum, row.servicerName)
            ps.setString(++columnNum, row.mortgageeInfo)
            ps.setString(++columnNum, row.loanType)
            ps.setString(++columnNum, row.subtype)
            ps.setString(++columnNum, row.investor)
            ps.setString(++columnNum, row.propertyAddress)
            ps.setString(++columnNum, row.propertyCity)
            ps.setString(++columnNum, row.propertyState)
            ps.setString(++columnNum, row.propertyZip)
            ps.setString(++columnNum, row.propertyType?.take(15))
            ps.setString(++columnNum, row.occupancyStatus?.take(50))
            ps.setDouble(++columnNum, row.originalLoanBalance.toDoubleOrZero())
            ps.setDouble(++columnNum, row.currentEstimatedValue.toDoubleOrZero())
            ps.setDouble(++columnNum, row.piAmount.toDoubleOrZero())
            ps.setDouble(++columnNum, row.tiAmount.toDoubleOrZero())
            ps.setString(++columnNum, row.borrowerFirstname)
            ps.setString(++columnNum, row.borrowerLastname)
            ps.setString(++columnNum, row.borrowerPhoneNumberPrimary)
            ps.setString(++columnNum, row.borrowerPhoneNumberSecondary)
            ps.setString(++columnNum, row.borrowerEmailAddress)
            ps.setDate(++columnNum, row.borrowerDOB.toSQLDate())
            ps.setString(++columnNum, row.borrowerGender)
            ps.setString(++columnNum, row.borrowerOccupation)
            ps.setDouble(++columnNum, row.borrowerFICO.toDoubleOrZero())
            ps.setString(++columnNum, row.coBorrowerFirstname)
            ps.setString(++columnNum, row.coBorrowerLastname)
            ps.setString(++columnNum, row.coBorrowerPhoneNumberPrimary)
            ps.setString(++columnNum, row.coBorrowerPhoneNumberSecondary)
            ps.setString(++columnNum, row.coBorrowerEmailAddress)
            ps.setDate(++columnNum, row.coBorrowerDOB.toSQLDate())
            ps.setBoolean(++columnNum, row.escrowedIndicator?.ifBlank{"N"}.equals("Y", true))
            ps.setDate(++columnNum, row.nextEscrowAnalysisDate.toSQLDate())
            ps.setString(++columnNum, row.restrictedCampaignCode)
            ps.setDate(++columnNum, row.hoi1ExpirationDate.toSQLDate())
            ps.setString(++columnNum, row.hoi1Carrier)
            ps.setDouble(++columnNum, row.hoi1DwellingCoverage.toDoubleOrZero())
            ps.setDouble(++columnNum, row.hoi1PremiumAmount.toDoubleOrZero())
            ps.setString(++columnNum, row.hoi1PolicyType)
        }.also { logger.info("Done writing ${rowList.size} rows to database, totalCount: $totalCount, response: $it") }
    }
}