package org.haeum.hello_spring

import org.haeum.hello_spring.repository.MemberRepository
import org.haeum.hello_spring.repository.MemoryMemberRepository
import org.haeum.hello_spring.service.MemberService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig {

    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository());
    }

    @Bean
    fun memberRepository(): MemberRepository {
        return MemoryMemberRepository();
    }
}
