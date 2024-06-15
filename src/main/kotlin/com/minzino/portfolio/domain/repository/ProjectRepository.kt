package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.HttpInterface
import com.minzino.portfolio.domain.entity.Project
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ProjectRepository: JpaRepository<Project,Long> {
    @Query("select p from Project p left join fetch p.skills s left join fetch s.skill where p.isActive= :isActive")
    fun findAllByIsActive(isActive:Boolean): List<Project>
    //성능 개선을 위한 오버라이딩
    @Query("select p from Project p left join fetch p.details where p.id=: id")
    override fun findById(id:Long): Optional<Project>
}