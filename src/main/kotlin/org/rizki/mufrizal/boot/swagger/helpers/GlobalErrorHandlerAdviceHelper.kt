package org.rizki.mufrizal.boot.swagger.helpers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException
import org.springframework.security.authentication.AuthenticationServiceException
import org.springframework.security.core.AuthenticationException
import org.springframework.web.HttpRequestMethodNotSupportedException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.NoHandlerFoundException

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 9:09 PM
 * @Project Boot-Swagger-Basic-Authentication
 * @Package org.rizki.mufrizal.boot.swagger.helpers
 * @File GlobalErrorHandlerAdviceHelper
 *
 */
@RestControllerAdvice
class GlobalErrorHandlerAdviceHelper {

    @ExceptionHandler(NoHandlerFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun errorNotFoundException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Error Not Found", ErrorCode = HttpStatus.NOT_FOUND.value())
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun errorInternalServerErrorException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Internal Server Error", ErrorCode = HttpStatus.INTERNAL_SERVER_ERROR.value())
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException::class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    fun errorHttpRequestMethodNotSupportedException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Method Not Allowed", ErrorCode = HttpStatus.METHOD_NOT_ALLOWED.value())
        return ResponseEntity(errorMessage, HttpStatus.METHOD_NOT_ALLOWED)
    }

    @ExceptionHandler(AccessDeniedException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun errorAccessDeniedExceptionException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Forbidden", ErrorCode = HttpStatus.FORBIDDEN.value())
        return ResponseEntity(errorMessage, HttpStatus.FORBIDDEN)
    }

    @ExceptionHandler(AuthenticationException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun errorAuthenticationException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Unauthorized", ErrorCode = HttpStatus.UNAUTHORIZED.value())
        return ResponseEntity(errorMessage, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(AuthenticationCredentialsNotFoundException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun errorAuthenticationCredentialsNotFoundException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Unauthorized", ErrorCode = HttpStatus.UNAUTHORIZED.value())
        return ResponseEntity(errorMessage, HttpStatus.UNAUTHORIZED)
    }

    @ExceptionHandler(AuthenticationServiceException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun errorAuthenticationServiceException(exception: Exception): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = "Unauthorized", ErrorCode = HttpStatus.UNAUTHORIZED.value())
        return ResponseEntity(errorMessage, HttpStatus.UNAUTHORIZED)
    }

}