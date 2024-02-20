package com.quid.cli.memo.domain

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class Memo(
    val id: Long? = null,
    val author: String,
    val description: String,
    val regDate: LocalDateTime = LocalDateTime.now()
) {
    constructor(author: String, description: String) : this(null, author, description)

    override fun toString() = """
        |   Memo #$id
        |
        |   $description
        |   
        |   by $author,
        |   ${regDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))}
        |
    """.trimMargin()
}