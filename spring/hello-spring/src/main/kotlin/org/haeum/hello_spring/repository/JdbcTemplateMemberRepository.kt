package org.haeum.hello_spring.repository

import org.haeum.hello_spring.domain.Member
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource
import org.springframework.jdbc.core.simple.SimpleJdbcInsert
import javax.sql.DataSource

class JdbcTemplateMemberRepository(@Autowired private val dataSource: DataSource) : MemberRepository {
    private val jdbcTemplate: JdbcTemplate = JdbcTemplate(dataSource)

    override fun save(member: Member): Member {
        val jdbcInsert = SimpleJdbcInsert(jdbcTemplate)
        jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id")

        val parameters = HashMap<String, Any>()
        parameters["name"] = member.name

        val key = jdbcInsert.executeAndReturnKey(MapSqlParameterSource(parameters))
        member.id = key.toLong()
        return member
    }

    override fun findById(id: Long): Member? {
        val result = jdbcTemplate.query("SELECT * FROM member WHERE id = ?", memberRowMapper(), id)
        return result.first()
    }

    override fun findAll(): List<Member> {
        return jdbcTemplate.query("SELECT * FROM member", memberRowMapper())
    }

    override fun findByName(name: String): Member? {
        val result = jdbcTemplate.query("SELECT * FROM member WHERE name = ?", memberRowMapper(), name)
        return result.find { member -> member.name == name }
    }

    private fun memberRowMapper(): RowMapper<Member> {
        return RowMapper<Member> { rs, _ ->
            val member = Member()
            member.id = rs.getLong("id")
            member.name = rs.getString("name")
            member
        }
    }
}
