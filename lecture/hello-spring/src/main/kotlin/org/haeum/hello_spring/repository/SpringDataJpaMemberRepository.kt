package org.haeum.hello_spring.repository

import org.haeum.hello_spring.domain.Member
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaMemberRepository: JpaRepository<Member, Long>, MemberRepository {

    override fun findByName(name: String): Member?
}