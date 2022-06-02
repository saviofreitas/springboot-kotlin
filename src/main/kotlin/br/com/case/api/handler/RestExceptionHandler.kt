package br.com.case.api.handler

import br.com.case.exception.UserNotFoundException
import org.hibernate.exception.ConstraintViolationException
import org.springframework.core.codec.CodecException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ExceptionHandler

@ResponseBody
@ControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(exception: UserNotFoundException): ResponseEntity<ErrorResponse> {
        return errorResponse(exception.localizedMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(
        CodecException::class,
        HttpMessageNotReadableException::class,
        ConstraintViolationException::class
    )
    fun handleCodecException(exception: Exception): ResponseEntity<ErrorResponse> {
        return errorResponse("Invalid request", HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(Throwable::class)
    fun handleInternalServerErrorException(e: Throwable): ResponseEntity<ErrorResponse> {
        return errorResponse("Generic internal error", HttpStatus.INTERNAL_SERVER_ERROR)
    }

    private fun errorResponse(message: String, status: HttpStatus): ResponseEntity<ErrorResponse> {
        return ResponseEntity(ErrorResponse(message, status.value()), status)
    }
}