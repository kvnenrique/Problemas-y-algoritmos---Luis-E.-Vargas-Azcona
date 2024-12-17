import java.util.Arrays;

/**
 * Recursive implementation of fibonacci with memorization
 */
public class Fibonacci{
    public static void main(String args[]){
        int[] memory = new int[100];
        Arrays.fill(memory, 0, memory.length, 0);

        for (int i=0; i<10; i++){
            System.out.println(fibonacciRecursiveWithMemorization(i, memory));
        }
    }

    private static int fibonacciRecursiveWithMemorization (int n, int[] memory){
        if (memory[n] != 0){
            return memory[n];
        }
        if (n == 0){
            return 0;
        } 
        if (n == 1){
            return 1;
        } else {
            memory[n] = fibonacciRecursiveWithMemorization(n-1, memory) + fibonacciRecursiveWithMemorization(n-2, memory);
            return memory[n];
        }
    }
}