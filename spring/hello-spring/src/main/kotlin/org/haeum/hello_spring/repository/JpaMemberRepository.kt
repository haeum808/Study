package org.haeum.hello_spring.repository

import jakarta.persistence.EntityManager
import org.haeum.hello_spring.domain.Member

class JpaMemberRepository(private val em: EntityManager) : MemberRepository {

    override fun save(member: Member): Member {
        em.persist(member)
        return member
    }

    override fun findById(id: Long): Member? {
        val member = em.find(Member::class.java, id)
        return member
    }

    override fun findByName(name: String): Member? {
        val result = em.createQuery("select m from Member m where m.name = :name", Member::class.java)
            .setParameter("name", name).resultList
        return result.firstOrNull()
    }

    override fun findAll(): List<Member> {
        return em.createQuery("select m from Member m", Member::class.java).resultList
    }
}