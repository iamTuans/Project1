package week5;
import java.util.*;
public class hamniton {

    static List<List<Integer>> adj;
    static List<Integer> cur;
    static List<Integer> res;
    static List<Boolean> visited;

    static int HamiltonC(int k, int v) {
        if (k == v + 1) {
            if (adj.get(cur.get(k - 1)).get(1) == 1) {
                return 1;
            }
            return 0;
        }

        for (int y = 1; y <= v; y++) {
            if (!visited.get(y) && adj.get(cur.get(k - 1)).get(y) == 1) {
                cur.set(k, y);
                visited.set(y, true);
                if (HamiltonC(k + 1, v) == 1) {
                    return 1;
                }
                visited.set(y, false);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        res = new ArrayList<>();
        while (T > 0) {
            int v, e;
            v = sc.nextInt();
            e = sc.nextInt();

            adj = new ArrayList<>();
            for (int i = 0; i <= v; i++) {
                adj.add(new ArrayList<>(Collections.nCopies(v + 1, 0)));
            }
            cur = new ArrayList<>(Collections.nCopies(v + 1, 0));
            visited = new ArrayList<>(Collections.nCopies(v + 1, false));

            for (int i = 0; i < e; i++) {
                int x, y;
                x = sc.nextInt();
                y = sc.nextInt();
                adj.get(x).set(y, 1);
                adj.get(y).set(x, 1);
            }

            cur.set(1, 1);
            visited.set(1, true);
            res.add(HamiltonC(2, v));
            --T;
        }

        for (int x : res) {
            System.out.println(x);
        }

        sc.close();
    }
}

