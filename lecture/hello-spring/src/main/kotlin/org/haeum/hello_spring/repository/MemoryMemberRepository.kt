package org.haeum.hello_spring.repository

import org.haeum.hello_spring.domain.Member

class MemoryMemberRepository: MemberRepository {
    override fun save(member: Member): Member {
        member.id = ++sequence
        store[member.id] = member
        return member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String): Member? {
        return store.values.find { member -> member.name == name }
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }

    fun clearStore() {
        store.clear()
    }

    companion object {
        private val store = HashMap<Long, Member>()
        private var sequence: Long = 0L;
    }
}
