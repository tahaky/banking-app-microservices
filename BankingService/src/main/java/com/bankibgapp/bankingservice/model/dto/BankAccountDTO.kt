package com.bankibgapp.bankingservice.model.dto

import com.bankibgapp.bankingservice.model.AccountStatus
import com.bankibgapp.bankingservice.model.AccountType
import com.bankibgapp.bankingservice.model.entity.User
import java.math.BigDecimal
import java.util.*

data class BankAccountDTO @JvmOverloads constructor(
    val id: UUID?=null,
    val number: String?=null,
    val accountType: AccountType?=null,
    val accountStatus: AccountStatus?=null,
    val availableBalance: BigDecimal?=null,
    val actualBalance: BigDecimal?=null,
    val user: User?=null
){
}