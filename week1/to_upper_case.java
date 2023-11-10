package week1;
//JAVA 
import java.util.*; 
public class to_upper_case {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String temp;

        while (sc.hasNextLine()) {
            temp = sc.nextLine();

            System.out.println(temp.toUpperCase());
        }
    }
}
