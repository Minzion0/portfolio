package com.minzino.portfolio.domain.presentation.repository

import com.minzino.portfolio.domain.entity.*
import com.minzino.portfolio.domain.repository.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
class PresentationRepository(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository
) {
    fun getActiveAchievements(): List<Achievement> {
        return achievementRepository.findAllByIsActive(true)
    }

    fun getActiveExperience(): List<Experience> {
        return experienceRepository.findAllByIsActive(true)
    }

    fun getActiveIntroduction(): List<Introduction> {
        return introductionRepository.findAllByIsActive(true)
    }

    fun getActiveLink(): List<Link> {
        return linkRepository.findAllByIsActive(true)
    }

    fun getActiveSkill(): List<Skill> {
        return skillRepository.findAllByIsActive(true)
    }

    fun getActiveProject(): List<Project> {
        return projectRepository.findAllByIsActive(true)
    }
}