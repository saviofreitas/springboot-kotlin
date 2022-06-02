package br.com.case.api.request

import javax.validation.constraints.NotBlank

data class UserRequest(val name: String, val document: Long)