package br.com.case.api.controller

import br.com.case.api.request.UserRequest
import br.com.case.api.response.UserResponse
import br.com.case.converter.UserConverter
import br.com.case.model.User
import br.com.case.service.UserService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
@Validated
class UserController(val userService: UserService, val userConverter: UserConverter) {

    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): UserResponse? {
        return userConverter.toResponse(userService.get(id))
    }

    @PostMapping
    @ResponseStatus(CREATED)
    fun save(@Valid @RequestBody request: UserRequest): UserResponse {
        return userConverter.toResponse(userService.save(userConverter.toModel(request)))
    }

    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    fun update(@PathVariable("id") id: Long, @RequestBody request: UserRequest): UserResponse {
        return userConverter.toResponse(userService.update(id, userConverter.toModel(request)))
    }
}