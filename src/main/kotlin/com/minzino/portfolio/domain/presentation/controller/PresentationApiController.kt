package com.minzino.portfolio.domain.presentation.controller

import com.minzino.portfolio.domain.presentation.dto.IntroductionDTO
import com.minzino.portfolio.domain.presentation.dto.LinkDTO
import com.minzino.portfolio.domain.presentation.dto.ProjectDTO
import com.minzino.portfolio.domain.presentation.dto.ResumeDTO
import com.minzino.portfolio.domain.presentation.service.PresentationService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class PresentationApiController(
    private val presentationService: PresentationService
) {


    @GetMapping("/test")

    fun test(): String {
        return "ok"
    }

    @GetMapping("/v1/introductions")
    fun getIntroductions(): List<IntroductionDTO> {
        return presentationService.getIntroductions()
    }

    @GetMapping("/v1/links")
    fun getLinks(): List<LinkDTO> {
        return presentationService.getLinks()
    }

    @GetMapping("/v1/resume")
    fun getResume(): ResumeDTO {
        return presentationService.getResume()
    }

    @GetMapping("/v1/projects")
    fun getProjects(): List<ProjectDTO> {
        return presentationService.getProjects()
    }
}