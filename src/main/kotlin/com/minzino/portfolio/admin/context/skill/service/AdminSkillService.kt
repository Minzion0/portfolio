package com.minzino.portfolio.admin.context.skill.service

import com.minzino.portfolio.admin.context.link.form.LinkForm
import com.minzino.portfolio.admin.context.skill.form.SkillForm
import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Skill
import com.minzino.portfolio.domain.repository.SkillRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminSkillService(
    private val skillRepository: SkillRepository
) {

    fun getSkillTable(): TableDTO {
        val classInfo = Skill::class
        val entities = skillRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }

    @Transactional
    fun save(form: SkillForm){
        val achievement = form.toEntity()
        skillRepository.save(achievement)
    }

    @Transactional
    fun update(id:Long,form: SkillForm){
        val achievement = form.toEntity(id)
        skillRepository.save(achievement)
    }

}