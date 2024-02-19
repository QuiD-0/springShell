package com.quid.cli.memo.gateway.repository.jpa

import com.quid.cli.memo.domain.Memo
import jakarta.persistence.*
import jakarta.persistence.GenerationType.IDENTITY
import java.time.LocalDateTime

@Entity
@Table(name = "MEMO")
class MemoEntity(
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null,

    @Column(name = "DESCRIPTION")
    val description: String,

    @Column(name = "REG_DATE")
    val regDate: LocalDateTime
) {
    constructor(memo: Memo) : this(memo.id, memo.description, memo.regDate)

    fun toMemo() = Memo(id, description, regDate)
}