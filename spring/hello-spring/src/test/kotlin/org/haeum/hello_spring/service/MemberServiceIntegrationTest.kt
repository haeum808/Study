package org.haeum.hello_spring.service

import org.assertj.core.api.Assertions.assertThat
import org.haeum.hello_spring.domain.Member
import org.haeum.hello_spring.repository.MemberRepository
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired
    private lateinit var memberRepository: MemberRepository
    @Autowired
    private lateinit var memberService: MemberService

    @Test
    fun 회원가입() {
        // given
        val member = Member()
        member.name = "spring"

        // when
        val saveId = memberService.join(member)

        // then
        val findMember = memberService.findOne(saveId)!!
        assertThat(member.name).isEqualTo(findMember.name)
    }

    @Test
    fun 중복_회원_예외() {
        // given
        val member1 = Member()
        member1.name = "spring"

        val member2 = Member()
        member2.name = "spring"

        // when
        memberService.join(member1)
        val e = assertThrows<IllegalStateException> { memberService.join(member2) }

        // then
        assertThat(e.message).isEqualTo("이미 존재하는 회원입니다.")
    }

    @Test
    fun findMembers() {
    }

    @Test
    fun findOne() {
    }
}