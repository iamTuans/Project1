package week4;
import java.util.*;

public class sum_pair_equal_m {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, M;
        n = scanner.nextInt();
        M = scanner.nextInt();

        Map<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int x = entry.getKey();
            int y = M - x;
            if (freqMap.containsKey(y) && x != y) {
                count++;
            }
        }

        System.out.println(count / 2);

        scanner.close();
    }
}

/*Problem: Sum pair of sequence equal to a number
Description
Cho dãy a1, a2, ..., an trong đó các phần tử đôi một khác nhau và 1 giá trị nguyên dương M. Hãy đếm số Q các cặp (i,j) sao cho 1 <= i < j <= n và ai + aj = M.

Dữ liệu
Dòng 1: ghi n và M (1 <= n, M <= 1000000)
Dòng 2: ghi a1, a2, ..., an
Kết quả
Ghi ra giá trị Q
Ví dụ
Dữ liệu
5 6
5 2 1 4 3
Kết quả
2 */