package com.ferit.uiojqanlrg.data.model.common

class AppError(
    val code: String,
    val message: String
)

data class CustomErrorMessage(
    val key: String,
    val content: String
)