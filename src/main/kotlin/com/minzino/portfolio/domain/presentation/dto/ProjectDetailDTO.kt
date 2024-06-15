package com.minzino.portfolio.domain.presentation.dto

import com.minzino.portfolio.domain.entity.ProjectDetail

data class ProjectDetailDTO(
    val content: String,
    val url: String?
) {
    constructor(projectDetail: ProjectDetail): this(
        content=projectDetail.content,
        url=projectDetail.url
    )
}