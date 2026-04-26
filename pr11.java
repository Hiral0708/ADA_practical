package ADA;
import java.util.Scanner;
public class pra11_MatrixChainMult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int[] p = new int[n + 1];
        System.out.println("Enter dimensions (d[0] to d[" + n + "]):");
        for (int i = 0; i <= n; i++) {
            System.out.print("d[" + i + "] = ");
            p[i] = sc.nextInt();
        }

        int[][] m = new int[n + 1][n + 1];
        int[][] s = new int[n + 1][n + 1];

        // Single matrices have 0 cost
        for (int i = 1; i <= n; i++) m[i][i] = 0;

        // Fill DP table
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (cost < m[i][j]) {
                        m[i][j] = cost;
                        s[i][j] = k;
                    }
                }
            }
        }

        // Print m matrix
        System.out.println("\nDP Cost Matrix m[][]:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j < i)
                    System.out.printf("%8d", 0);
                else
                    System.out.printf("%8d", m[i][j]);
            }
            System.out.println();
        }

        // Print s matrix
        System.out.println("\nSplit Matrix s[][]:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.printf("%5d", s[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nMinimum number of multiplications: " + m[1][n]);
        System.out.print("Optimal Parenthesization: ");
        printOptimal(s, 1, n);
        System.out.println();
    }

    public static void printOptimal(int[][] s, int i, int j) {
        if (i == j) {
            System.out.print("M" + i);
        } else {
            System.out.print("(");
            printOptimal(s, i, s[i][j]);
            printOptimal(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }
}
