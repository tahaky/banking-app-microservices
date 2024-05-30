package com.bankibgapp.bankingservice.dto

import com.bankibgapp.bankingservice.model.BankAccount
import java.util.Collections
import java.util.UUID

data class UserDTO @JvmOverloads constructor(
    val id:UUID?=null,
    val firstName:String?=null,
    val lastName:String?=null,
    val email:String?=null,
    val identificationNumber:String?=null,
    val bankAccounts: List<BankAccountDTO>?=null

){
}