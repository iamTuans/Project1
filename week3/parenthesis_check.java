//JAVA 
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings({"unchecked", "deprecation"})

public class parenthesis_check {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(isCorrect(s));
        sc.close();
    }

    private static int isCorrect(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (st.empty()) {
                    return 0;
                }
                char top = st.peek();
                st.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return 0;
                }
            }
        }
        return st.empty() ? 1 : 0;
    }
}
