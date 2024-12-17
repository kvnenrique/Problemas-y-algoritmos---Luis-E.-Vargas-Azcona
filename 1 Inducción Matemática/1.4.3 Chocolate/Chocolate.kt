import java.util.Scanner

/**
 * Input data
 */
var m = 0
var n = 0
// Cost of braking along consecutive vertical lines
var x = mutableListOf<Int>()
// Cost of braking along consecutive horizontal lines
var y = mutableListOf<Int>()




/**
 * Functions
 */
fun readInput() {
    val scanner = Scanner(System.`in`)
    m = scanner.nextInt()
    n = scanner.nextInt()

    // Read costs of braking along consecutive vertical lines X
    for (i in 0 ..< m-1) {
        x.add(scanner.nextInt())
    }
    // Read the costs of breaking along consecutive horizontal lines Y
    for (i in 0 ..< n-1) {
        y.add(scanner.nextInt())
    }
}

fun chocolate(m: Int, n: Int, x: List<Int>, y: List<Int>): Long {
    // Start by sorting the costs of vertical and horizontal breaks (x[] and y[])
    val sortedX = x.sorted()
    val sortedY = y.sorted()

    // Initialize multiplying factors for horizontal and vertical breaks
    var verticalFactor = 1
    var horizontalFactor = 1

    // Initialize indexes of current value taken from sortedX and sortedY
    var i = sortedX.size - 1 // Current cost on X
    var j = sortedY.size - 1 // Current cost on Y

    // Compute the minimum cost of braking all the chocolate into single squares.
    var minimumCost: Long = 0;
    while (i >= 0 && j >= 0){
        if (sortedX[i] > sortedY[j]) {
            minimumCost += sortedX[i] * verticalFactor
            horizontalFactor++
            i--
        } else {
            minimumCost += sortedY[j] * horizontalFactor
            verticalFactor++
            j--
        }
    }
    while (i >= 0) {
        minimumCost += sortedX[i] * verticalFactor
        i--
    }
    while (j >= 0) {
        minimumCost += sortedY[j] * horizontalFactor
        j--
    }

    return minimumCost
}




/**
 * Main program
 */
fun main() {
    // Read input
    readInput()

    // Perform the algorithm to find the minimum cost
    val result = chocolate(m, n, x, y)

    // Show result
    println(result)
}