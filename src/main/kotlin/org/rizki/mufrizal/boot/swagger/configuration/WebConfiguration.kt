package org.rizki.mufrizal.boot.swagger.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 08 January 2018
 * @Time 10:11 AM
 * @Project Boot-Swagger-Basic-Authentication
 * @Package org.rizki.mufrizal.boot.swagger.configuration
 * @File WebConfiguration
 *
 */

@Configuration
@EnableWebMvc
class WebConfiguration : WebMvcConfigurerAdapter() {

    override fun addResourceHandlers(resourceHandlerRegistry: ResourceHandlerRegistry?) {
        resourceHandlerRegistry?.addResourceHandler("swagger-ui.html")
                ?.addResourceLocations("classpath:/META-INF/resources/")

        resourceHandlerRegistry?.addResourceHandler("/webjars/**")
                ?.addResourceLocations("classpath:/META-INF/resources/webjars/")
    }

}