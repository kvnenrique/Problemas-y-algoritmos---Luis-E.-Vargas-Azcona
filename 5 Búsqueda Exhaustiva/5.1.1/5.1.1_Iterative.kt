package org.example
import java.util.Scanner

/**
 * We can also solve the problem without recursion. In the following solution
 * we use an array of integers to keep track of the current word, we go to the
 * next word increasing to the next char in the right most column and carrying
 * the carry-over to the following left column.
 */
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
var word = MutableList<Int>(0){0}

fun strings(n: Int, c: Int) {
    while (word.sum() !=  (c-1) * n) {
        showWord()
        increment()
    }
    showWord()
}

fun increment() {
    word[word.size - 1]++
    for (i in word.size-1 downTo 1) {
        if (word[i] >= c) {
            word[i] = 0
            word[i-1]++
        }
    }
}

fun showWord() {
    println(
        word.joinToString(
            separator = ""
        ) {
            ('a'.code + it).toChar().toString()
        }
    )
}


fun main() {
    // Read input data
    readInput()

    // Before applying the algorithm, give the auxiliary array the right size.
    word = MutableList<Int>(n){0}

    // Write solution
    strings(n, c)
}