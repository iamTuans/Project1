package week5;
import java.util.*;

public class bfs {
    static List<Boolean> visited;
    static List<List<Integer>> adj;

    static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        visited.set(v, true);

        while (!q.isEmpty()) {
            int p = q.poll();
            System.out.print(p + " ");

            for (int u : adj.get(p)) {
                if (!visited.get(u)) {
                    q.add(u);
                    visited.set(u, true);
                }
            }
        }
    }

    static void lexicographicOrder(int n) {
        for (int i = 0; i < n; i++) {
            Collections.sort(adj.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        visited = new ArrayList<>(Collections.nCopies(n + 1, false));
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        lexicographicOrder(adj.size());

        for (int i = 1; i <= n; i++) {
            if (!visited.get(i))
                BFS(i);
        }

        scanner.close();
    }
}
