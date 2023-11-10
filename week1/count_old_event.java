package week1;
//JAVA 
import java.util.*; 
public class count_old_event {
    public static void main(String[] args) { 
    Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int chan = 0, le = 0;
        int num;
        for(int i = 0; i < n; ++i){
            num = sc.nextInt();
            if (num %2 ==0 ) chan++; else le++;
        }

        System.out.println(le + " " + chan);
        sc.close();
    }
}
