import java.util.Scanner;
import java.util.Arrays;

public class Chocolate {
    public static void main(String[] args){
        // Read the input
        Scanner scanner = new Scanner(System.in);
        int n = 0, m = 0;
        m = scanner.nextInt();
        n = scanner.nextInt();
        
        int[] x = new int[m-1];
        int[] y = new int[n-1];

        for (int i=0; i < x.length; i++){
            x[i] = scanner.nextInt();
        }
        for (int i=0; i < y.length; i++){
            y[i] = scanner.nextInt();
        }

        // Perform the algorithm to find the minimum cost
        long result = chocolate(m, n, x, y);

        // Show the result
        System.out.println(result);
    }

    private static long chocolate (int m, int n, int[] x, int[] y){
        // Start by ordering the costs of vertical and horizontal breaks x[] and y[]
        Arrays.sort(x);
        Arrays.sort(y);

        // Initialize the multiplying factors for horizontal and vertical breaks
        int verticalFactor = 1;
        int horizontalFactor = 1;

        int i = x.length -1;
        int j = y.length -1;

        // Compute the minimum cost for break all the chocolate into single squares
        long minimumCost = 0;
        while (i >= 0 && j >= 0){
            if (x[i] > y[j]){
                minimumCost += x[i] * verticalFactor;
                horizontalFactor++;
                i--;
            } else {
                minimumCost += y[j] * horizontalFactor;
                verticalFactor++;
                j--;
            }
        }
        while (i >= 0){
            minimumCost += x[i] * verticalFactor;
            i--;
        }
        while (j >= 0){
            minimumCost += y[j] * horizontalFactor;
            j--;
        }

        return minimumCost;
    }
}