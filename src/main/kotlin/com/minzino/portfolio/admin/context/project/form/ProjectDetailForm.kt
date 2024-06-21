package com.minzino.portfolio.admin.context.project.form

import com.minzino.portfolio.domain.entity.ExperienceDetail
import com.minzino.portfolio.domain.entity.ProjectDetail
import jakarta.validation.constraints.NotBlank

data class ProjectDetailForm(
    var id:Long,
    @field:NotBlank(message = "필수값 입니다.")
    var content: String,
    var url: String?,
    var isActive: Boolean
) {

    fun toEntity(): ProjectDetail {
        return ProjectDetail(
            content = this.content,
            url=this.url,
            isActive=this.isActive
        )
    }
}