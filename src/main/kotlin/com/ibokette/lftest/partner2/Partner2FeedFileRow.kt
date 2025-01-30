package com.ibokette.lftest.partner2

import com.opencsv.bean.CsvBindByName

class Partner2FeedFileRow(
    @CsvBindByName(column = "LoanNumber")
    val loanNumber: String? = null,

    @CsvBindByName(column = "ServicerName")
    val servicerName : String? = null,

    @CsvBindByName(column = "MortgageeInfo")
    val mortgageeInfo : String? = null,

    @CsvBindByName(column = "LoanType")
    val loanType : String? = null,

    @CsvBindByName(column = "SubType")
    val subtype : String? = null,

    @CsvBindByName(column = "Investor")
    val investor : String? = null,

    @CsvBindByName(column = "PropertyAddress")
    val propertyAddress : String? = null,

    @CsvBindByName(column = "PropertyCity")
    val propertyCity : String? = null,

    @CsvBindByName(column = "PropertyState")
    val propertyState : String? = null,

    @CsvBindByName(column = "PropertyZip")
    val propertyZip : String? = null,

    @CsvBindByName(column = "PropertyType")
    val propertyType : String? = null,

    @CsvBindByName(column = "OccupancyStatus")
    val occupancyStatus : String? = null,

    @CsvBindByName(column = "OriginalLoanBalance")
    val originalLoanBalance : String? = null,

    @CsvBindByName(column = "CurrentEstimatedValue")
    val currentEstimatedValue : String? = null,

    @CsvBindByName(column = "PIAmount")
    val piAmount : String? = null,

    @CsvBindByName(column = "TIAmount")
    val tiAmount : String? = null,

    @CsvBindByName(column = "BorrowerFirstName")
    val borrowerFirstname : String? = null,

    @CsvBindByName(column = "BorrowerLastName")
    val borrowerLastname : String? = null,

    @CsvBindByName(column = "BorrowerPhoneNumberPrimary")
    val borrowerPhoneNumberPrimary : String? = null,

    @CsvBindByName(column = "BorrowerPhoneNumberSecondary")
    val borrowerPhoneNumberSecondary : String? = null,

    @CsvBindByName(column = "BorrowerEmailAddress")
    val borrowerEmailAddress : String? = null,

    @CsvBindByName(column = "BorrowerDOB")
    val borrowerDOB : String? = null,

    @CsvBindByName(column = "BorrowerGender")
    val borrowerGender : String? = null,

    @CsvBindByName(column = "BorrowerOccupation")
    val borrowerOccupation : String? = null,

    @CsvBindByName(column = "BorrowerFico")
    val borrowerFICO : String? = null,

    @CsvBindByName(column = "CoBorrowerFirstName")
    val coBorrowerFirstname : String? = null,

    @CsvBindByName(column = "CoBorrowerLastName")
    val coBorrowerLastname : String? = null,

    @CsvBindByName(column = "CoBorrowerPhoneNumberPrimary")
    val coBorrowerPhoneNumberPrimary : String? = null,

    @CsvBindByName(column = "CoBorrowerPhoneNumberSecondary")
    val coBorrowerPhoneNumberSecondary : String? = null,

    @CsvBindByName(column = "CoBorrowerEmailAddress")
    val coBorrowerEmailAddress : String? = null,

    @CsvBindByName(column = "CoBorrowerDOB")
    val coBorrowerDOB : String? = null,

    @CsvBindByName(column = "EscrowedIndicator")
    val escrowedIndicator : String? = null,

    @CsvBindByName(column = "NextEscrowAnalysisDate")
    val nextEscrowAnalysisDate : String? = null,

    @CsvBindByName(column = "HOI1_ExpirationDate")
    val hoi1ExpirationDate : String? = null,

    @CsvBindByName(column = "HOI1_Carrier")
    val hoi1Carrier : String? = null,

    @CsvBindByName(column = "HOI1_DwellingCoverage")
    val hoi1DwellingCoverage : String? = null,

    @CsvBindByName(column = "HOI1_PremiumAmount")
    val hoi1PremiumAmount : String? = null,

    @CsvBindByName(column = "HOI1_PolicyType")
    val hoi1PolicyType : String? = null,

    @CsvBindByName(column = "HOI2_ExpirationDate")
    val hoi2ExpirationDate : String? = null,

    @CsvBindByName(column = "HOI2_Carrier")
    val hoi2Carrier : String? = null,

    @CsvBindByName(column = "HOI2_DwellingCoverage")
    val hoi2DwellingCoverage : String? = null,

    @CsvBindByName(column = "HOI2_PremiumAmount")
    val hoi2PremiumAmount : String? = null,

    @CsvBindByName(column = "HOI2_PolicyType")
    val hoi2PolicyType : String? = null,

    @CsvBindByName(column = "HOI3_ExpirationDate")
    val hoi3ExpirationDate : String? = null,

    @CsvBindByName(column = "HOI3_Carrier")
    val hoi3Carrier : String? = null,

    @CsvBindByName(column = "HOI3_DwellingCoverage")
    val hoi3DwellingCoverage : String? = null,

    @CsvBindByName(column = "HOI3_PremiumAmount")
    val hoi3PremiumAmount : String? = null,

    @CsvBindByName(column = "HOI3_PolicyType")
    val hoi3PolicyType : String? = null,

    @CsvBindByName(column = "HOI4_ExpirationDate")
    val hoi4ExpirationDate : String? = null,

    @CsvBindByName(column = "HOI4_Carrier")
    val hoi4Carrier : String? = null,

    @CsvBindByName(column = "HOI4_DwellingCoverage")
    val hoi4DwellingCoverage : String? = null,

    @CsvBindByName(column = "HOI4_PremiumAmount")
    val hoi4PremiumAmount : String? = null,

    @CsvBindByName(column = "HOI4_PolicyType")
    val hoi4PolicyType : String? = null,

    @CsvBindByName(column = "HOI5_ExpirationDate")
    val hoi5ExpirationDate : String? = null,

    @CsvBindByName(column = "HOI5_Carrier")
    val hoi5Carrier : String? = null,

    @CsvBindByName(column = "HOI5_DwellingCoverage")
    val hoi5DwellingCoverage : String? = null,

    @CsvBindByName(column = "HOI5_PremiumAmount")
    val hoi5PremiumAmount : String? = null,

    @CsvBindByName(column = "HOI5_PolicyType")
    val hoi5PolicyType : String? = null,

    @CsvBindByName(column = "RestrictedCampaignCode")
    val restrictedCampaignCode : String? = null,
)