package com.minzino.portfolio.domain.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
class Achievement(
    // 생성자 파라미터로 전달된 값들을 프로퍼티로 변환합니다.
    title: String,
    description: String,
    achievedDate: LocalDate?,
    host: String,
    isActive: Boolean
) : BaseEntity() {
    // 기본 키 설정 및 자동 생성 전략을 지정합니다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    var id: Long? = null

    // 생성자 파라미터로 전달된 값을 초기화합니다.
    var title: String = title
    var description: String = description
    var achievedDate: LocalDate? = achievedDate
    var host: String = host
    var isActive: Boolean = isActive
}