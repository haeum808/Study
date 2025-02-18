package org.haeum.hello_spring.controller

import org.haeum.hello_spring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller

@Controller
class MemberController(
    @Autowired private val memberService: MemberService,
)
