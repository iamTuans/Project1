package week1;
//JAVA 
import java.util.*; 
public class list_sequence {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 100/n; i<=999/n; ++i)
        {
            if (n*i >=100 && n*i <= 999)
            {
            System.out.print(n*i);
            System.out.print(" ");
            }
        }
        sc.close();
    }
}
