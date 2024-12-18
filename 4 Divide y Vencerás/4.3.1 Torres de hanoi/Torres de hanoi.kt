package org.example
import java.util.Scanner

/**
 * Input data
 * n: Number of discs in the origin tower
 */
var n = 0
var originTowerName = "A"
var auxiliaryTowerName = "B"
var targetTowerName = "C"

fun readInput() {
    val scanner = Scanner(System.`in`)
    n = scanner.nextInt()

    originTowerName = scanner.next()
    auxiliaryTowerName = scanner.next()
    targetTowerName = scanner.next()
}

/**
 * Writes the steps to pass the [n] discs from [origin] tower to [target] tower.
 * @param aux The name of the auxiliary tower, which is not the [origin] nor
 * the [target].
 */
fun hanoiAlgorithm(origin: String, aux: String, target: String, n: Int) {
    when {
        n < 1 -> {
            println("There isn't any disc to move")
        }

        n == 1 -> {
            println("Disc $n: $origin -> $target")
        }

        else -> {
            hanoiAlgorithm(origin, target, aux, n-1);
            println("Disc $n: $origin -> $target")
            hanoiAlgorithm(aux, origin, target, n-1)
        }
    }
}


fun main() {
    // Read input data
    readInput()

    // Write solution
    hanoiAlgorithm(originTowerName, auxiliaryTowerName, targetTowerName, n)
}