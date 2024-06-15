package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.HttpInterface
import com.minzino.portfolio.domain.entity.ProjectSkill
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ProjectSkillRepository: JpaRepository<ProjectSkill,Long> {

    fun findByProjectIdAndSkillId(projectId: Long,skillId:Long): Optional<ProjectSkill>
}