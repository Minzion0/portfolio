package com.minzino.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Skill : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id")
    val id: Long? = null;

    


}