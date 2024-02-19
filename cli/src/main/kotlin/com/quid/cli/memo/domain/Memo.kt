package com.quid.cli.memo.domain

import java.time.LocalDateTime

data class Memo(
    val id: Long? = null,
    val description: String,
    val regDate: LocalDateTime = LocalDateTime.now()
)
