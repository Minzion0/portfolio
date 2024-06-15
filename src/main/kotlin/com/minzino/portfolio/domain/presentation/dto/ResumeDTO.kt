package com.minzino.portfolio.domain.presentation.dto

import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.Skill
import java.time.format.DateTimeFormatter

class ResumeDTO(
    experiences: List<Experience>,
    achievements: List<Achievement>,
    skills: List<Skill>
) {
    val experiences:List<ExperienceDTO> = experiences.map {
        ExperienceDTO(
            title = it.title,
            description = it.description,
            startYearMonth = "${it.startYear}.${it.startMonth}",
            endYearMonth = it.getEndYearMonth(),
            details = it.details.filter { it.isActive }.map { it.content }
        )
    }

    val achievements: List<AchievementDTO> = achievements.map {
        AchievementDTO(
            title = it.title,
            description = it.description,
            host = it.host,
            achieveDate = it.achievedDate
                ?.format(DateTimeFormatter.ISO_LOCAL_DATE)
                ?.replace("-",".")
        )
    }

    val skills: List<SkillDTO> = skills.map { SkillDTO(it) }
}