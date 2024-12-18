import java.util.Scanner

/**
 * Input data
 * n: The size of the v[] array
 * v[]: Ordered array
 * a: Lower index
 * b: Higher index
 * x: Searched value
 */
var n: Int = 0
var v: MutableList<Int> = mutableListOf()
var a = 0
var b = 0
var x = 0

fun readInput() {
    val scanner = Scanner(System.`in`)
    n = scanner.nextInt()
    for (i in 0 ..< n) {
        v.add(scanner.nextInt())
    }
    a = scanner.nextInt()
    b = scanner.nextInt()
    x = scanner.nextInt()
}

/**
 * Search the value [x] in the given sorted array [v] between the [a], [b] indexes.
 * @return -1 if the value wasn't found in the given range. The index where the value
 * was found otherwise.
 */
fun binarySearch(v: List<Int>, a: Int, b: Int, x: Int): Int {
    val middle = (a + b) / 2

    println("binarySearch($a, $b)")

    when {
        a >= b -> {
            return if (v[a] == x) {
                a
            } else {
                // Searched value wasn't found.
                -1
            }
        }

        v[middle] == x -> {
            // Searched value is just in the middle index
            return middle
        }

        v[middle] > x -> {
            // Searched value will be on the left side.
            return binarySearch(v, a, middle - 1, x)
        }

        else -> {
            // Searched value will be on the right side
            return binarySearch(v, middle + 1, b, x)
        }
    }
}

/**
 * Although the idea behind binary search is purely recursive, we can implement the binary search
 * without recursion.
 */
fun iterativeBinarySearch(v: List<Int>, a: Int, b: Int, x: Int): Int {
    var a = a // Name shadowing to make a mutable inside function scope without side effects
    var b = b // Name shadowing to make b mutable inside function scope without side effects

    val mid = (a+b)/2

    while (a < b) {
        if (v[mid] == x) {
            return mid
        } else {
            if (v[mid] > x) {
                // x is on the left side
                return iterativeBinarySearch(v, a, mid-1, x)
            } else {
                // x is on the right side
                return iterativeBinarySearch(v, mid+1, b, x)
            }
        }
    }

    return -1
}

fun main() {
    // Read input data
    readInput()

    // Find solution
    val res = iterativeBinarySearch(v, a, b, x)

    // Show answer
    println(res)
}