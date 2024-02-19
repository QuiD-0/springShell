package com.quid.cli.lottery

data class Lotto(
    val numbers: List<Int>
) {
    val message: String
        get() = "Your lucky numbers are: ${numbers.joinToString()}"


    init {
        require(numbers.all { it in 1..45 }) {
            "All Lotto numbers must be between 1 and 49"
        }
        require(numbers.toSet().size == numbers.size) {
            "All Lotto numbers must be unique"
        }
    }

    companion object {
        fun generateNumbers(quantity: Int): Lotto =
            Lotto((1..45).shuffled().take(quantity).sorted())
    }
}