package com.minzino.portfolio.admin.context.introduction.service

import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Introduction
import com.minzino.portfolio.domain.repository.IntroductionRepository
import org.springframework.stereotype.Service

@Service
class AdminIntroductionService(
    private val introductionRepository: IntroductionRepository
) {

    fun getIntroductionTable():TableDTO{
        val classInfo = Introduction::class
        val entities = introductionRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }
}