package org.rizki.mufrizal.boot.swagger.service

import org.rizki.mufrizal.boot.swagger.domain.Barang
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:48 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger
 * @File BarangService
 *
 */

interface BarangService {
    fun getBarangs(pageable: Pageable): Page<Barang>
    fun saveBarang(barang: Barang): Barang
    fun updateBarang(barang: Barang): Barang
    fun deleteBarang(idBarang: String)
    fun getBarang(idBarang: String): Optional<Barang>
}