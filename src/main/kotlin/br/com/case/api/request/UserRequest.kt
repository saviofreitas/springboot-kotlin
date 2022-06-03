package br.com.case.api.request

import io.swagger.v3.oas.annotations.media.Schema
import javax.validation.constraints.NotBlank

@Schema(description = "UserRequest")
data class UserRequest(
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
    val document: Long)