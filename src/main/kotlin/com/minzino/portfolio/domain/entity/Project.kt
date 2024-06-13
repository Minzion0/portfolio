package com.minzino.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class Project : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    val id: Long? = null;

    


}