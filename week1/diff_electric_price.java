package week1;
import java.util.Scanner;
public class diff_electric_price {
    public static float[] oldPrice = {1728, 1786, 2074, 2612, 2919, 3015};
    public static float[] newPrice = {1728, 2074, 2612, 3111, 3457};
    public static float oldCalculation(float x) {
        if(x <= 50) 
            return x * oldPrice[0];
        if(x <= 100) 
            return 50 * oldPrice[0] + (x - 50) * oldPrice[1];
        if(x <= 200)
            return 50 * oldPrice[0] + 50 * oldPrice[1] + (x - 100) * oldPrice[2];
        if(x <= 300)
            return 50 * oldPrice[0] + 50 * oldPrice[1] + 100 * oldPrice[2] + (x - 200) * oldPrice[3];
        if(x <= 400)
            return 50 * oldPrice[0] + 50 * oldPrice[1] + 100 * oldPrice[2] + 100 * oldPrice[3] + (x - 300) * oldPrice[4];
        
        return 50 * oldPrice[0] + 50 * oldPrice[1] + 100 * oldPrice[2] + 100 * oldPrice[3] + 100 * oldPrice[4] + (x - 400) * oldPrice[5];
    }
    
    public static float newCalculation(float x) {
        if(x <= 100) 
            return x * newPrice[0];
        if(x <= 200) 
            return 100 * newPrice[0] + (x - 100) * newPrice[1];
        if(x <= 400)
            return 100 * newPrice[0] + 100 * newPrice[1] + (x - 200) * newPrice[2];
        if(x <= 700)
            return 100 * newPrice[0] + 100 * newPrice[1] + 200 * newPrice[2] + (x - 400) * newPrice[3];
        
        return 100 * newPrice[0] + 100 * newPrice[1] + 200 * newPrice[2] + 300 * newPrice[3] + (x - 700) * newPrice[4];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        float ans=(newCalculation(x) - oldCalculation(x))* 1.1f;
        String formattedSAns = String.format("%.2f", ans);
        System.out.println(formattedSAns);
    }
}
