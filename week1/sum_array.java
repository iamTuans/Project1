package week1;
//JAVA 
import java.util.*; 
public class sum_array {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 5];
        for(int i = 1; i<= n; ++i)
        {
            arr[i] = sc.nextInt();
        }
        int sum = 0;
        for(int i = 1; i<= n; ++i)
        {
            sum = sum + arr[i];
        }
        System.out.println(sum);
        sc.close();
    }
}
