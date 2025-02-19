package org.haeum.hello_spring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class HomeController {

    @GetMapping("/")
    fun home(): String {
        return "home"
    }
}