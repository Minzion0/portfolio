package com.minzino.portfolio.admin.context.introduction.controller

import com.minzino.portfolio.admin.context.introduction.form.IntroductionForm
import com.minzino.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.minzino.portfolio.admin.data.ApiResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin/api/introductions")
class AdminIntroductionApiController(
    private val adminIntroductionService: AdminIntroductionService
) {
    // 새로운 소개글을 등록하는 엔드포인트
    @PostMapping
    fun postAchievement(@RequestBody @Validated form: IntroductionForm): ResponseEntity<Any> {
        adminIntroductionService.save(form)
        return ApiResponse.successCreate()
    }

    // 기존 소개글을 수정하는 엔드포인트
    @PutMapping("/{id}")
    fun putAchievement(@RequestBody form: IntroductionForm, @PathVariable id: Long): ResponseEntity<Any> {
        adminIntroductionService.update(id, form)
        return ApiResponse.successUpdate()
    }
}