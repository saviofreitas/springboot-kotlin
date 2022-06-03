package br.com.case.api.controller

import br.com.case.api.request.UserRequest
import br.com.case.api.response.UserResponse
import br.com.case.converter.UserConverter
import br.com.case.model.User
import br.com.case.service.UserService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.OK
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("users")
@Validated
class UserController(val userService: UserService, val userConverter: UserConverter) {

    @Operation(summary = "Get User by id", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "404", description = "Such a user does not exist"),

        ]
    )
    @GetMapping("/{id}")
    fun get(@PathVariable("id") id: Long): UserResponse {
        return userConverter.toResponse(userService.get(id))
    }

    @Operation(summary = "Create User", description = "Returns 201 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Successful Operation"),
            ApiResponse(responseCode = "400", description = "Invalid request"),

        ]
    )
    @PostMapping
    @ResponseStatus(CREATED)
    fun save(@Valid @RequestBody request: UserRequest): UserResponse {
        return userConverter.toResponse(userService.save(userConverter.toModel(request)))
    }

    @Operation(summary = "Update User", description = "Returns 200 if successful")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Successful Operation"),
            ApiResponse(responseCode = "400", description = "Invalid request"),

        ]
    )
    @PatchMapping("/{id}")
    @ResponseStatus(OK)
    fun update(@PathVariable("id") id: Long, @RequestBody request: UserRequest): UserResponse {
        return userConverter.toResponse(userService.update(id, userConverter.toModel(request)))
    }
}