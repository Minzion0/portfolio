package com.minzino.portfolio.admin.context.dashboard.service

import com.minzino.portfolio.admin.data.TableDTO
import com.minzino.portfolio.domain.entity.HttpInterface
import com.minzino.portfolio.domain.repository.HttpInterfaceRepository
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.time.LocalTime

@Service
class AdminDashboardService (
    private val httpInterfaceRepository: HttpInterfaceRepository
){
    fun getHttpInterfaceTable():TableDTO{
        val pageRequest = PageRequest.of(0,100,Sort.Direction.DESC,"id")

        val classInfo = HttpInterface::class

        val entities = httpInterfaceRepository.findAll(pageRequest).content

        return TableDTO.from(classInfo,entities)
    }

    fun countVisitorsTotal(): Long{
        return httpInterfaceRepository.count()
    }
    fun countVisitorsWeekly():Long {
        val today= LocalDate.now()
        val startDay = today.minusDays(6)

        return httpInterfaceRepository.countAllByCreateDateTimeBetween(
            startDay.atStartOfDay(),
            today.atTime(LocalTime.MAX)
        )

    }

    fun countVisitorsToday():Long {
        val today= LocalDate.now()

        return httpInterfaceRepository.countAllByCreateDateTimeBetween(
            today.atStartOfDay(),
            today.atTime(LocalTime.MAX)
        )

    }

}