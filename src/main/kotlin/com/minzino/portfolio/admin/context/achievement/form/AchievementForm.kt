package com.minzino.portfolio.admin.context.achievement.form

import com.minzino.portfolio.domain.entity.Achievement
import jakarta.validation.constraints.NotBlank
import java.time.LocalDate

data class AchievementForm(
    @field:NotBlank(message = "필수값 입니다.")
    val tile: String,

    val description: String,
    val host: String,
    val achievedDate: String,
    val isActive: Boolean,
) {

    fun toEntity():Achievement{
        return Achievement(
            title = this.tile,
            description=this.description,
            host = this.host,
            achievedDate = LocalDate.parse(this.achievedDate),
            isActive = this.isActive
        )
    }

    fun toEntity(id:Long):Achievement{
        val achievement = this.toEntity()
        achievement.id=id

        return achievement
    }
}