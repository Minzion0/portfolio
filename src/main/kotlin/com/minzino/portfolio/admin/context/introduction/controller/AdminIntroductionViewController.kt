package com.minzino.portfolio.admin.context.introduction.controller

import com.minzino.portfolio.admin.context.introduction.service.AdminIntroductionService
import com.minzino.portfolio.admin.data.FormElementDTO
import com.minzino.portfolio.admin.data.SelectFormElementDTO
import com.minzino.portfolio.admin.data.TextFormElementDTO
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/admin/introduction")
class AdminIntroductionViewController(
    private val adminIntroductionService: AdminIntroductionService
) {

    @GetMapping
    fun introduction(model: Model):String {
        val formElements= listOf<FormElementDTO>(
            TextFormElementDTO("content",10),
            SelectFormElementDTO("isActive",2, listOf(true.toString(),false.toString()))
        )
        model.addAttribute("formElements",formElements)

        val table = adminIntroductionService.getIntroductionTable()

        model.addAttribute("table",table)
        model.addAttribute("detailTable",null)

        val pageAttribute = mutableMapOf<String,Any>(
            Pair("menuName","Index"),
            Pair("pageName",table.name),
            Pair("pageName",true),
            Pair("deletable", false),
            Pair("hasDetails",false)
        )
        model.addAllAttributes(pageAttribute)
        return "admlin/page-table"
    }
}