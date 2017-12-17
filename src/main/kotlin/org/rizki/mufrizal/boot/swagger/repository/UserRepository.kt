package org.rizki.mufrizal.boot.swagger.repository

import org.rizki.mufrizal.boot.swagger.domain.User
import org.springframework.data.repository.PagingAndSortingRepository
import java.util.Optional

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:35 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.repository
 * @File UserRepository
 *
 */

interface UserRepository : PagingAndSortingRepository<User, String> {
    fun findByUsername(username: String): Optional<User>
}