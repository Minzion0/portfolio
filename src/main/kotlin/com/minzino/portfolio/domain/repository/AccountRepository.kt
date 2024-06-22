package com.minzino.portfolio.domain.repository

import com.minzino.portfolio.domain.entity.Account
import com.minzino.portfolio.domain.entity.Achievement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface AccountRepository: JpaRepository<Account,Long> {
    fun findByLoginId(loginId:String):Optional<Account>
}