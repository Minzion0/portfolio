package com.minzino.portfolio.admin.context.project.form

import com.minzino.portfolio.domain.entity.Project
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Positive

data class ProjectForm(

    @field:NotBlank(message = "필수값 입니다.")
    val name:String,
    @field:NotBlank(message = "필수값 입니다.")
    val description:String,
    @field:Positive(message = "0보다 커야합니다")
    val startYear : Int,
    @field:Min(value = 1, message = "최소 값은 1입니다.")
    @field:Max(value = 12, message = "최대 값은 12입니다.")
    val startMonth : Int,
    var endYear: Int?,
    var endMonth: Int?,
    var isActive: Boolean,
    var details:List<ProjectDetailForm>?
) {
    fun toEntity():Project{
        return Project(
            name=this.name,
            description=this.description,
            startYear= this.startYear,
            startMonth= this.startMonth,
            endYear=this.endYear,
            endMonth=this.endMonth,
            isActive=this.isActive
        )
    }
}