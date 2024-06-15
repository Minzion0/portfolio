package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.constant.SkillType
import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.HttpInterface
import com.minzino.portfolio.domain.entity.Skill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface SkillRepository: JpaRepository<Skill,Long> {
    fun findAllByIsActive(isActive:Boolean): List<Skill>

    fun findByNameIgnoreCaseAndType(name:String,type:SkillType): Optional<Skill>
}