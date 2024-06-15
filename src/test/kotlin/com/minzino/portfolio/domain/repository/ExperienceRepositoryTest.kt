package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.ExperienceDetail
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
//테스트의 라이브 사이클을 클래스 단위로 설정한다.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ExperienceRepositoryTest (
    @Autowired val experienceRepository: ExperienceRepository
){
    val DATA_SIZE= 10

    private fun createExperience(n:Int): Experience{
        val experience = Experience(
            title ="${n}",
            description = "테스트 설명 ${n}",
            startYear = 2024,
            startMonth = 6,
            endYear = 2024,
            endMonth = 7,
            isActive = true
        )

        val details = mutableListOf<ExperienceDetail>()
            //1 -> 10
            for (i in 1..n) {
             val experienceDetail =ExperienceDetail(content = "테스트 디테일 ${n}",isActive = true)
                details.add(experienceDetail)
            }

        experience.addDetails(details)

        return experience
    }
    //테스트 데이터 초기화
    @BeforeAll
    fun beforeAll(){
        println("========데이터 초기화 이전 조회 시작==========")

        val beforeInitialize= experienceRepository.findAll()
        assertThat(beforeInitialize).hasSize(0)


        println("========데이터 초기화 이전 조회 종료==========")

        println("========데이터 초기화 시작==========")
        val experiences = mutableListOf<Experience>()
        for (i in 1..DATA_SIZE){
            val experience = createExperience(i)
            experiences.add(experience)
        }
        experienceRepository.saveAll(experiences)

        println("========데이터 초기화 종료==========")
    }

    @Test
    fun testFindAll(){
        println("========findAll 테스트 시작==========")
        val experience = experienceRepository.findAll()

        assertThat(experience).hasSize(DATA_SIZE)

        println("========findAll 테스트 종료==========")
    }


    @Test
    fun testFindAllByActive(){

        val experience= experienceRepository.findAllByIsActive(true)

        assertThat(experience).hasSize(DATA_SIZE)
    }

}