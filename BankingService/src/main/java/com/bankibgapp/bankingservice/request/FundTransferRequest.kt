package com.bankibgapp.bankingservice.request

import java.math.BigDecimal

data class FundTransferRequest @JvmOverloads constructor(
    val fromAccount:String?=null,
    val toAccount:String?=null,
    val amount:BigDecimal?=null,
)