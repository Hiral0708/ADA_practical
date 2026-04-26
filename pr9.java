package ADA;
import java.util.*;
public class pra9_MakingChange {
    public static void making_change(int n, int N, int[] d) {
        int[][] c = new int[n + 1][N + 1];
        for (int i = 0; i <= n; i++) {
            c[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == 1) {
                    if (j < d[0]) {
                        c[i][j] = 99;
                    } else {
                        c[i][j] = 1 + c[i][j - d[0]];
                    }
                } else {
                    if (j < d[i - 1]) {
                        c[i][j] = c[i - 1][j];
                    } else {
                        c[i][j] = Math.min(c[i - 1][j],
                                1 + c[i][j - d[i - 1]]);
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= N; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("Minimum notes required: " + c[n][N]);
        int i = n;
        int j = N;
        int t = 0;
        int[] k = new int[c[n][N]];
        while (j > 0 && i > 0) {
            if (c[i][j] == c[i - 1][j]) {
                i--;
            } else {
                k[t++] = d[i - 1];
                j = j - d[i - 1];
            }
        }
        System.out.print("Requred notes is: ");
        System.out.print("(");
        for (int s = 0; s < c[n][N]; s++) {
            if (s == c[n][N] - 1) {
                System.out.print(k[s]);
            } else {
                System.out.print(k[s] + ",");
            }
        }
        System.out.println(")");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of notes: ");
        int n = sc.nextInt();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + "th note value: ");
            d[i] = sc.nextInt();
        }
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        making_change(n, N, d);
    }
}
