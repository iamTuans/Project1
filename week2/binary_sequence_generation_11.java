package week2;
import java.util.Scanner;
public class binary_sequence_generation_11 {
    static int n;
    static int[] a;

    public static void S() {
        for (int i = 1; i <= n; i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void Try(int x) {
        for (int i = 0; i <= 1; i++) {
            if (i == 1 && a[x - 1] == 1) continue;
            a[x] = i;
            if (x == n) S();
            else Try(x + 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n + 1];
        Try(1);
        sc.close();
    }
}
