package com.quid.cli.memo.gateway.`in`

import com.quid.cli.memo.usecase.WriteMemo
import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class MemoCli(
    private val writeMemo: WriteMemo
) {
    @ShellMethod("Write a memo")
    fun memo(@ShellOption("-d") description: String) = writeMemo(description)

}