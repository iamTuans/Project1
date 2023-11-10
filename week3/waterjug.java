package week3;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class State {
    int x, y;

    public State(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class waterjug {
    public static int solve(int a, int b, int c) {
        Queue<State> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new State(0, 0));
        visited.add("0-0");
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                State s = q.poll();
                if (s.x == c || s.y == c || s.x + s.y == c) {
                    return steps;
                }
                if (!visited.contains(a + "-" + s.y)) {
                    q.add(new State(a, s.y));
                    visited.add(a + "-" + s.y);
                }
                if (!visited.contains(s.x + "-" + b)) {
                    q.add(new State(s.x, b));
                    visited.add(s.x + "-" + b);
                }
                if (!visited.contains("0-" + s.y)) {
                    q.add(new State(0, s.y));
                    visited.add("0-" + s.y);
                }
                if (!visited.contains(s.x + "-0")) {
                    q.add(new State(s.x, 0));
                    visited.add(s.x + "-0");
                }
                if (s.x + s.y >= b && !visited.contains((s.x - (b - s.y)) + "-" + b)) {
                    q.add(new State(s.x - (b - s.y), b));
                    visited.add((s.x - (b - s.y)) + "-" + b);
                } else if (s.x + s.y < b && !visited.contains("0-" + (s.x + s.y))) {
                    q.add(new State(0, s.x + s.y));
                    visited.add("0-" + (s.x + s.y));
                }
                if (s.x + s.y >= a && !visited.contains(a + "-" + (s.y - (a - s.x)))) {
                    q.add(new State(a, s.y - (a - s.x)));
                    visited.add(a + "-" + (s.y - (a - s.x)));
                } else if (s.x + s.y < a && !visited.contains((s.x + s.y) + "-0")) {
                    q.add(new State(s.x + s.y, 0));
                    visited.add((s.x + s.y) + "-0");
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b, c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(solve(a, b, c));
        sc.close();
    }
}
