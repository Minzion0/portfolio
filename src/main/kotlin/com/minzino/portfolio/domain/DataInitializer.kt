package com.minzino.portfolio.domain

import com.minzino.portfolio.domain.constant.SkillType
import com.minzino.portfolio.domain.entity.*
import com.minzino.portfolio.domain.repository.*
import jakarta.annotation.PostConstruct
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component
import java.time.LocalDate
import kotlin.concurrent.timer

@Component
@Profile(value = ["default"])
class DataInitializer(
    private val achievementRepository: AchievementRepository,
    private val introductionRepository: IntroductionRepository,
    private val linkRepository: LinkRepository,
    private val skillRepository: SkillRepository,
    private val projectRepository: ProjectRepository,
    private val experienceRepository: ExperienceRepository,
    private val accountRepository: AccountRepository
) {
    //데이터 초기화를 위해 PostConstruct 사용
    @PostConstruct
    fun initializeData() {

        val achievements = mutableListOf<Achievement>(
            Achievement(
                title = "2024 Catkao 해커톤 최우수상",
                description = "이것저것 사오ㅛㅇ해서 잘함",
                host = "빵통대",
                achievedDate = LocalDate.of(2024, 6, 10),
                isActive = true
            ),
            Achievement(
                title = "SQLD",
                description = "SQL 개발자",
                host = "한국 산업 인력공단",
                achievedDate = LocalDate.of(2024, 4, 10),
                isActive = true
            )
        )
        achievementRepository.saveAll(achievements)

        val introductions = mutableListOf<Introduction>(
            Introduction(content = "문제를 해결하는 개발자 입니다.", isActive = true),
            Introduction(content = "저는 코드를 통해 사용자에게 더 나은 경험을 제공하고 싶습니다.", isActive = true),
            Introduction(content = "코드로 사람들의 삶에 어려움 해결하고, 더 나은 경험을 할 수 있도록 도와 줄 것입니다.", isActive = true),
            Introduction(content = "이러한 목표로 저는 웹 개발자로서의 새로운 도전을 나서고자 합니다.", isActive = true),

            )
        introductionRepository.saveAll(introductions)

        val links = mutableListOf<Link>(
            Link(name = "Github", content = "https://github.com/Minzion0", isActive = true)
        )

        linkRepository.saveAll(links)

        val experience1 = Experience(
            title = "그린컴퓨터 학원",
            description = "기업 요구를 반영한 프로젝트 중심 JAVA 백엔드 테스트 주도 개발자 양성 과정",
            startYear = 2023,
            startMonth = 4,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )
        experience1.addDetails(
            mutableListOf(
                ExperienceDetail(content = "소비 데이터기반 식비 가계부 서비스 'Mekki'", isActive = true),
                ExperienceDetail(content = "학사관리 서비스 'Smart Graed'", isActive = true)
            )
        )
        val experience2 = Experience(
            title = "제로베이스 백엔드 스쿨",
            description = "제로베이스 백엔드 스쿨 22기",
            startYear = 2024,
            startMonth = 2,
            endYear = 2024,
            endMonth = 9,
            isActive = true
        )
        experience2.addDetails(
            mutableListOf(
                ExperienceDetail(content = "도서 대출 관리 서비스 '북마루'", isActive = true),

                )
        )

        experienceRepository.saveAll(mutableListOf(experience1, experience2))


        val java = Skill(name = "Java", type = SkillType.LANGUAGE.name, isActive = true)
        val kotlin = Skill(name = "Kotlin", type = SkillType.LANGUAGE.name, isActive = true)
        val spring = Skill(name = "Spring", type = SkillType.FRAMEWORK.name, isActive = true)
        val mysql = Skill(name = "MySQL", type = SkillType.DATABASE.name, isActive = true)
        val mariadb = Skill(name = "MariaDB", type = SkillType.DATABASE.name, isActive = true)
        val myBatis = Skill(name = "MyBatis", type = SkillType.FRAMEWORK.name, isActive = true)
        val jpa = Skill(name = "JPA", type = SkillType.FRAMEWORK.name, isActive = true)
        val redis = Skill(name = "Redis", type = SkillType.DATABASE.name, isActive = true)

        skillRepository.saveAll(mutableListOf(java, kotlin, spring, mysql, mariadb, jpa,redis, myBatis))

        val project1 = Project(
            name = "소비 데이터기반 식비 가계부 서비스 'Mekki'",
            description = "미니게임 도입을 통해 가계부 앱의 사용자 지속 참여율을 높이는 가계부 서비스 개발.",
            startYear = 2023,
            startMonth = 6,
            endYear = 2023,
            endMonth = 7,
            isActive = true
        )

        project1.addDetails(
            mutableListOf(
                ProjectDetail(
                    content = "SQL쿼리 수정을 통한 n+1 문제 해결하여 API 호출 속도 61ms -> 5ms 개선",
                    url = null,
                    isActive = true
                ),
                ProjectDetail(
                    content = "Github Repository",
                    url = "https://github.com/Minzion0/food_roulette",
                    isActive = true
                )
            )
        )
        project1.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project1, skill = java),
                ProjectSkill(project = project1, skill = spring),
                ProjectSkill(project = project1, skill = mariadb),
                ProjectSkill(project = project1, skill = myBatis)
            )
        )

        val project2 = Project(
            name = "대학학사관리 서비스 프로그램 ’SMART GRADE’",
            description = "사용자(교수, 학생, 관리자)의 편의성 제공 및 보안성 높은 학사 관리 서비스 개발.",
            startYear = 2023,
            startMonth = 7,
            endYear = 2023,
            endMonth = 9,
            isActive = true
        )
        project2.addDetails(
            mutableListOf(
                ProjectDetail(content = "Google authenticator를 활용한 2차 인증 보안 기능구현", url = null, isActive = true),
                ProjectDetail(content = "apachePOI를 활용한 데이터 베이스 정보 문서화", url = null, isActive = true),
                ProjectDetail(
                    content = "Github Repository",
                    url = "https://github.com/Minzion0/smartGradeVer.2",
                    isActive = true
                )
            )
        )
        project2.skills.addAll(
            mutableListOf(
                ProjectSkill(project = project2, skill = java),
                ProjectSkill(project = project2, skill = spring),
                ProjectSkill(project = project2, skill = jpa),
                ProjectSkill(project = project2, skill = mariadb)
            )
        )

        projectRepository.saveAll(mutableListOf(project1, project2))

        val account= Account(
            loginId = "admin1",
            pw = "\$2a\$10\$Zo3/4S69QEDCfayH/Yp.H.gVqzbe.ePnRsFkIfsyvGy3yW0S5Xmyq"
        )
        accountRepository.save(account)
    }



}