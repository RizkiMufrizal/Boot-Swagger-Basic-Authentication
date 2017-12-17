package org.rizki.mufrizal.boot.swagger.configuration

import org.springframework.stereotype.Component
import java.io.IOException
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.FilterConfig
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:32 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.configuration
 * @File CorsConfiguration
 *
 */

@Component
class CorsConfiguration : Filter {

    @Throws(ServletException::class)
    override fun init(filterConfig: FilterConfig) {

    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse, chain: FilterChain) {
        val httpServletResponse = response as HttpServletResponse
        val httpServletRequest = request as HttpServletRequest

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*")
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT")
        httpServletResponse.setHeader("Access-Control-Max-Age", "3600")
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "accept, authorization, x-requested-with, content-type")

        if (httpServletRequest.method.equals("OPTIONS", ignoreCase = true)) {
            try {
                httpServletResponse.status = 200
                httpServletResponse.writer.print("OK")
                httpServletResponse.writer.flush()
            } catch (e: IOException) {
                e.printStackTrace()
            }

        } else {
            chain.doFilter(request, response)
        }
    }

    override fun destroy() {

    }
}