package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface ExperienceRepository: JpaRepository<Experience,Long> {
    @Query("select e from Experience e left join fetch e.details where e.isActive= :isActive")
    fun findAllByIsActive(isActive:Boolean): List<Experience>
    @Query("select e from Experience e left join fetch e.details where e.id= :id")
    override fun findById(@Param("id") id: Long): Optional<Experience>
}