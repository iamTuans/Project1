package week5;
import java.util.*;

public class dfs {
    static List<List<Integer>> adj;
    static List<Boolean> visited;
    static Stack<Integer> st;

    static void DFS(int v) {
        st.push(v);
        visited.set(v, true);

        while (!st.empty()) {
            int res = st.peek();
            System.out.print(res + " ");
            st.pop();

            for (int tmp : adj.get(res)) {
                if (!visited.get(tmp))
                    DFS(tmp);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();

        adj = new ArrayList<>();
        visited = new ArrayList<>();
        st = new Stack<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
            visited.add(false);
        }

        for (int i = 1; i <= m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        for (int i = 1; i <= n; i++) {
            if (!visited.get(i))
                DFS(i);
        }

        scanner.close();
    }
}

