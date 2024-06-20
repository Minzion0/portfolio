package com.minzino.portfolio.domain.presentation.service

import com.minzino.portfolio.domain.entity.Introduction
import com.minzino.portfolio.domain.entity.Link
import com.minzino.portfolio.domain.presentation.repository.PresentationRepository
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class PresentationServiceTest {

    @InjectMocks
    //초기회 지연
    lateinit var presentationService: PresentationService

    @Mock
    lateinit var presentationRepository: PresentationRepository

    val DATA_SIZE = 9


    @Test
    fun testGetIntroductions() {
        //given
        val introductions = mutableListOf<Introduction>()
        for (i in 1..DATA_SIZE) {
            val introduction = Introduction(content = "${i}", isActive = i % 2 == 0)
            introductions.add(introduction)
        }

        val activeIntroductions =
            introductions.filter { introduction -> introduction.isActive }

        Mockito.`when`(presentationRepository.getActiveIntroduction())
                .thenReturn(activeIntroductions)
        //when
        val introductionsDTOs = presentationService.getIntroductions()
        //then
        assertThat(introductionsDTOs).hasSize(DATA_SIZE/2)
        for (introductionsDTO in introductionsDTOs) {
            assertThat(introductionsDTO.content.toInt()).isEven()
        }
    }

    @Test
    fun testGetLinks(){
    //given
        val links = mutableListOf<Link>()
        for (i in 1..DATA_SIZE){
            val link = Link(name = "${i}", content = "${i}", isActive = i % 2 != 0)
            links.add(link)
        }

        val activeLink = links.filter { link -> link.isActive }

        Mockito.`when`(presentationRepository.getActiveLink())
            .thenReturn(activeLink)
        //when

        val linkDTOS = presentationService.getLinks()

        //then
        var expectedSize = DATA_SIZE / 2
        if (DATA_SIZE % 2 != 0){
            expectedSize += 1
        }
        assertThat(linkDTOS).hasSize(expectedSize)
        for (linkDTO in linkDTOS) {
            assertThat(linkDTO.content.toInt()).isOdd()
        }
    }
}

