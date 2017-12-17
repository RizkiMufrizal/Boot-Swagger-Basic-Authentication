package org.rizki.mufrizal.boot.swagger.helpers

import org.springframework.hateoas.VndErrors
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseBody
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

    @ResponseBody
    @ExceptionHandler(NotFoundRestHelper::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    fun idNotFoundExceptionHandler(notFoundRestHelper: NotFoundRestHelper): VndErrors {
        return VndErrors("error", notFoundRestHelper.message)
    }

}