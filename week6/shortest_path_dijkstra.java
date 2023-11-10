package week6;
import java.util.*;

public class shortest_path_dijkstra {
static final int INF = Integer.MAX_VALUE;

    static void dijkstra(List<List<Pair<Integer, Integer>>> a, int s, int[] dis) {
        int n = a.size();
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::getKey));

        dis[s] = 0;
        pq.add(new Pair<>(0, s));

        while (!pq.isEmpty()) {
            int u = pq.peek().getValue();
            pq.poll();

            for (Pair<Integer, Integer> pair : a.get(u)) {
                int v = pair.getKey();
                int w = pair.getValue();
                if (dis[v] > dis[u] + w) {
                    dis[v] = dis[u] + w;
                    pq.add(new Pair<>(dis[v], v));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();

        List<List<Pair<Integer, Integer>>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            a.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u, v, w;
            u = sc.nextInt();
            v = sc.nextInt();
            w = sc.nextInt();
            a.get(u).add(new Pair<>(v, w));
        }

        int s, t;
        s = sc.nextInt();
        t = sc.nextInt();

        int[] dis = new int[n + 1];
        Arrays.fill(dis, INF);
        dijkstra(a, s, dis);

        if (dis[t] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dis[t]);
        }
        sc.close();
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}

/*Problem: Shortest Path between 2 nodes on a directed graph with non-negative weights
Description
Given a directed graph G = (V,E) in which V = {1,2,...,n) is the set of nodes. Each arc (u,v) has a non-negative weight w(u,v). Given two nodes s and t of G. Find the shortest path from s to t on G.
Input
Line 1: contains two integers n and m which are the number of nodes and the number of arcs of G (1 <= n <= 100000)
Line i + 1(i = 1,2,...,m): contains 3 integers u, v, w in which w is the weight of arc(u,v) (0 <= w <= 100000)
Line m+2: contains two integers s and t
Output
Write the weight of the shortest path found or write -1 if no path from s to t was found
Example
Input
5 7
2 5 87
1 2 97
4 5 78
3 1 72
1 4 19
2 3 63
5 1 18
1 5

Output
97 */