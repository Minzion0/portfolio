package com.minzino.portfolio.admin.context.link.controller

import com.minzino.portfolio.admin.context.link.form.LinkForm
import com.minzino.portfolio.admin.context.link.service.AdminLinkService
import com.minzino.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/links")
class AdminLinkApiController(
    private val adminLinkService: AdminLinkService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: LinkForm): ResponseEntity<Any> {
        adminLinkService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: LinkForm, @PathVariable id:Long): ResponseEntity<Any> {
        adminLinkService.update(id,form)

        return ApiResponse.successUpdate()

    }
}