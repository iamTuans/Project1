package week3;
import java.util.*;

class Node {
    int key;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class bts_insertion {
    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else if (key > root.key) {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = null;
        String command;
        while (true) {
            command = sc.next();
            if (command.equals("#")) {
                break;
            } else if (command.equals("insert")) {
                int k = sc.nextInt();
                root = insert(root, k);
            }
        }
        preOrder(root);
        sc.close();
    }
}
