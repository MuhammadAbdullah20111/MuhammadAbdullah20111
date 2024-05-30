import java.util.Scanner;

public class Knapsack {

    // Method to solve the knapsack problem
    public static void knapsack(int[] weights, int[] values, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];

        // Build the table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // Store the result of knapsack
        int res = dp[n][W];
        System.out.println("Maximum value: " + res);

        // Display the dynamic programming table
        System.out.println("\nDynamic Programming Table:");
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                System.out.print(dp[i][w] + " ");
            }
            System.out.println();
        }

        // Print the items that are included in the knapsack
        int w = W;
        System.out.println("\nSelected items (weight, value):");
        for (int i = n; i > 0 && res > 0; i--) {
            if (res != dp[i - 1][w]) {
                System.out.println("(" + weights[i - 1] + ", " + values[i - 1] + ")");
                res -= values[i - 1];
                w -= weights[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();

        System.out.print("Enter the maximum weight: ");
        int W = scanner.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        System.out.println("Enter the elements (weight and benefit):");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
            values[i] = scanner.nextInt();
        }

        scanner.close();
        knapsack(weights, values, n, W);
    }
}
