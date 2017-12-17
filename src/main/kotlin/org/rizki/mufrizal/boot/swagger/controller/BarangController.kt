package org.rizki.mufrizal.boot.swagger.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.annotations.Authorization
import org.rizki.mufrizal.boot.swagger.domain.Barang
import org.rizki.mufrizal.boot.swagger.helpers.ErrorMessage
import org.rizki.mufrizal.boot.swagger.helpers.ErrorRestHelper
import org.rizki.mufrizal.boot.swagger.helpers.ValidationIdHelper
import org.rizki.mufrizal.boot.swagger.helpers.swaggermapping.MappingMessage
import org.rizki.mufrizal.boot.swagger.helpers.swaggermapping.PageBarang
import org.rizki.mufrizal.boot.swagger.service.BarangService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

/**
 *
 * @Author Rizki Mufrizal <mufrizalrizki@gmail.com>
 * @Web <https://RizkiMufrizal.github.io>
 * @Since 17 December 2017
 * @Time 3:52 PM
 * @Project Boot-Swagger
 * @Package org.rizki.mufrizal.boot.swagger.controller
 * @File BarangController
 *
 */

@RestController
@RequestMapping(value = ["/api"])
@Api(value = "api", basePath = "/api", description = "Barang REST API")
class BarangController @Autowired constructor(val barangService: BarangService) : ValidationIdHelper {

    @ApiOperation(value = "get all barang", authorizations = [Authorization(value = "basicAuth")])
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "response success", response = PageBarang::class),
        ApiResponse(code = 404, message = "response 404", response = ErrorMessage::class),
        ApiResponse(code = 401, message = "response 401", response = ErrorMessage::class),
        ApiResponse(code = 403, message = "response 403", response = ErrorMessage::class),
        ApiResponse(code = 500, message = "response 500", response = ErrorMessage::class)
    ])
    @GetMapping(value = ["/barangs"])
    fun getBarangs(pageable: Pageable): ResponseEntity<*> {
        return ResponseEntity(this.barangService.getBarangs(pageable), HttpStatus.OK)
    }

    @ApiOperation(value = "get all barang", authorizations = [Authorization(value = "basicAuth")])
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "response success", response = Barang::class),
        ApiResponse(code = 404, message = "response 404", response = ErrorMessage::class),
        ApiResponse(code = 401, message = "response 401", response = ErrorMessage::class),
        ApiResponse(code = 403, message = "response 403", response = ErrorMessage::class),
        ApiResponse(code = 500, message = "response 500", response = ErrorMessage::class)
    ])
    @GetMapping(value = ["/barangs/{idBarang}"])
    fun getBarang(@PathVariable("idBarang") idBarang: String): Barang {
        this.validateSelf(idBarang)
        return this.barangService.getBarang(idBarang).orElse(null)
    }

    @ApiOperation(value = "get all barang", authorizations = [Authorization(value = "basicAuth")])
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "response success", response = Barang::class),
        ApiResponse(code = 404, message = "response 404", response = ErrorMessage::class),
        ApiResponse(code = 401, message = "response 401", response = ErrorMessage::class),
        ApiResponse(code = 403, message = "response 403", response = ErrorMessage::class),
        ApiResponse(code = 500, message = "response 500", response = ErrorMessage::class)
    ])
    @PostMapping(value = ["/barangs"])
    fun saveBarangs(
            @RequestBody @Valid barang: Barang): ResponseEntity<*> {
        val barang1 = this.barangService.saveBarang(Barang(
                idBarang = barang.idBarang,
                namaBarang = barang.namaBarang,
                jenisBarang = barang.jenisBarang
        ))

        return ResponseEntity(barang1, HttpStatus.CREATED)
    }

    @ApiOperation(value = "get all barang", authorizations = [Authorization(value = "basicAuth")])
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "response success", response = Barang::class),
        ApiResponse(code = 404, message = "response 404", response = ErrorMessage::class),
        ApiResponse(code = 401, message = "response 401", response = ErrorMessage::class),
        ApiResponse(code = 403, message = "response 403", response = ErrorMessage::class),
        ApiResponse(code = 500, message = "response 500", response = ErrorMessage::class)
    ])
    @PutMapping(value = ["/barangs/{idBarang}"])
    fun updateBarangs(
            @PathVariable("idBarang") idBarang: String,
            @RequestBody @Valid barang: Barang): ResponseEntity<*> {

        this.validateSelf(idBarang)

        val barang1 = this.barangService.updateBarang(Barang(
                idBarang = idBarang,
                namaBarang = barang.namaBarang,
                jenisBarang = barang.jenisBarang
        ))

        return ResponseEntity(barang1, HttpStatus.OK)
    }

    @ApiOperation(value = "get all barang", authorizations = [Authorization(value = "basicAuth")])
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "response success", response = MappingMessage::class),
        ApiResponse(code = 404, message = "response 404", response = ErrorMessage::class),
        ApiResponse(code = 401, message = "response 401", response = ErrorMessage::class),
        ApiResponse(code = 403, message = "response 403", response = ErrorMessage::class),
        ApiResponse(code = 500, message = "response 500", response = ErrorMessage::class)
    ])
    @DeleteMapping(value = ["/barangs/{idBarang}"])
    fun deleteBarangs(
            @PathVariable("idBarang") idBarang: String): ResponseEntity<*> {

        this.validateSelf(idBarang)

        barangService.deleteBarang(idBarang)
        val map = mutableMapOf<String, Any>()
        map.put("Success", true)
        map.put("Message", "Success Deleted")
        return ResponseEntity(map, HttpStatus.OK)
    }

    override fun validateSelf(id: String) {
        this.barangService.getBarang(id).orElseThrow { ErrorRestHelper(message = "$id Data Barang Tidak Tersedia") }
    }
}