package org.rizki.mufrizal.boot.swagger.domain

import javax.persistence.CollectionTable
import javax.persistence.Column
import javax.persistence.ElementCollection
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.Table

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:34 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.domain
 * @File User
 *
 */

@Entity
@Table(name = "tb_user")
data class User(
        @Id
        @Column(length = 50, nullable = false)
        val username: String? = null,
        @Column(length = 100, nullable = false)
        val password: String? = null,
        @Column(name = "is_active", length = 100, nullable = false)
        val isActive: Boolean? = null,
        @ElementCollection(fetch = FetchType.EAGER)
        @CollectionTable(name = "roles", joinColumns = [(JoinColumn(name = "username"))])
        @Column(name = "role")
        val roles: Set<String>? = null
)