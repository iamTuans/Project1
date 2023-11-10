package week1;
import java.util.Scanner;
public class count_word {
    public static void main(String[] args) {
        int ans = 0;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String Countwords = sc.next();
            ans = ans + 1;
        }
        System.out.println(ans);
        sc.close();
    }
}
