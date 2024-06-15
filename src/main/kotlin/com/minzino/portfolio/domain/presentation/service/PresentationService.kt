package com.minzino.portfolio.domain.presentation.service

import com.minzino.portfolio.domain.presentation.dto.IntroductionDTO
import com.minzino.portfolio.domain.presentation.dto.LinkDTO
import com.minzino.portfolio.domain.presentation.dto.ProjectDTO
import com.minzino.portfolio.domain.presentation.dto.ResumeDTO
import com.minzino.portfolio.domain.presentation.repository.PresentationRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {
    @Transactional(readOnly = true)
    fun getIntroductions():List<IntroductionDTO>{
        val introductions = presentationRepository.getActiveIntroduction()

        return introductions.map { IntroductionDTO(it) }
    }
    @Transactional(readOnly = true)
    fun getLinks():List<LinkDTO>{
        val links = presentationRepository.getActiveLink()

        return links.map { LinkDTO(it) }
    }
    @Transactional(readOnly = true)
    fun getResume():ResumeDTO{
        val experiences = presentationRepository.getActiveExperience()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkill()

        return ResumeDTO(
            experiences=experiences,
            achievements=achievements,
            skills=skills
        )
    }

    @Transactional(readOnly = true)
    fun getProjects():List<ProjectDTO>{
        val projects = presentationRepository.getActiveProject()
        return projects.map { ProjectDTO(it) }
    }

    
}