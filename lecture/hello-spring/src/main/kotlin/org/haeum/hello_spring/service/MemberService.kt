package org.haeum.hello_spring.service

import org.haeum.hello_spring.domain.Member
import org.haeum.hello_spring.repository.MemberRepository
import org.springframework.transaction.annotation.Transactional

@Transactional
class MemberService(
    private val memberRepository: MemberRepository,
) {
    fun join(member: Member): Long {
        validateDuplicateMember(member) // 중복 회원 검증
        memberRepository.save(member)
        return member.id
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }

    private fun validateDuplicateMember(member: Member) {
        if (memberRepository.findByName(member.name) != null) throw IllegalStateException("이미 존재하는 회원입니다.")
    }
}
