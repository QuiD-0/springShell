package com.quid.cli.memo.gateway.`in`

import com.quid.cli.memo.gateway.`in`.response.MemoListResponse
import com.quid.cli.memo.usecase.DeleteMemo
import com.quid.cli.memo.usecase.FindMemo
import com.quid.cli.memo.usecase.WriteMemo
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class MemoCLI(
    private val writeMemo: WriteMemo,
    private val deleteMemo: DeleteMemo,
    private val findMemo: FindMemo
) {
    @ShellMethod("Write a memo", group = "memo", key = ["memo -w", "memo write"])
    fun memo(description: String) = writeMemo(description)

    @ShellMethod("memo list", group = "memo", key = ["memo -l", "memo list", "memo ls"])
    fun memoList() = findMemo.list().let { MemoListResponse(it).message() }

    @ShellMethod("read memo", group = "memo", key = ["memo -r", "memo read"])
    fun memoRead(id: String) = findMemo.byId(id.toLong())?:"Memo Not Found"

    @ShellMethod("delete memo", group = "memo", key = ["memo -d", "memo delete"])
    fun memoDelete(id: String) = deleteMemo.byId(id.toLong()).let { "Memo Deleted" }
}