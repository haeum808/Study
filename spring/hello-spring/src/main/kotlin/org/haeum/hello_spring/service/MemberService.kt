package org.haeum.hello_spring.service

import org.haeum.hello_spring.domain.Member
import org.haeum.hello_spring.repository.MemberRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
class MemberService(
    private val memberRepository: MemberRepository
) {
    fun join(member: Member): Long {
        val start = System.currentTimeMillis()

        try {
            validateDuplicateMember(member) // 중복 회원 검증
            memberRepository.save(member)
            return member.id
        } finally {
            val finish = System.currentTimeMillis()
            val timeMs =  finish - start
            println("join = " + timeMs + "ms")
        }
    }

    fun findMembers(): List<Member> {
        val start = System.currentTimeMillis()

        try {
            return memberRepository.findAll()
        } finally {
            val finish = System.currentTimeMillis()
            val timeMs =  finish - start
            println("findMembers = " + timeMs + "ms")
        }
    }

    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }

    private fun validateDuplicateMember(member: Member) {
        if (memberRepository.findByName(member.name) != null) throw IllegalStateException("이미 존재하는 회원입니다.")
    }
}
