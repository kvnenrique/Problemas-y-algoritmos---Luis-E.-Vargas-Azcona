public class PlayGround {
    public static void main(String[] args){

        Box box = new Box();
        box.value = 0;
        System.out.println(fibonacciRecursive(25, box));
        System.out.println("Invocations of fibonacciRecursive: " + String.valueOf(box.value));
    }

    private static int factorial (int n){
        int fminus1;
        System.out.println(n);
        if (n == 0) return 1;
        fminus1 = factorial(n-1);
        System.out.println(String.valueOf(n) + " " + String.valueOf(fminus1));
        return  n * fminus1;
    }

    private static String decimalToBinary (int n){
        if (n >= 2){
            return decimalToBinary(n/2) + String.valueOf(n%2);
        } else {
            return String.valueOf(n);
        }
    }

    private static int fibonacciRecursive (int n, Box box){
        // Save the number of access to the recursive fuction
        box.value++;


        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        } else {
            return (fibonacciRecursive(n-1, box) + fibonacciRecursive(n-2, box));
        }
    }

    private static int fibonacci (int n){
        int fibonacci_a = 0;
        int fibonacci_b = 1;
        int fibonacci = 0;

        for (int i = 0; i < n; i++){
            fibonacci = fibonacci_b + fibonacci_a;
            fibonacci_b = fibonacci_a;
            fibonacci_a = fibonacci;
        }

        return fibonacci;
    }

    private static class Box{
        public int value;
    }
}