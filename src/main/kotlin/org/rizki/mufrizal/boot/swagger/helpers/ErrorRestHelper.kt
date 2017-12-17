package org.rizki.mufrizal.boot.swagger.helpers

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:53 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.helpers
 * @File ErrorRestHelper
 *
 */

class ErrorRestHelper(message: String) : RuntimeException(message)