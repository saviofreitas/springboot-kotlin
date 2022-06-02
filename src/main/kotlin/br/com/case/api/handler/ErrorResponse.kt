package br.com.case.api.handler

import java.time.LocalDateTime
import java.time.LocalDateTime.now

data class ErrorResponse(val message: String, val status: Int, val timestamp: LocalDateTime = now())