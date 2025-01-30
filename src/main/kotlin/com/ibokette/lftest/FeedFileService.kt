package com.ibokette.lftest

import com.ibokette.lftest.partner1.Partner1Processor
import com.ibokette.lftest.partner2.Partner2Processor
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Service

@Service
class FeedFileService(
    private val namedParameterJdbcTemplate: NamedParameterJdbcTemplate,
    private val partner1Processor: Partner1Processor,
    private val partner2Processor: Partner2Processor,
) {
    var logger: Logger = LoggerFactory.getLogger(FeedFileService::class.java)

    fun readAndLoadFile(filepath: String, partnerId: String) {
        val filename = filepath.split("/").last()

        addToFileFeedStage(filename, partnerId)
        resetFileContentsStage(filename, partnerId)

        val partnerProcessor = getPartnerProcessor(partnerId)
        partnerProcessor.processFile(filepath, filename, partnerId)
    }

    private fun getPartnerProcessor(partnerId: String): AbstractPartnerProcessor {
        return when (partnerId) {
            "partner1" -> partner1Processor
            "partner2" -> partner2Processor
            else -> throw IllegalArgumentException("Unknown partner id: $partnerId")
        }
    }

    private fun addToFileFeedStage(filename: String, partnerId: String) {
        val insertSQL = """INSERT INTO feed_file_stage (file_name, partner_id, status)
            select :file_name, :partner_id, 'NEW' where not exists (select 1 from feed_file_stage where file_name = :file_name and partner_id = :partner_id)
                        """

        namedParameterJdbcTemplate.update(insertSQL, mapOf("file_name" to filename, "partner_id" to partnerId)).also {
            logger.info("Add response: $it")
        }
    }

    private fun resetFileContentsStage(filename: String, partnerId: String) {
        val resetSQL = """DELETE FROM feed_file_contents_stage where file_name = :file_name and partner_id = :partner_id"""

        namedParameterJdbcTemplate.update(resetSQL, mapOf("file_name" to filename, "partner_id" to partnerId)).also{
            logger.info("Reset response: $it")
        }
    }
}
