package com.minzino.portfolio.admin.context.link.service

import com.minzino.portfolio.admin.context.link.form.LinkForm
import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.domain.entity.Link
import com.minzino.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AdminLinkService(
    private val linkRepository: LinkRepository
) {


    fun getLinkTable(): TableDTO {
        val classInfo = Link::class
        val entities = linkRepository.findAll()

        return TableDTO.from(classInfo,entities)
    }

    @Transactional
    fun save(form: LinkForm){
        val achievement = form.toEntity()
        linkRepository.save(achievement)
    }

    @Transactional
    fun update(id:Long,form: LinkForm){
        val achievement = form.toEntity(id)
        linkRepository.save(achievement)
    }

}