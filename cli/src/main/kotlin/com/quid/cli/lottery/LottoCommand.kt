package com.quid.cli.lottery

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class LottoCommand {

    @ShellMethod("Generate a set of lucky numbers")
    fun lotto(@ShellOption("-n", defaultValue = "6") quantity: Int): String {
        val lotto = Lotto.generateNumbers(quantity)
        return lotto.message
    }
}