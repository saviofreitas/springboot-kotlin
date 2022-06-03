package br.com.case.api.response

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime

@Schema(description = "UserResponse")
data class UserResponse(
    @field:Schema(
        description = "Users id",
        example = "1",
        type = "long"
    )
    val id: Long?,

    @field:Schema(
        description = "Users name",
        example = "John Doe",
        type = "string"
    )
    val name: String,

    @field:Schema(
        description = "Users document",
        example = "123456",
        type = "long"
    )
    val document: Long,

    @field:Schema(
        description = "Users creation date",
        example = "2022-06-02T22:08",
        type = "dateTime"
    )
    @JsonProperty("created_at")
    val createdAt: LocalDateTime,

    @field:Schema(
        description = "Users update date",
        example = "2022-06-02T22:08",
        type = "dateTime"
    )
    @JsonProperty("updated_at")
    val updatedAt: LocalDateTime)