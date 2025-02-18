package org.haeum.hello_spring.service

import org.haeum.hello_spring.domain.Member
import org.haeum.hello_spring.repository.MemberRepository
import org.haeum.hello_spring.repository.MemoryMemberRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service

@Service
@Component
class MemberService(
    @Autowired private val memberRepository: MemoryMemberRepository
) {

    fun join(member: Member): Long {
        validateDuplicateMember(member) // 중복 회원 검증
        memberRepository.save(member)
        return member.id
    }

    private fun validateDuplicateMember(member: Member) {
        if (memberRepository.findByName(member.name) != null) throw IllegalStateException("이미 존재하는 회원입니다.")
    }

    fun findMembers(): List<Member> {
        return memberRepository.findAll()
    }

    fun findOne(memberId: Long): Member? {
        return memberRepository.findById(memberId)
    }
}
