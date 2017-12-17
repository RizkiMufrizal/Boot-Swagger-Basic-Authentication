package org.rizki.mufrizal.boot.swagger.helpers

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:53 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.helpers
 * @File NotFoundRestHelper
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
class NotFoundRestHelper(id: String, message: String) : RuntimeException("$message $id")