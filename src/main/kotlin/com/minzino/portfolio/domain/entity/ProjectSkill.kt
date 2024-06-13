package com.minzino.portfolio.domain.entity

import jakarta.persistence.*

@Entity
class ProjectSkill(project: Project,skill: Skill) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_skill_id")
    val id: Long? = null;

    @ManyToOne(targetEntity = Project::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "projcet_id", nullable = false)
    var project:Project= project
    @ManyToOne(targetEntity = Skill::class, fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id", nullable = false)
    var skill:Skill = skill


}