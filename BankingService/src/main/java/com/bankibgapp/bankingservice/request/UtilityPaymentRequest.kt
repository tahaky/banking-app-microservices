package com.bankibgapp.bankingservice.request

import java.math.BigDecimal
import java.util.*

data class UtilityPaymentRequest @JvmOverloads constructor(
    var providerId: UUID,
    var amount: BigDecimal,
    var referenceNumber: String,
    var account: String
)