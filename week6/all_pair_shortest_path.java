package week6;
import java.util.*;

public class all_pair_shortest_path {
    static final int INF = Integer.MAX_VALUE;
    
        static void fWs(List<List<Integer>> dis, int n) {
            for (int k = 1; k <= n; k++) {
                for (int i = 1; i <= n; i++) {
                    for (int j = 1; j <= n; j++) {
                        if (dis.get(i).get(k) != INF && dis.get(k).get(j) != INF && dis.get(i).get(k) + dis.get(k).get(j) < dis.get(i).get(j)) {
                            dis.get(i).set(j, dis.get(i).get(k) + dis.get(k).get(j));
                        }
                    }
                }
            }
        }
    
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n, m;
            n = scanner.nextInt();
            m = scanner.nextInt();
    
            List<List<Integer>> dis = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                dis.add(new ArrayList<>(Collections.nCopies(n + 1, INF)));
            }
    
            for (int i = 1; i <= n; i++) {
                dis.get(i).set(i, 0);
            }
    
            for (int i = 0; i < m; i++) {
                int a, b, c;
                a = scanner.nextInt();
                b = scanner.nextInt();
                c = scanner.nextInt();
                dis.get(a).set(b, c);
            }
    
            fWs(dis, n);
    
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dis.get(i).get(j) == INF) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(dis.get(i).get(j) + " ");
                    }
                }
                System.out.println();
            }
    
            scanner.close();
        }
    }
/*Problem: All pair shortest paths
Description
Given a directed graph G = (V, E) in which V = {1, 2, ..., n} is the set of nodes, and w(u,v) is the weight (length) of the arc(u,v). Compute d(u,v) - the length of the shortest path from u to v in G, for all u,v in V.
Input
Line 1: contains 2 positive integers n and m (1 <= n,m <= 10000)
Line i+1 (i = 1, 2, ..., m): contains 3 positive integers u, v, w in which w is the weight of the arc (u,v) (1 <= w <= 1000)
Output
Line i (i = 1, 2, ..., n): wirte the ith row of the matrix d (if there is not any path from node i to node j, then d(i,j) = -1)
Example
Input
4 9 
1 2 9 
1 3 7 
1 4 2 
2 1 1 
2 4 5 
3 4 6 
3 2 2 
4 1 5 
4 2 8
Output
0 9 7 2  
1 0 8 3  
3 2 0 5  
5 8 12 0 */