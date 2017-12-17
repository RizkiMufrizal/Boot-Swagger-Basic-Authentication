package org.rizki.mufrizal.boot.swagger.helpers

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerExceptionResolver
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 10:20 PM
 * @Project Boot-Swagger-Basic-Authentication
 * @Package org.rizki.mufrizal.boot.swagger.helpers
 * @File AccessDeniedHandlerHelper
 *
 */

@Component
class AccessDeniedHandlerHelper @Autowired constructor(val handlerExceptionResolver: HandlerExceptionResolver) : AccessDeniedHandler, AuthenticationEntryPoint {
    override fun commence(request: HttpServletRequest?, response: HttpServletResponse?, authException: AuthenticationException?) {
        val errorMessage = ErrorMessage(Success = false, Message = "Forbidden", ErrorCode = HttpStatus.FORBIDDEN.value())
        val objectMapper = ObjectMapper()

        response?.status = HttpStatus.FORBIDDEN.value()
        response?.contentType = "application/json"
        response?.characterEncoding = "UTF-8"
        response?.writer?.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMessage))
        response?.writer?.flush()
        response?.writer?.close()

        this.handlerExceptionResolver.resolveException(request, response, null, authException)
    }

    override fun handle(request: HttpServletRequest?, response: HttpServletResponse?, accessDeniedException: AccessDeniedException?) {
        val errorMessage = ErrorMessage(Success = false, Message = "Forbidden", ErrorCode = HttpStatus.FORBIDDEN.value())
        val objectMapper = ObjectMapper()

        response?.status = HttpStatus.FORBIDDEN.value()
        response?.contentType = "application/json"
        response?.characterEncoding = "UTF-8"
        response?.writer?.write(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errorMessage))
        response?.writer?.flush()
        response?.writer?.close()

        this.handlerExceptionResolver.resolveException(request, response, null, accessDeniedException)
    }
}