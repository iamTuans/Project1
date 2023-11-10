package week2;
import java.util.Scanner;
public class permutation_generation {
    public static boolean nextPermutation(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }

        int j = a.length - 1;
        while (a[j] <= a[i]) {
            j--;
        }

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        for (int p = i + 1, q = a.length - 1; p < q; p++, q--) {
            temp = a[p];
            a[p] = a[q];
            a[q] = temp;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }

        do {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
        } while (nextPermutation(a));

        sc.close();
    }
}
