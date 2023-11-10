package week1;
//JAVA 
import java.util.*; 
public class add_subtract {
    public static void main(String[] args) { 
        long a, b;

        Scanner sc = new Scanner(System.in);
        a = sc.nextLong();
        b = sc.nextLong();

        long tong = a + b;
        long hieu = a - b;
        long tich = a * b;
        long thuong = a / b;
        System.out.println(tong +" "+hieu+" "+tich+" "+thuong);
        sc.close();
    }
}
