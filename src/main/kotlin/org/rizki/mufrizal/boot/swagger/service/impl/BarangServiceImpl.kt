package org.rizki.mufrizal.boot.swagger.service.impl

import org.rizki.mufrizal.boot.swagger.domain.Barang
import org.rizki.mufrizal.boot.swagger.repository.BarangRepository
import org.rizki.mufrizal.boot.swagger.service.BarangService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:50 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.service.impl
 * @File BarangServiceImpl
 *
 */

@Service
@Transactional(readOnly = true)
class BarangServiceImpl @Autowired constructor(val barangRepository: BarangRepository) : BarangService {

    @Transactional
    override fun saveBarang(barang: Barang): Barang {
        return barangRepository.save(barang)
    }

    @Transactional
    override fun updateBarang(barang: Barang): Barang {
        return barangRepository.save(barang)
    }

    @Transactional
    override fun deleteBarang(idBarang: String) {
        barangRepository.delete(idBarang)
    }

    override fun getBarang(idBarang: String): Optional<Barang> {
        return barangRepository.findByIdBarang(idBarang)
    }

    override fun getBarangs(pageable: Pageable): Page<Barang> {
        return barangRepository.findAll(pageable)
    }
}