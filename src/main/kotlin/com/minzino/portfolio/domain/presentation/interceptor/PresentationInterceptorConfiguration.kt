package com.minzino.portfolio.domain.presentation.interceptor

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class PresentationInterceptorConfiguration(
    private val presentationInterceptor: PresentationInterceptor
) : WebMvcConfigurer {
    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(presentationInterceptor)
            //모든 경로에 대한 인터셉터 지정
            .addPathPatterns("/**")
            .excludePathPatterns("/assets/**", "/css/**", "/js/**", "/admin/**","h2**",
                "/favicon.ico","/error")
    }
}