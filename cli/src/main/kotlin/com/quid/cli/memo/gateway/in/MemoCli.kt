package com.quid.cli.memo.gateway.`in`

import com.quid.cli.memo.gateway.`in`.response.MemoListResponse
import com.quid.cli.memo.usecase.FindMemo
import com.quid.cli.memo.usecase.WriteMemo
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class MemoCli(
    private val writeMemo: WriteMemo,
    private val findMemo: FindMemo
) {
    @ShellMethod("Write a memo", group = "memo", key = ["memo -w", "memo write"])
    fun memo(description: String) = writeMemo(description)

    @ShellMethod("memo list", group = "memo", key = ["memo -l", "memo list", "memo ls"])
    fun memoList() = findMemo.list().let { MemoListResponse(it).message() }
}