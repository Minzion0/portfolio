package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AchievementRepository: JpaRepository<Achievement,Long> {
}