package com.minzino.portfolio.admin.context.introduction.service

import com.minzino.portfolio.admin.context.achievement.form.AchievementForm
import com.minzino.portfolio.admin.context.introduction.form.IntroductionForm
import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Introduction
import com.minzino.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {

    fun getIntroductionTable():TableDTO{
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }
    @Transactional
    fun save(form: IntroductionForm){
        val achievement = form.toEntity()
        introductionRepository.save(achievement)
    }

    @Transactional
    fun update(id:Long,form: IntroductionForm){
        val achievement = form.toEntity(id)
        introductionRepository.save(achievement)
    }

}