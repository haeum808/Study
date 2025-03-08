package org.haeum.hello_spring.repository

import org.haeum.hello_spring.domain.Member

interface MemberRepository {
    fun save(member: Member): Member

    fun findById(id: Long): Member?

    fun findByName(name: String): Member?

    fun findAll(): List<Member>
}
