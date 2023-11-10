package week1;
//JAVA 
import java.util.*; 
public class list_all {
    public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    for(int i=1; i<=a; ++i){
        System.out.println(i + " " + i*i);
    }

        sc.close();
    }
}