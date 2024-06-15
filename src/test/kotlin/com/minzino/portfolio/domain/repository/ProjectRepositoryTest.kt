package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.constant.SkillType
import com.minzino.portfolio.domain.entity.*
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProjectRepositoryTest (
    @Autowired val projectRepository: ProjectRepository,
    @Autowired val skillRepository: SkillRepository
){

    val DATA_SIZE=10

    private fun createProject(n: Int): Project{
        val project = Project(
            name ="${n}",
            description = "테스트 설명 ${n}",
            startYear = 2024,
            startMonth = 6,
            endYear = 2024,
            endMonth = 7,
            isActive = true
        )

        val details= mutableListOf<ProjectDetail>()
        for (i in 1..n){
            val projectDetail = ProjectDetail(
                content = "${n}",
                url = null,
                isActive = true
            )
            details.add(projectDetail)
        }
        project.addDetails(details)

        val skills = skillRepository.findAll()
        val skillsUserIdProject = skills.subList(0, n)

        for (skill in skillsUserIdProject){
            val projectSkill = ProjectSkill(project = project, skill = skill)
            project.skills.add(projectSkill)
        }



        return projectRepository.save(project)
    }

    @BeforeAll
    fun beforeAll(){
        val skills = mutableListOf<Skill>()
        for (i in 1..DATA_SIZE){
            val skillTypes = SkillType.values()
            val skill = Skill(name = "테스트 ${i}", skillTypes[i % skillTypes.size].name, isActive = true)
            skills.add(skill)

        }
        skillRepository.saveAll(skills)

        val projects = mutableListOf<Project>()
        for (i in 1..DATA_SIZE){
            val project = createProject(i)
            projects.add(project)
        }
        projectRepository.saveAll(projects)
    }

    @Test
    fun testFindAll(){
        println("========findAll 테스트 시작==========")
        val project = projectRepository.findAll()

        Assertions.assertThat(project).hasSize(DATA_SIZE)

        println("========findAll 테스트 종료==========")
    }


    @Test
    fun testFindAllByActive(){

        val project= projectRepository.findAllByIsActive(true)

        Assertions.assertThat(project).hasSize(DATA_SIZE)
    }

}