package com.minzino.portfolio.admin.context.introduction.controller

import com.minzino.portfolio.admin.context.achievement.form.AchievementForm
import com.minzino.portfolio.admin.context.achievement.service.AdminAchievementService
import com.minzino.portfolio.admin.context.introduction.form.IntroductionForm
import com.minzino.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.minzino.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/admin/api/introductions")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: IntroductionForm, @PathVariable id:Long): ResponseEntity<Any> {
        adminIntroductionService.update(id,form)

        return ApiResponse.successUpdate()

    }
}