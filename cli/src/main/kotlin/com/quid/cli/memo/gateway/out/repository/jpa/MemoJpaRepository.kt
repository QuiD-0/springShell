package com.quid.cli.memo.gateway.out.repository.jpa

import org.springframework.data.jpa.repository.JpaRepository

interface MemoJpaRepository: JpaRepository<MemoEntity, Long> {
}