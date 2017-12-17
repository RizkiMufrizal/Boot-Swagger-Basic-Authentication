package org.rizki.mufrizal.boot.swagger.helpers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:52 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.helpers
 * @File ErrorHandlerAdviceHelper
 *
 */

@ControllerAdvice
class ErrorHandlerAdviceHelper {

    @ExceptionHandler(ErrorRestHelper::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun idNotFoundExceptionHandler(notFoundRestHelper: ErrorRestHelper): ResponseEntity<*> {
        val errorMessage = ErrorMessage(Success = false, Message = notFoundRestHelper.localizedMessage, ErrorCode = HttpStatus.NOT_FOUND.value())
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

}