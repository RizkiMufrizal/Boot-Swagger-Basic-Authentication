package org.rizki.mufrizal.boot.swagger.repository

import org.rizki.mufrizal.boot.swagger.domain.Barang
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:47 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.repository
 * @File BarangRepository
 *
 */

interface BarangRepository : PagingAndSortingRepository<Barang, String> {
    fun findByIdBarang(idBarang: String): Optional<Barang>
}