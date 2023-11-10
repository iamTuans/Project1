package week3;
import java.util.*;
public class stack_sim {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            if (a.equals("PUSH")) {
                int v = sc.nextInt();
                s.push(v);
            } else if (a.equals("POP")) {
                if (s.empty()) {
                    System.out.println("NULL");
                } else {
                    System.out.println(s.peek());
                    s.pop();
                }
            }
        }
        sc.close();
    }
}

/*Problem: Simulation Stack
Description
Perform a sequence of operations over a stack, each element is an integer:
PUSH v: push a value v into the stack
POP: remove an element out of the stack and print this element to stdout (print NULL if the stack is empty)
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
3
2
5 */