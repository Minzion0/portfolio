package com.minzino.portfolio.admin.context.project.controller

import com.minzino.portfolio.admin.context.experience.form.ExperienceForm
import com.minzino.portfolio.admin.context.experience.service.AdminExperienceService
import com.minzino.portfolio.admin.context.link.form.LinkForm
import com.minzino.portfolio.admin.context.link.service.AdminLinkService
import com.minzino.portfolio.admin.context.project.form.ProjectForm
import com.minzino.portfolio.admin.context.project.form.ProjectSkillForm
import com.minzino.portfolio.admin.context.project.service.AdminProjectService
import com.minzino.portfolio.admin.context.project.service.AdminProjectSkillService
import com.minzino.portfolio.admin.data.ApiResponse
import com.minzino.portfolio.admin.data.TableDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/projects/skills")
class AdminProjectSkillApiController(
    private val adminProjectSkillService: AdminProjectSkillService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: ProjectSkillForm): ResponseEntity<Any> {
        adminProjectSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @DeleteMapping("/{id}")
    fun deleteProjectSkill(@PathVariable id:Long) : ResponseEntity<Any>{
        adminProjectSkillService.delete(id)
        return ApiResponse.successDelete()
    }
}