package org.haeum.hello_spring.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {

    @GetMapping("hello")
    fun hello(model: Model): String {
        model.addAttribute("data", "spring!!");
        return "hello"
    }
}