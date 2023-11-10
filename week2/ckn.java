package week2;
import java.util.Scanner;
public class ckn {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[1000];
        arr[0] = 1;
        for ( int i = 1; i< 1000; i++){
            arr[i]=0;
        }
        for ( int i = 1; i<=n; i++){
            for(int j=i; j>0; j--){
            arr[j] += arr[j - 1];
            arr[j] %= 1000000007;
            }
        }

        System.out.println(arr[k]);
        scanner.close();
    }
}