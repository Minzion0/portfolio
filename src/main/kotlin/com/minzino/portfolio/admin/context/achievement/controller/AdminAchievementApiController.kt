package com.minzino.portfolio.admin.context.achievement.controller

import com.minzino.portfolio.admin.context.achievement.form.AchievementForm
import com.minzino.portfolio.admin.context.achievement.service.AdminAchievementService
import com.minzino.portfolio.admin.data.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.annotation.Validated

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/api/achievements")
class AdminAchievementApiController(
    private val adminAchievementService: AdminAchievementService
) {
    @PostMapping
    fun postAchievement(@RequestBody @Validated form:AchievementForm):ResponseEntity<Any>{
        adminAchievementService.save(form)

        return ApiResponse.successCreate()
    }

    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: AchievementForm , @PathVariable id:Long):ResponseEntity<Any>{
        adminAchievementService.update(id,form)

        return ApiResponse.successUpdate()

    }

}