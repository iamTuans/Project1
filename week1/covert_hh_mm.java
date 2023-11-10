package week1;
//JAVA 
import java.util.*; 
import java.time.LocalTime;
public class covert_hh_mm {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String temp = sc.nextLine();
        try {
            LocalTime date = LocalTime.parse(temp);

            System.out.println(date.getHour()*3600 + date.getMinute()*60 + date.getSecond());
        } catch (Exception e) {
            System.out.println("INCORRECT");
        }

        sc.close();
    }
}
