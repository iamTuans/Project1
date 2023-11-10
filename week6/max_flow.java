package week6;
import java.util.*;

public class max_flow {
    static boolean check(int[][] e, int key, int size, boolean[] in) {
        if (in[key]) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (in[i]) {
                continue;
            }

            if (e[key][i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] edge;
        boolean[] insource;
        int m, n, a, b, c, start, finish, min = 0, sum = 0;
        List<Integer> source = new ArrayList<>();

        m = sc.nextInt();
        n = sc.nextInt();
        start = sc.nextInt();
        finish = sc.nextInt();
        edge = new int[m][m];
        insource = new boolean[m];
        for (int i = 0; i < m; i++) {
            insource[i] = false;
            for (int j = 0; j < m; j++) {
                edge[i][j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            a--;
            b--;
            edge[a][b] = c;
            edge[b][a] = -c;
        }

        finish--;
        source.add(--start);
        insource[start] = true;

        for (int i = 0; i < m; i++) {
            min += edge[start][i];
        }
        sum = min;

        while (!source.isEmpty()) {
            start = source.get(0);
            for (int i = 0; i < m; i++) {
                if (i == finish || i == start) continue;

                if (edge[start][i] > 0 && check(edge, i, m, insource)) {
                    source.add(i);
                    insource[i] = true;
                } else continue;

                for (int j = 0; j < m; j++) sum += edge[i][j];

                if (min > sum) min = sum;
            }
            source.remove(0);
        }

        System.out.println(min);
        sc.close();
    }
}
