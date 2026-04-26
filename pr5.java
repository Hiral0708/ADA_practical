package ADA;
import java.util.Scanner;
public class Pra5QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
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

        quickSort(arr, 0, n - 1);

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
