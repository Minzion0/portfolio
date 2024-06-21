package com.minzino.portfolio.admin.context.skill.controller

import com.minzino.portfolio.admin.context.skill.form.SkillForm
import com.minzino.portfolio.admin.context.skill.service.AdminSkillService
import com.minzino.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/skills")
class AdminSkillApiController(
    private val adminSkillService: AdminSkillService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: SkillForm): ResponseEntity<Any> {
        adminSkillService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: SkillForm, @PathVariable id:Long): ResponseEntity<Any> {
        adminSkillService.update(id,form)

        return ApiResponse.successUpdate()

    }
}