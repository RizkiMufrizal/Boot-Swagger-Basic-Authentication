package org.rizki.mufrizal.boot.swagger.helpers.swaggermapping

import org.rizki.mufrizal.boot.swagger.domain.Barang


/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 6:00 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.helpers.swaggermapping
 * @File PageBarang
 *
 */

data class PageBarang(
        override val content: List<Barang>? = null,
        override val first: Boolean? = null,
        override val last: Boolean? = null,
        override val number: Int? = null,
        override val numberOfElements: Int? = null,
        override val size: Int? = null,
        override val sort: Any? = null,
        override val totalElements: Int? = null,
        override val totalPages: Int? = null
) : PageMapping<Barang>()