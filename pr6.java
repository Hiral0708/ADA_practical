package ADA;
import java.util.Scanner;
public class pra6_Searching {
    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) return i;
        }
        return -1;
    }
    public static int binarySearch(int[] a, int key) {
        int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key) return mid;
            else if (a[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no of elements in array: ");
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter " + (i + 1) + "th value: ");
            a[i] = sc.nextInt();
        }
        System.out.println("Array:");
        for (int i = 0; i < n; i++) System.out.print(a[i] + " ");
        System.out.println("");
        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        // Linear Search
        long lStart = System.nanoTime();
        int lResult = linearSearch(a, key);
        long lEnd = System.nanoTime();
        if (lResult != -1)
            System.out.println("Linear Search: Found at index " + lResult);
        else
            System.out.println("Linear Search: Element not found");
        System.out.println("Linear Search time: " + (lEnd - lStart) + " nano sec");

        // Sort array for binary search
        int[] sorted = a.clone();
        java.util.Arrays.sort(sorted);
        System.out.println("Sorted Array for Binary Search:");
        for (int i = 0; i < n; i++) System.out.print(sorted[i] + " ");
        System.out.println("");

        // Binary Search
        long bStart = System.nanoTime();
        int bResult = binarySearch(sorted, key);
        long bEnd = System.nanoTime();
        if (bResult != -1)
            System.out.println("Binary Search: Found at index " + bResult);
        else
            System.out.println("Binary Search: Element not found");
        System.out.println("Binary Search time: " + (bEnd - bStart) + " nano sec");
    }
}
