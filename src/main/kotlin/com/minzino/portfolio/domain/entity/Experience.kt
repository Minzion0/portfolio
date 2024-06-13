package com.minzino.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Experience : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experience_id")
    val id: Long? = null;

    


}