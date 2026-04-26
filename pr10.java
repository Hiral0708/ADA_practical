package ADA;
import java.util.*;
public class pra10_Knapsack {
    public static int knapsack01(int[] weights, int[] values, int W) {

        int n = weights.length;
        int[][] v = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    v[i][j] = 0;
                } else if (weights[i - 1] <= j) {
                    v[i][j] = Math.max(v[i - 1][j], values[i - 1] + v[i - 1][j - weights[i - 1]]);
                } else {
                    v[i][j] = v[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.print("Selected Weights: (");
        int i = n;
        int j = W;
        while (i > 0 && j > 0) {
            if (v[i][j] != v[i - 1][j]) {
                System.out.print(weights[i - 1] + ",");
                j = j - weights[i - 1];
            }
            i--;
        }
        System.out.println(")");
        return v[n][W];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight of item " + (i + 1) + ": ");
            weights[i] = sc.nextInt();
            System.out.print("Enter value of item " + (i + 1) + ": ");
            values[i] = sc.nextInt();
        }

        System.out.print("Enter knapsack capacity W: ");
        int W = sc.nextInt();

        int result = knapsack01(weights, values, W);
        System.out.println("maximum value you get is:" + result);
    }
}
