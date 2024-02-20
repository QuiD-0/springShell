package com.quid.cli.memo.gateway.out.repository

import com.quid.cli.memo.domain.Memo
import com.quid.cli.memo.gateway.out.repository.jpa.MemoEntity
import com.quid.cli.memo.gateway.out.repository.jpa.MemoJpaRepository
import org.springframework.stereotype.Repository

interface MemoRepository {
    fun save(memo: Memo): Memo
    fun findAll(): List<Memo>

    @Repository
    class MemoRepositoryImpl(
        private val memoJpaRepository: MemoJpaRepository
    ) : MemoRepository {
        override fun save(memo: Memo) =
            MemoEntity(memo)
                .let { memoJpaRepository.save(it) }
                .toMemo()

        override fun findAll(): List<Memo> =
            memoJpaRepository.findAll()
                .map { it.toMemo() }
    }
}