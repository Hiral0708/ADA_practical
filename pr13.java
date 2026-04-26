package ADA;
import java.util.Scanner;
public class pra13_SCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String X = sc.next();
        System.out.print("Enter second string: ");
        String Y = sc.next();

        int m = X.length();
        int n = Y.length();

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println("\nSCS DP Matrix dp[][]:");
        System.out.print("     ");
        System.out.print("  _ ");
        for (int j = 0; j < n; j++) System.out.print("  " + Y.charAt(j) + " ");
        System.out.println();
        for (int i = 0; i <= m; i++) {
            if (i == 0) System.out.print("  _ |");
            else System.out.print("  " + X.charAt(i - 1) + " |");
            for (int j = 0; j <= n; j++) {
                System.out.printf("%3d ", dp[i][j]);
            }
            System.out.println();
        }

        System.out.println("\nLength of SCS: " + dp[m][n]);
        StringBuilder scs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                scs.insert(0, X.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] < dp[i][j - 1]) {
                scs.insert(0, X.charAt(i - 1));
                i--;
            } else {
                scs.insert(0, Y.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) { scs.insert(0, X.charAt(i - 1)); i--; }
        while (j > 0) { scs.insert(0, Y.charAt(j - 1)); j--; }

        System.out.println("SCS: " + scs.toString());
    }
}
