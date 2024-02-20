package com.quid.cli.memo.domain

import java.time.LocalDateTime

data class Memo(
    val id: Long? = null,
    val author: String,
    val description: String,
    val regDate: LocalDateTime = LocalDateTime.now()
) {
    constructor(author: String, description: String) : this(null, author, description)

    override fun toString() = """
        |Memo
        |
        |   $description,
        |   
        |   $regDate
        |
    """.trimMargin()
}