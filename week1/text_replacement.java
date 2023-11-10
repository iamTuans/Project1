package week1;
//JAVA 
import java.util.*; 
public class text_replacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String p1 = sc.nextLine().trim();
        String p2 = sc.nextLine().trim();
        StringBuilder t = new StringBuilder();

        while (sc.hasNextLine()) {
            t.append(sc.nextLine());
            t.append("\n");
        }

        String tModified = t.toString().replaceAll(p1, p2);

        System.out.println(tModified);
    }
}
