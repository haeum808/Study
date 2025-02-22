package org.haeum.hello_spring

import jakarta.persistence.EntityManager
import org.haeum.hello_spring.repository.JpaMemberRepository
import org.haeum.hello_spring.repository.MemberRepository
import org.haeum.hello_spring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SpringConfig(
    @Autowired private val em: EntityManager,
) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository());
    }

    @Bean
    fun memberRepository(): MemberRepository {
//        return MemoryMemberRepository();
//        return JdbcMemberRepository(dataSource)
//        return JdbcTemplateMemberRepository(dataSource)
        return JpaMemberRepository(em);
    }
}
