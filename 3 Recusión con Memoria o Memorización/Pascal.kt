/**
 * Recursive implementation of pascal triangle calculator with memorization
 */
fun main(){
    val memory = Array<Array<Int>> (100){Array<Int>(100){0}}
    print(pascal(3, 1, memory));

}

fun pascal (i: Int, j: Int, memory: Array<Array<Int>>): Int{
    // Just to make sure that there are not values out of bounds
    // We can't modify params in kotlin since them are inmmutable by default
    // althoug we can define a local variable with the same name to shadow
    // the inmutable param.
    var j = j;
    j = if (j >= i) i else j;
    //
    
    when {
        (memory[i][j] != 0) -> {
            return memory[i][j];
        }

        (j == 0 || j == i) -> {
            memory[i][j] = 1;
            return 1;
        }

        else -> {
            memory[i][j] = pascal(i-1, j-1, memory) + pascal(i-1, j, memory);
            return memory[i][j];
        }
    }
}