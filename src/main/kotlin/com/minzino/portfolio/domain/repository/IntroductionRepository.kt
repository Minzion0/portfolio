package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.HttpInterface
import com.minzino.portfolio.domain.entity.Introduction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface IntroductionRepository: JpaRepository<Introduction,Long> {
    fun findAllByIsActive(isActive:Boolean): List<Introduction>
}