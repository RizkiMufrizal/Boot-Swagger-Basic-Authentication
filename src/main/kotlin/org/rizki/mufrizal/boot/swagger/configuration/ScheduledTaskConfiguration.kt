package org.rizki.mufrizal.boot.swagger.configuration

import org.rizki.mufrizal.boot.swagger.domain.Barang
import org.rizki.mufrizal.boot.swagger.domain.JenisBarang
import org.rizki.mufrizal.boot.swagger.domain.User
import org.rizki.mufrizal.boot.swagger.repository.BarangRepository
import org.rizki.mufrizal.boot.swagger.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Component

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:56 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.configuration
 * @File ScheduledTaskConfiguration
 *
 */

@EnableScheduling
@Component
class ScheduledTaskConfiguration {

    @Autowired
    private lateinit var userRepositoty: UserRepository

    @Autowired
    private lateinit var barangRepository: BarangRepository

    @Scheduled(fixedRate = 3600000)
    fun insertData() {
        if (!this.userRepositoty.findByUsername("admin").isPresent) {
            this.userRepositoty.save(User(
                    username = "admin",
                    password = BCryptPasswordEncoder().encode("admin"),
                    isActive = true,
                    roles = setOf("ROLE_ADMIN", "ROLE_USER")
            ))
        }

        //just for development
        if (this.barangRepository.findAll().count() == 0) {
            for (b in 0..10) {
                this.barangRepository.save(Barang(
                        namaBarang = "Nama $b",
                        jenisBarang = if (b % 2 == 0) JenisBarang.cair else JenisBarang.gas
                ))
            }
        }
    }
}