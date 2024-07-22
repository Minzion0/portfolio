package com.minzino.portfolio.domain.presentation.controller

import com.minzino.portfolio.domain.presentation.dto.IntroductionDTO
import com.minzino.portfolio.domain.presentation.dto.LinkDTO
import com.minzino.portfolio.domain.presentation.dto.ProjectDTO
import com.minzino.portfolio.domain.presentation.dto.ResumeDTO
import com.minzino.portfolio.domain.presentation.service.PresentationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

// REST 컨트롤러로 선언하여 API 엔드포인트를 제공합니다.
@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {

    // 간단한 테스트 엔드포인트입니다.
    @GetMapping("/test")
    fun test(): String {
        return "ok"
    }

    // 자기소개 목록을 반환하는 엔드포인트입니다.
    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    // 링크 목록을 반환하는 엔드포인트입니다.
    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    // 이력서를 반환하는 엔드포인트입니다.
    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }

    // 프로젝트 목록을 반환하는 엔드포인트입니다.
    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }
}