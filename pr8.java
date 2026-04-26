package ADA;
import java.util.*;
public class pra8_KruskalMST {
    public static void main(String[] args) {
        int n, count = 0, min, u = 0, v = 0, total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();
        int[][] arr = new int[n][n];
        int[] mark = new int[n];

        for (int i = 0; i < n; i++) {
            mark[i] = i;
        }

        System.out.println("Enter weight matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                if (arr[i][j] == 0) {
                    arr[i][j] = 99;
                }
            }
        }

        System.out.println("\nEdges selected:");

        while (count < n - 1) {
            min = 99;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] < min) {
                        min = arr[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            int ucomp = mark[u];
            int vcomp = mark[v];

            if (ucomp != vcomp) {
                System.out.println(u + " - " + v + " -> " + min);
                count++;
                total += min;

                for (int i = 0; i < n; i++) {
                    if (mark[i] == ucomp) {
                        mark[i] = vcomp;
                    }
                }
            }


            arr[u][v] = arr[v][u] = 99;
        }

        System.out.println("Total cost = " + total);
        sc.close();
    }
}
