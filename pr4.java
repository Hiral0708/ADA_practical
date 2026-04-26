package ADA;
import java.util.Scanner;
public class Pra4MergeSort {
    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        if (n <= 10) {
            for (int i = 0; i < n; i++) {
                System.out.print("Enter " + (i + 1) + "th value: ");
                arr[i] = sc.nextInt();
            }

            System.out.println("Original Array:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                arr[i] = (int) (Math.random() * 100000);
            }
        }
        long start = System.nanoTime();

        mergeSort(arr, 0, n - 1);

        long end = System.nanoTime();
        if (n <= 10) {
            System.out.println("Sorted Array:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        System.out.println("Execution time: " + (end - start) + " nanoseconds");
        System.out.println("Execution time (ms): " + ((end - start) / 1_000_000.0));
        sc.close();
    }
}
