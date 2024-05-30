package com.bankibgapp.bankingservice.response

import java.math.BigDecimal
import java.util.*

data class FundTransferResponse @JvmOverloads constructor(
    var message: String,
    var transactionId: String,
){
}