package com.quid.cli.memo.usecase

import com.quid.cli.memo.domain.Memo
import com.quid.cli.memo.gateway.out.repository.MemoRepository
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

interface WriteMemo {

    operator fun invoke(description: String): Memo

    @Service
    class WriteMemoUseCase(
        private val memoRepository: MemoRepository
    ) : WriteMemo {

        @Value("\${user}")
        private lateinit var user: String

        override fun invoke(description: String) = Memo(user, description).let { memoRepository.save(it) }
    }
}