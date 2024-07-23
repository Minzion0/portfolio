package com.minzino.portfolio.domain.presentation.controller

import com.minzino.portfolio.domain.constant.SkillType
import com.minzino.portfolio.domain.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

// 뷰 컨트롤러로 선언하여 HTML 템플릿을 렌더링하는 엔드포인트를 제공합니다.
@Controller
class PresentationViewController(
    private val presentationService: PresentationService
) {

    // 간단한 테스트 엔드포인트입니다. "test" 뷰를 반환합니다.
    @GetMapping("/test")
    fun test(): String {
        return "test"
    }

    // 메인 페이지를 렌더링합니다.
    @GetMapping("/")
    fun index(model: Model): String {
        val introductions = presentationService.getIntroductions()
        model.addAttribute("introductions", introductions)

        val links = presentationService.getLinks()
        model.addAttribute("links", links)

        return "presentation/index"
    }

    // 이력서 페이지를 렌더링합니다.
    @GetMapping("/resume")
    fun resume(model: Model): String {
        val resumeDTO = presentationService.getResume()
        model.addAttribute("resume", resumeDTO)
        model.addAttribute("skillTypes", SkillType.values())

        return "presentation/resume"
    }

    // 프로젝트 페이지를 렌더링합니다.
    @GetMapping("/projects")
    fun projects(model: Model): String {
        val projects = presentationService.getProjects()
        model.addAttribute("projects", projects)

        return "presentation/projects"
    }
}