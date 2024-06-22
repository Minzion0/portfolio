package com.minzino.portfolio.admin.security

import com.minzino.portfolio.admin.exception.AdminBadRequestException
import com.minzino.portfolio.domain.repository.AccountRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AdminSecurityService(
    private val passwordEncoder: PasswordEncoder,
    private val accountRepository: AccountRepository
):UserDetailsService {
    override fun loadUserByUsername(loginId: String): UserDetails {
        return accountRepository.findByLoginId(loginId)
            .orElseThrow{throw AdminBadRequestException("사용자를 찾을수 없습니다.")}
    }


}