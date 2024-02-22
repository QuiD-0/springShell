package com.quid.cli.memo.usecase

import com.quid.cli.memo.gateway.out.repository.MemoRepository
import org.springframework.stereotype.Service

interface DeleteMemo {
    fun byId(id: Long)

    @Service
    class DeleteMemoUseCase(
        private val memoRepository: MemoRepository
    ) : DeleteMemo {
        override fun byId(id: Long) = memoRepository.deleteById(id)
    }
}