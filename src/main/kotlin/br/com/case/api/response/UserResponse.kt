package br.com.case.api.response

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class UserResponse(
    val id: Long?,
    val name: String,
    val document: Long,
    @JsonProperty("created_at")
    val createdAt: LocalDateTime,
    @JsonProperty("updated_at")
    val updatedAt: LocalDateTime)