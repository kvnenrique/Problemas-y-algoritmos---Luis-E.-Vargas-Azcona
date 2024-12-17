import java.util.Arrays;

/**
 * Recursive implementation of pascal triangle calculator with memorization
 */
public class Pascal{
    public static void main(String[] args){
        int[][] memory = new int[100][100];
        // Initialize memory with 0's
        for (int i=0; i<memory.length; i++){
            Arrays.fill(memory[i], 0, memory[i].length-1, 0);
        }

        
        System.out.println(pascal(3, 3, memory));
    }

    private static int pascal (int i, int j, int[][] memory){
        // Just to make sure we are not out of bonuds
        j = (j > i)? i : j;
        //

        if (memory[i][j] != 0){
            return memory[i][j];
        }


        if (j == 0 || j == i){
            memory[i][j] = 1;
            return 1;
        }

        memory[i][j] = pascal(i-1, j-1, memory) + pascal(i-1, j, memory);
        return memory[i][j];
    }
}