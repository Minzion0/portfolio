package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Achievement
import com.minzino.portfolio.domain.entity.Experience
import com.minzino.portfolio.domain.entity.HttpInterface
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface HttpInterfaceRepository: JpaRepository<HttpInterface,Long> {
    /**
     * 방문자 카운팅 메소드 카운팅 시작 일시, 종료 일시 입력하면 카운딩
     */
    fun countAllByCreateDateTimeBetween(start:LocalDateTime,end:LocalDateTime)
}