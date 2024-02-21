package com.quid.cli.memo.usecase

import com.quid.cli.memo.domain.Memo
import com.quid.cli.memo.gateway.out.repository.MemoRepository
import org.springframework.stereotype.Service

interface FindMemo {
    fun list(): List<Memo>
    fun byId(id: Long): Memo?

    @Service
    class FindMemoUseCase(
        private val memoRepository: MemoRepository
    ) : FindMemo {
        override fun list(): List<Memo> = memoRepository.findAll()
        override fun byId(id: Long): Memo? = memoRepository.byId(id)
    }

}