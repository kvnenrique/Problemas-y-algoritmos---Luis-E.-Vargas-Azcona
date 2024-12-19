package org.example
import java.util.Scanner

/**
 * Input data
 * n: Number of discs in the origin tower
 */
var n = 0
var c = 0

fun readInput() {
    val scanner = Scanner(System.`in`)
    n = scanner.nextInt()
    c = scanner.nextInt()
}

// Global variable accessed from strings()
var word = MutableList<Int>(0) {0}

fun strings(n: Int, c: Int) {
    if (n == 0) {
        println(
            word.joinToString (
                prefix = "",
                separator = "",
                postfix = ""
            ){
                ('a'.code + it).toChar().toString()
            }
        )
    } else {
        for (character in 0 ..< c) {
            word[word.size - n] = character
            strings(n - 1, c)
        }
    }
}


fun main() {
    // Read input data
    readInput()

    // Before applying the algorithm, give the auxiliary array the right size.
    word = MutableList<Int>(n){0}

    // Write solution
    strings(n, c)
}