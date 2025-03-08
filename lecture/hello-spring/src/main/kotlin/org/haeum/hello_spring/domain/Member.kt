package org.haeum.hello_spring.domain

import jakarta.persistence.*

@Entity
data class Member(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    var name: String = "",
)
