package com.minzino.portfolio.domain.presentation.dto

import com.minzino.portfolio.domain.entity.Introduction

data class IntroductionDTO(
    val content: String,
) {
    constructor(introduction: Introduction) : this(
        content = introduction.content
    )
}