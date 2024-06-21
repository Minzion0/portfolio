package com.minzino.portfolio.admin.context.experience.controller

import com.minzino.portfolio.admin.context.experience.form.ExperienceForm
import com.minzino.portfolio.admin.context.experience.service.AdminExperienceService
import com.minzino.portfolio.admin.context.link.form.LinkForm
import com.minzino.portfolio.admin.context.link.service.AdminLinkService
import com.minzino.portfolio.admin.data.ApiResponse
import com.minzino.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/experiences")
class AdminExperienceApiController(
    private val adminExperienceService: AdminExperienceService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: ExperienceForm): ResponseEntity<Any> {
        adminExperienceService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: ExperienceForm, @PathVariable id:Long): ResponseEntity<Any> {
        adminExperienceService.update(id,form)

        return ApiResponse.successUpdate()

    }

    @GetMapping("/{id}/details")
    fun getExperienceDetails(@PathVariable id:Long):TableDTO{
        return adminExperienceService.getExperienceDetailTable(id)
    }
}