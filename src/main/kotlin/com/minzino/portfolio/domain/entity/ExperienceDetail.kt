package com.minzino.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ExperienceDetail(
    content: String,
    isActive: Boolean
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_detail_id")
    val id: Long? = null;

    var content: String = content

    var isActive: Boolean = isActive

    fun update(content: String, isActive: Boolean) {

        this.content = content
        this.isActive = isActive
    }


}