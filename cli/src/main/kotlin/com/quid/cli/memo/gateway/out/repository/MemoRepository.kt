package com.quid.cli.memo.gateway.out.repository

import com.quid.cli.memo.domain.Memo
import com.quid.cli.memo.gateway.out.repository.jpa.MemoEntity
import com.quid.cli.memo.gateway.out.repository.jpa.MemoJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

interface MemoRepository {
    fun save(memo: Memo): Memo
    fun findAll(): List<Memo>
    fun byId(id: Long): Memo?
    fun deleteById(id: Long)

    @Repository
    class MemoRepositoryImpl(
        private val memoJpaRepository: MemoJpaRepository
    ) : MemoRepository {
        @Transactional
        override fun save(memo: Memo) =
            MemoEntity(memo)
                .let { memoJpaRepository.save(it) }
                .toMemo()

        @Transactional
        override fun deleteById(id: Long) {
            memoJpaRepository.deleteById(id)
        }

        @Transactional(readOnly = true)
        override fun findAll(): List<Memo> =
            memoJpaRepository.findAll()
                .map { it.toMemo() }

        @Transactional(readOnly = true)
        override fun byId(id: Long): Memo? =
            memoJpaRepository.findByIdOrNull(id)
                ?.toMemo()
    }
}