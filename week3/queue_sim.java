package week3;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue_sim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        Queue<Integer> q = new LinkedList<>();
        String command;

        command = sc.next();

        while (!command.equals("#")) {
            if (command.equals("PUSH")) {
                num = sc.nextInt();
                q.add(num);
            } else {
                if (q.isEmpty()) {
                    System.out.println("NULL");
                } else {
                    System.out.println(q.peek());
                    q.remove();
                }
            }
            command = sc.next();
        }
    }
}


/*Problem: Simulation Queue
Description
Perform a sequence of operations over a queue, each element is an integer:
PUSH v: push a value v into the queue
POP: remove an element out of the queue and print this element to stdout (print NULL if the queue is empty)
Input
Each line contains a command (operration) of type
PUSH  v
POP
Output
Write the results of POP operations (each result is written in a line)
Example
Input
PUSH 1
PUSH 2
PUSH 3
POP
POP
PUSH 4
PUSH 5
POP
#
Output
1
2
3

Input
PUSH 1
POP
POP
PUSH 4
POP
#
Output
1
NULL
4 */