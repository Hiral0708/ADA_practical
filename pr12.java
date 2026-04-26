package ADA;
import java.util.Scanner;
public class pra12_LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String X = sc.next();
        System.out.print("Enter second string: ");
        String Y = sc.next();
        int m = X.length();
        int n = Y.length();
        int[][] c = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        System.out.println("\nLCS DP Matrix c[][]:");
        System.out.print("     ");
        System.out.print("  _ ");
        for (int j = 0; j < n; j++) System.out.print("  " + Y.charAt(j) + " ");
        System.out.println();
        for (int i = 0; i <= m; i++) {
            if (i == 0) System.out.print("  _ |");
            else System.out.print("  " + X.charAt(i - 1) + " |");
            for (int j = 0; j <= n; j++) {
                System.out.printf("%3d ", c[i][j]);
            }
            System.out.println();
        }
        System.out.println("\nLength of LCS: " + c[m][n]);
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                lcs.insert(0, X.charAt(i - 1));
                i--;
                j--;
            } else if (c[i - 1][j] > c[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("LCS: " + lcs.toString());
    }
}
