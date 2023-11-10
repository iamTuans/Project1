package week1;
import java.util.Scanner;
public class k_sub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        int sum = 0, ans = 0;

        n = sc.nextInt();
        k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < k; ++i) {
            sum += arr[i];
        }

        if (sum % 2 == 0) {
            ans++;
        }
        for (int i = k; i < n; ++i) {
            sum += arr[i];
            sum -= arr[i - k];

            if (sum % 2 == 0) {
                ++ans;
            }
        }

        System.out.println(ans);
        sc.close();
    }
}
