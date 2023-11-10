package week4;
//JAVA 
import java.util.*;
public class ipmac_set_exist { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int tmp = sc.nextInt();
            int check = 1;
            if (!exist.contains(tmp)) {
                exist.add(tmp);
                check = 0;
            }
            res.add(check);
        }
        for (int x : res) {
            System.out.println(x);
        }
        sc.close();
    }
}

/*Problem: Kiểm tra xuất hiện
Description
Cho dãy số nguyên A1, A2, . . . , An với mỗi số nguyên Ai kiểm tra xem có số Aj nào bằng Ai hay không với j<i.
Input
Dòng đầu chứa số n (1≤n≤100,000)
Dòng hai chứa nn số nguyên A1, A2, ..., An (1≤Ai≤1000,000,000)
Output
Ghi ra n dòng, dòng thứ i in ra 1 nếu tồn tại Aj=Ai với j<i, ngược lại in ra 0.
Example
input
5
1 4 3 1 4
output
0
0
0
1
1
 */