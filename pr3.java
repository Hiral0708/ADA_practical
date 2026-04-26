package ADA;
import java.util.Scanner;
public class Pra3InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements in array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        if (n <= 10) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter " + (i + 1) + "th value: ");
                a[i] = sc.nextInt();
            }
            System.out.println("Original Array:");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * 100000);
            }
        }
        long start = System.nanoTime();
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;

            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        long end = System.nanoTime();
        if (n <= 10) {
            System.out.println("Sorted Array:");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        }
        System.out.println("Execution time: " + (end - start) + " nanoseconds");
        System.out.println("Execution time (ms): " + ((end - start) / 1_000_000.0));
        sc.close();
    }
}
