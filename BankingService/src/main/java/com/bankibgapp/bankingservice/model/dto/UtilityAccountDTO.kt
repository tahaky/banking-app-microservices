package com.bankibgapp.bankingservice.model.dto

import java.util.*

data class UtilityAccountDTO @JvmOverloads constructor(
    var id: UUID? = null,
    var number: String? = null,
    var providerName: String? = null
)