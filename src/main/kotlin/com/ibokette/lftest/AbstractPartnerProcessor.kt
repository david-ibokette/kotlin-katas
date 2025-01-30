package com.ibokette.lftest

import java.sql.Date
import java.time.LocalDate
import java.time.format.DateTimeFormatter

abstract class AbstractPartnerProcessor {
    protected val insertSQL = """INSERT INTO feed_file_contents_stage (file_name, partner_id, loan_number, servicer_name, mortgagee_info,
        loan_type, subtype, investor, property_address, property_city, property_state, property_zip, property_type, occupancy_status,
        original_loan_balance, current_estimated_value, pi_amount, ti_amount,
        borrower_firstname, borrower_lastname, borrower_phone_number_primary, borrower_phone_number_secondary,
        borrower_email_address, borrower_dob, borrower_gender, borrower_occupation, borrower_fico,
        co_borrower_firstname, co_borrower_lastname, co_borrower_phone_number_primary, co_borrower_phone_number_secondary,
        co_borrower_email_address, co_borrower_dob,
        escrowed_indicator, next_escrow_analysis_date, restricted_campaign_code,
        hoi1_expiration_date, hoi1_carrier, hoi1_dwelling_coverage, hoi1_premium_amount, hoi1_policy_type,
        hoi2_expiration_date, hoi2_carrier, hoi2_dwelling_coverage, hoi2_premium_amount, hoi2_policy_type,
        hoi3_expiration_date, hoi3_carrier, hoi3_dwelling_coverage, hoi3_premium_amount, hoi3_policy_type,
        hoi4_expiration_date, hoi4_carrier, hoi4_dwelling_coverage, hoi4_premium_amount, hoi4_policy_type,
        hoi5_expiration_date, hoi5_carrier, hoi5_dwelling_coverage, hoi5_premium_amount, hoi5_policy_type,
        hoi6_expiration_date, hoi6_carrier, hoi6_dwelling_coverage, hoi6_premium_amount, hoi6_policy_type,
        hoi7_expiration_date, hoi7_carrier, hoi7_dwelling_coverage, hoi7_premium_amount, hoi7_policy_type,
        hoi8_expiration_date, hoi8_carrier, hoi8_dwelling_coverage, hoi8_premium_amount, hoi8_policy_type,
        status, row_num)
            VALUES (?, ?, ?, ?, ?,
            ?, ?, ?, ?, ?, ?, ?, ?, ?,
            ?, ?, ?, ?,
            ?, ?, ?, ?,
            ?, ?, ?, ?, ?,
            ?, ?, ?, ?,
            ?, ?,
            ?, ?, ?,
            ?, ?, ?, ?, ?,
            null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            """

    abstract fun getProcessingPartnerId(): String
    abstract fun processFile(filepath: String, filename: String, partnerId: String)

    protected fun String?.toSQLDate(): Date? {
        val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")
        if (this.isNullOrBlank()) {
            return null
        }

        val localDate = LocalDate.parse(this, formatter)
        return Date.valueOf(localDate)
    }

    protected fun String?.toDoubleOrZero(): Double {
        val doubleValue = this?.toDoubleOrNull()
        if (doubleValue == null || doubleValue > 9_000_000) {
            return 0.0
        }
        return doubleValue
    }
}