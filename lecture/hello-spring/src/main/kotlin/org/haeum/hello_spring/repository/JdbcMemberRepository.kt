package org.haeum.hello_spring.repository

import org.haeum.hello_spring.domain.Member
import org.springframework.jdbc.datasource.DataSourceUtils
import java.sql.*
import javax.sql.DataSource

class JdbcMemberRepository(private val dataSource: DataSource) : MemberRepository {
    override fun save(member: Member): Member {
        val sql = "INSERT INTO member(name) VALUES(?)"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
            pstmt.setString(1, member.name)
            pstmt.executeUpdate()
            rs = pstmt.generatedKeys
            if (rs.next()) {
                member.id = rs.getLong(1)
            } else {
                throw SQLException("id 조회 실패")
            }
            return member
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findById(id: Long): Member? {
        val sql = "SELECT * FROM member WHERE id = ?"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            pstmt.setLong(1, id)
            rs = pstmt.executeQuery()
            return if (rs.next()) {
                Member(rs.getLong("id"), rs.getString("name"))
            } else {
                null
            }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findAll(): List<Member> {
        val sql = "SELECT * FROM member"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            rs = pstmt.executeQuery()
            val members = mutableListOf<Member>()
            while (rs.next()) {
                members.add(Member(rs.getLong("id"), rs.getString("name")))
            }
            return members
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    override fun findByName(name: String): Member? {
        val sql = "SELECT * FROM member WHERE name = ?"
        var conn: Connection? = null
        var pstmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            conn = getConnection()
            pstmt = conn.prepareStatement(sql)
            pstmt.setString(1, name)
            rs = pstmt.executeQuery()
            return if (rs.next()) {
                Member(rs.getLong("id"), rs.getString("name"))
            } else {
                null
            }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        } finally {
            close(conn, pstmt, rs)
        }
    }

    private fun getConnection(): Connection {
        return DataSourceUtils.getConnection(dataSource)
    }

    private fun close(conn: Connection?, pstmt: PreparedStatement?, rs: ResultSet?) {
        rs?.close()
        pstmt?.close()
        conn?.let { close(it) }
    }

    private fun close(conn: Connection) {
        DataSourceUtils.releaseConnection(conn, dataSource)
    }
}