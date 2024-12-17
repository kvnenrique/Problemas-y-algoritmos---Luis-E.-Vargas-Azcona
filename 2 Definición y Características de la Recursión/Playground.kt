fun main (){
    // External variable to count the nummber of call to
    // the factorial recursive fuction
    var calls = Box(0);
    println(fibonacciRecursive(3, calls));
    println("Number of call to fibonacci recursive function: " + calls.value.toString());
}

fun factorial (n: Int): Int{
    var fminus1: Int;
    println(n);
    if (n == 0) return 1;
    fminus1 = factorial(n-1);
    println(n.toString() + " " + fminus1.toString());
    return (n * fminus1);
}

fun decimalToBinary (decimal: Int): String{
    if (decimal >= 2){
        return decimalToBinary(decimal/2) + (decimal%2).toString();
    } else {
        return decimal.toString();
    }
}

fun fibonacciRecursive (n: Int, calls: Box): Int{
    // Register another call to the recursive funcion.
    calls.value++;
    when {
        (n == 0) -> {
            return 0;
        }

        (n == 1) -> {
            return 1;
        }

        else -> {
            return (fibonacciRecursive(n-1, calls) + fibonacciRecursive(n-2, calls));
        }
    }
}

fun fibonacci (n: Int): Int{
    var previousA = 0;
    var previousB = 1;
    var fibonacci = 0;

    for (i in 0 .. n-1){
        fibonacci = previousB + previousA;
        previousB = previousA;
        previousA = fibonacci;
    }

    return fibonacci;
}

// An integer container that we can 
// use like pointer to int
class Box (value: Int){
    var value: Int = value;
}