package org.rizki.mufrizal.boot.swagger.helpers


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 8:58 PM
 * @Project Boot-Swagger-Basic-Authentication
 * @Package org.rizki.mufrizal.boot.swagger.helpers
 * @File ErrorMessage
 *
 */

data class ErrorMessage(val Success: Boolean? = null, val Message: String? = null, val ErrorCode: Int? = null)