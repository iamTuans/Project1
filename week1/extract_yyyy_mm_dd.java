package week1;
import java.util.*; 
import java.time.LocalDate;
public class extract_yyyy_mm_dd {
//JAVA 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        try {
            LocalDate date = LocalDate.parse(temp);

            System.out.println(date.getYear() + " " + date.getMonth().getValue() + " " + date.getDayOfMonth());
        } catch (Exception e) {
            System.out.println("INCORRECT");
        }

        sc.close();
    }
}
