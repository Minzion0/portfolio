package com.minzino.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Achievement : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    val id: Long? = null;




}