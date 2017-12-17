package org.rizki.mufrizal.boot.swagger.helpers.swaggermapping

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 6:13 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.helpers.swaggermapping
 * @File PageMapping
 *
 */

abstract class PageMapping<out T> {
    abstract val content: List<T>?
    abstract val first: Boolean?
    abstract val last: Boolean?
    abstract val number: Int?
    abstract val numberOfElements: Int?
    abstract val size: Int?
    abstract val sort: Any?
    abstract val totalElements: Int?
    abstract val totalPages: Int?
}