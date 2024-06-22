package com.minzino.portfolio.admin.context.project.controller

import com.minzino.portfolio.admin.context.experience.form.ExperienceForm
import com.minzino.portfolio.admin.context.experience.service.AdminExperienceService
import com.minzino.portfolio.admin.context.link.form.LinkForm
import com.minzino.portfolio.admin.context.link.service.AdminLinkService
import com.minzino.portfolio.admin.context.project.form.ProjectForm
import com.minzino.portfolio.admin.context.project.service.AdminProjectService
import com.minzino.portfolio.admin.data.ApiResponse
import com.minzino.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/projects")
class AdminProjectApiController(
    private val adminProjectService: AdminProjectService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: ProjectForm): ResponseEntity<Any> {
        adminProjectService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: ProjectForm, @PathVariable id:Long): ResponseEntity<Any> {
        adminProjectService.update(id,form)

        return ApiResponse.successUpdate()

    }

    @GetMapping("/{id}/details")
    fun getExperienceDetails(@PathVariable id:Long):TableDTO{
        return adminProjectService.getProjectDetailTable(id)
    }
}