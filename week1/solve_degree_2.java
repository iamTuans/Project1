package week1;
//JAVA 
import java.util.*; 
public class solve_degree_2 {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);

        double a, b, c;
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();

        double delta = b * b - 4 * a * c;
        if(delta < 0) {
            System.out.println("NO SOLUTION");
    }   
        else if (delta == 0) {
            double x0 = -b/(2*a);
            String formattedSX0 = String.format("%.2f", x0);
            System.out.println(formattedSX0);
    }
        else {
            double x1 = (-b - Math.sqrt(delta)) / (2 * a);
            double x2 = (-b + Math.sqrt(delta)) / (2 * a);
            String formattedSX1= String.format("%.2f", x1);
            String formattedSX2 = String.format("%.2f", x2);
            System.out.println(formattedSX1 +" "+ formattedSX2);
    }
}
}
