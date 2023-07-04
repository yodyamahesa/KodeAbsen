package com.example.kodeabsen

object Random {
    fun randomkan(): String {
        val letters = ('a'..'z') + ('A'..'Z')
        val randomString = (1..6)
            .map { letters.random() }
            .joinToString("")
        return randomString
    }
}