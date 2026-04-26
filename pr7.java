package ADA;
import java.util.*;
public class pra7_PrimsMST {
    public static void main(String[] args) {
        int n, count = 0, u = 0, v = 0, min, total = 0;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        n = sc.nextInt();

        int[][] arr = new int[n][n];
        int[] mark = new int[n];

        for (int i = 0; i < n; i++) {
            mark[i] = 0;
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
        mark[0] = 1;
        System.out.println("\nEdges selected:");
        while (count < n - 1) {
            min = 99;
            for (int i = 0; i < n; i++) {
                if (mark[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (arr[i][j] < min) {
                            min = arr[i][j];
                            u = i;
                            v = j;
                        }
                    }
                }
            }
            if ((mark[u] == 0 && mark[v] == 1) || (mark[u] == 1 && mark[v] == 0)) {
                System.out.println(u + " - " + v + " -> " + min);
                total = total + min;
                mark[u] = mark[v] = 1;
                count++;
            }
            arr[u][v] = arr[v][u] = 99;
        }

        System.out.println("Total cost = " + total);
    }
}
