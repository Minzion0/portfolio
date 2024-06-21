package com.minzino.portfolio.admin.context.skill.service

import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Skill
import com.minzino.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {

    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }
}