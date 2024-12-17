package org.example
import java.util.Scanner

/**
 * Input data
 */
var n = 0 // The size of the input array
val v = mutableListOf<Int>() // The input array
var a = 0 // index a
var b = 0 // Index b

/**
 * Inner functions
 */
fun readInput() {
    val scanner = Scanner(System.`in`)
    n = scanner.nextInt()
    for (i in 0 ..< n) {
        v.add(scanner.nextInt())
    }

    a = scanner.nextInt()
    b = scanner.nextInt()
}

/**
 * Non-recursive solution
 */
fun findMax(v: List<Int>, a: Int, b: Int): Int {
    var lowerIndex = if (a < b) a else b
    val higherIndex = if (a < b) b else a

    var max = v[lowerIndex]

    while(lowerIndex <= higherIndex) {
        if (v[lowerIndex] > max) {
            max = v[lowerIndex]
        }
        lowerIndex++
    }

    return max
}

/**
 * The same non-recursive answer but using the kotlin style
 */
fun findMaxKotlinStyle(v: List<Int>, a: Int, b: Int): Int {
    var max = 0
    val lowerIndex = Math.min(a, b)
    val higherIndex = Math.max(a, b)

    // Notice that sublist(from, to) is inclusive in {from} and exclusive in {to}
    v.subList(lowerIndex, higherIndex + 1).forEach { item ->
        max = if (item > max) item else max
    }

    return max
}

/**
 * The recursive solution that
 */
fun findMaxRecursive(v: List<Int>, a: Int, b: Int): Int {
    var lowerIndex = if (a < b) a else b
    var higherIndex = if (a < b) b else a

    if (lowerIndex < higherIndex) {
        val mid = (lowerIndex + higherIndex) / 2
        val max = Math.max(findMaxRecursive(v, lowerIndex, mid), findMaxRecursive(v, mid + 1, higherIndex))
        return max
    } else {
        // It's the base case where the array size is 1
        return v[lowerIndex]
    }
}



fun main() {
    // Read input data
    readInput()

    // Find solution
    val max = findMaxRecursive(v, a, b)

    // Show answer
    println(max)
}