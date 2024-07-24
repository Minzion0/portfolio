package com.minzino.portfolio.domain.presentation.service

import com.minzino.portfolio.domain.presentation.dto.IntroductionDTO
import com.minzino.portfolio.domain.presentation.dto.LinkDTO
import com.minzino.portfolio.domain.presentation.dto.ProjectDTO
import com.minzino.portfolio.domain.presentation.dto.ResumeDTO
import com.minzino.portfolio.domain.presentation.repository.PresentationRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

// 서비스 클래스 선언, Spring의 @Service 애노테이션을 사용합니다.
@Service
class PresentationService(
    private val presentationRepository: PresentationRepository
) {
    // 자기소개 리스트를 가져오는 메소드, 읽기 전용 트랜잭션으로 설정합니다.
    @Transactional(readOnly = true)
    fun getIntroductions(): List<IntroductionDTO> {
        val introductions = presentationRepository.getActiveIntroduction()
        return introductions.map { IntroductionDTO(it) }
    }

    // 링크 리스트를 가져오는 메소드, 읽기 전용 트랜잭션으로 설정합니다.
    @Transactional(readOnly = true)
    fun getLinks(): List<LinkDTO> {
        val links = presentationRepository.getActiveLink()
        return links.map { LinkDTO(it) }
    }

    // 이력서 정보를 가져오는 메소드, 읽기 전용 트랜잭션으로 설정합니다.
    @Transactional(readOnly = true)
    fun getResume(): ResumeDTO {
        val experiences = presentationRepository.getActiveExperience()
        val achievements = presentationRepository.getActiveAchievements()
        val skills = presentationRepository.getActiveSkill()

        return ResumeDTO(
            experiences = experiences,
            achievements = achievements,
            skills = skills
        )
    }

    // 프로젝트 리스트를 가져오는 메소드, 읽기 전용 트랜잭션으로 설정합니다.
    @Transactional(readOnly = true)
    fun getProjects(): List<ProjectDTO> {
        val projects = presentationRepository.getActiveProject()
        return projects.map { ProjectDTO(it) }
    }
}