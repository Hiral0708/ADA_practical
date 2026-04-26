package ADA;
import java.util.Scanner;
public class pra1_SelectionSort {
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
            System.out.println("Normal Array:");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        } else {
            for (int i = 0; i < n; i++) {
                a[i] = (int) (Math.random() * 100);
            }
        }

        long start = System.nanoTime();

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = a[minIdx];
            a[minIdx] = a[i];
            a[i] = temp;
        }

        long end = System.nanoTime();

        if (n <= 10) {
            System.out.println("Sorted Array:");
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println("");
        }

        System.out.println("It takes " + (end - start) + " nano sec");
    }
}
