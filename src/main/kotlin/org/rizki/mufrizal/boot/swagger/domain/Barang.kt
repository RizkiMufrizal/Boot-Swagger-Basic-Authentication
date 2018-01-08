package org.rizki.mufrizal.boot.swagger.domain

import io.swagger.annotations.ApiModelProperty
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table
import javax.validation.constraints.NotNull

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:46 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.domain
 * @File Barang
 *
 */

@Entity
@Table(name = "tb_barang")
data class Barang(
        @Id
        @GeneratedValue(generator = "uuid2")
        @GenericGenerator(name = "uuid2", strategy = "uuid2")
        @Column(length = 36, name = "id_barang")
        @ApiModelProperty(example = "001", required = true)
        val idBarang: String? = null,
        @NotEmpty
        @NotNull
        @Column(length = 50, name = "nama_barang")
        @ApiModelProperty(example = "rinso", required = true)
        val namaBarang: String? = null,
        @NotNull
        @Enumerated(EnumType.STRING)
        @ApiModelProperty(example = "gas", required = true)
        @Column(length = 36, name = "jenis_barang")
        val jenisBarang: JenisBarang? = null
)