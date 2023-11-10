package week5;
import java.util.*;

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

public class kutal {
    static class UF {
        int[] parent;

        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int u) {
            if (parent[u] == u) {
                return u;
            }
            return parent[u] = find(parent[u]);
        }

        void merge(int u, int v) {
            parent[find(u)] = find(v);
        }
    }

    static int kruskal(List<Edge> edges, int n) {
        UF uf = new UF(n);
        int cost = 0;
        for (Edge e : edges) {
            if (uf.find(e.u) != uf.find(e.v)) {
                uf.merge(e.u, e.v);
                cost += e.w;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Edge(u - 1, v - 1, w));
        }
        edges.sort((e1, e2) -> e1.w - e2.w);
        System.out.println(kruskal(edges, n));
        scanner.close();
    }
}

