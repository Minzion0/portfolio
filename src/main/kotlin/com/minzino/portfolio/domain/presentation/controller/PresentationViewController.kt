package com.minzino.portfolio.domain.presentation.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
class PresentationViewController {

    @GetMapping("/test")
    fun test():String{
        return "test"
    }


}