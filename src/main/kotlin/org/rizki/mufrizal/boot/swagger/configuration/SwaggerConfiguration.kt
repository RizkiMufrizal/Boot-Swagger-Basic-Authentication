package org.rizki.mufrizal.boot.swagger.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.BasicAuth
import springfox.documentation.service.Contact

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 4:04 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.configuration
 * @File SwaggerConfiguration
 *
 */

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    private fun getApiInfo(): ApiInfo {
        val contact = Contact("Rizki Mufrizal", "https://rizkimufrizal.github.io", "mufrizalrizki@gmail.com")
        return ApiInfoBuilder()
                .title("Boot Swagger")
                .description("API Documentation")
                .version("1.0.0")
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
                .contact(contact)
                .build()
    }

    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(listOf(BasicAuth("basicAuth")))
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.rizki.mufrizal.boot.swagger.controller"))
                .paths(PathSelectors.any())
                .build()
    }

}