package br.com.case.converter

import br.com.case.api.request.UserRequest
import br.com.case.api.response.UserResponse
import br.com.case.model.User
import org.springframework.stereotype.Component

@Component
class UserConverter {

    fun toResponse(user: User): UserResponse {
        return UserResponse(user.id, user.name, user.document, user.createdAt, user.updatedAt)
    }

    fun toModel(request: UserRequest): User {
        return User(request.name, request.document)
    }
}