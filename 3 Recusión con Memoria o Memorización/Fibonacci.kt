/**
 * Recursive implementation of fibonacci with memorization
 */
fun main(){
    // Initialize memory for recursive function
    val memory = Array<Int>(100){0};
    for (i in 0 .. memory.size - 1){
        memory[i] = 0;
    }
    
    // Print each item of the Fibonacci's series
    for (i in 0 .. 10){
        println(fibonacciRecursiveWithMemorization(i, memory));
    }
}


fun fibonacciRecursiveWithMemorization (n: Int, memory: Array<Int>): Int{
    when {
        // If factorial(n) has already been computed, dont calculate it
        // again
        (memory[n] != 0) -> {
            return memory[n];
        }

        (n == 0) -> {
            return 0;
        }

        (n == 1) -> {
            return 1;
        }

        else -> {
            memory[n] = fibonacciRecursiveWithMemorization(n-1, memory) + fibonacciRecursiveWithMemorization(n-2, memory);   
            return memory[n];
        }
    }
}