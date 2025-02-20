package org.haeum.hello_spring

import org.haeum.hello_spring.repository.JdbcMemberRepository
import org.haeum.hello_spring.repository.MemberRepository
import org.haeum.hello_spring.service.MemberService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class SpringConfig(
    @Autowired private val dataSource: DataSource,
) {
    @Bean
    fun memberService(): MemberService {
        return MemberService(memberRepository());
    }

    @Bean
    fun memberRepository(): MemberRepository {
//        return MemoryMemberRepository();
        return JdbcMemberRepository(dataSource)
    }
}
