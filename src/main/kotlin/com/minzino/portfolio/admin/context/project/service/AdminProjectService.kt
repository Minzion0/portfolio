package com.minzino.portfolio.admin.context.project.service

import com.minzino.portfolio.admin.context.project.form.ProjectForm
import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.admin.exception.AdminBadRequestException
import com.minzino.portfolio.domain.entity.Project
import com.minzino.portfolio.domain.repository.ProjectRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminProjectService(
    private val projectRepository: ProjectRepository
) {

    fun getProjectTable(): TableDTO {
        val classInfo = Project::class
        val entities = projectRepository.findAll()

        return TableDTO.from(classInfo, entities,"details","skills")
    }

    fun getProjectDetailTable(id: Long?): TableDTO {
        val classInfo = Project::class
        val entities = if (id != null) projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }
            .details else emptyList()

        return TableDTO.from(classInfo, entities)
    }

    @Transactional
    fun save(form: ProjectForm) {
        val projectDetails = form.details
            ?.map { detail -> detail.toEntity() }
            ?.toMutableList()

        val experience = form.toEntity()
        experience.addDetails(projectDetails)
        projectRepository.save(experience)
    }

    @Transactional
    fun update(id: Long, form: ProjectForm) {
        val project = projectRepository.findById(id)
            .orElseThrow { throw AdminBadRequestException("ID ${id}에 해당하는 데이터를 찾을 수가 없습니다.") }

        project.update(
            name = form.name,
            description = form.description,
            startYear = form.startYear,
            startMonth = form.startMonth,
            endYear = form.endYear,
            endMonth = form.endMonth,
            isActive = form.isActive
        )

        val detailMap = project.details.map { it.id to it }.toMap()
        form.details?.forEach {
            val entity = detailMap.get(it.id)
            if (entity != null) {
                entity.update(
                    content = it.content,
                    url = it.url,
                    isActive = it.isActive
                )
            } else {
                project.details.add(it.toEntity())
            }
        }
    }
}