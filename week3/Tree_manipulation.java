package week3;
import java.util.Scanner;
class Node {
    int id;
    Node left;
    Node mid;
    Node right;

    Node(int id) {
        this.id = id;
        this.left = null;
        this.mid = null;
        this.right = null;
    }

    Node(int id, Node left, Node mid, Node right) {
        this.id = id;
        this.left = left;
        this.mid = mid;
        this.right = right;
    }
}

public class Tree_manipulation {
    static void makeRoot(Node[] head, int u) {
        head[0] = new Node(u);
    }

    static boolean insert(Node head, int u, int v) {
        if (head == null) return false;
        if (head.id == v) {
            if (head.left == null) {
                head.left = new Node(u);
                return true;
            } else if (head.mid == null) {
                head.mid = new Node(u);
                return true;
            } else if (head.right == null) {
                head.right = new Node(u);
                return true;
            } else if (head.left.id == u || head.mid.id == u || head.right.id == u) {
                return true;
            }
        }
        if (insert(head.left, u, v)) return true;
        if (insert(head.mid, u, v)) return true;
        return insert(head.right, u, v);
    }

    static void preOrder(Node head) {
        if (head == null) return;

        System.out.print(head.id + " ");
        preOrder(head.left);
        preOrder(head.mid);
        preOrder(head.right);
    }

    static void inOrder(Node head) {
        if (head == null) return;

        inOrder(head.left);
        System.out.print(head.id + " ");
        inOrder(head.mid);
        inOrder(head.right);
    }

    static void postOrder(Node head) {
        if (head == null) return;

        postOrder(head.left);
        postOrder(head.mid);
        postOrder(head.right);
        System.out.print(head.id + " ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int u, v;
        Node[] head = new Node[1];
        String command;

        command = sc.next();

        while (!command.equals("*")) {
            if (command.equals("MakeRoot")) {
                u = sc.nextInt();
                makeRoot(head, u);
            } else if (command.equals("Insert")) {
                u = sc.nextInt();
                v = sc.nextInt();
                insert(head[0], u, v);
            } else if (command.equals("PreOrder")) {
                preOrder(head[0]);
                System.out.println();
            } else if (command.equals("InOrder")) {
                inOrder(head[0]);
                System.out.println();
            } else if (command.equals("PostOrder")) {
                postOrder(head[0]);
                System.out.println();
            }

            command = sc.next();
        }
    }
}

/*Problem: Tree manipulation & Traversal
Description
Mỗi nút trên cây có trường id (identifier) là một số nguyên (id của các nút trên cây đôi một khác nhau)
Thực hiện 1 chuỗi các hành động sau đây bao gồm các thao tác liên quan đến xây dựng cây và duyệt cây
· MakeRoot u: Tạo ra nút gốc u của cây
· Insert u v: tạo mới 1 nút u và chèn vào cuối danh sách nút con của nút v (nếu nút có id bằng v không tồn tại hoặc nút có id bằng u đã tồn tại thì không chèn thêm mới)
· PreOrder: in ra thứ tự các nút trong phép duyệt cây theo thứ tự trước
· InOrder: in ra thứ tự các nút trong phép duyệt cây theo thứ tự giữa
· PostOrder: in ra thứ tự các nút trong phép duyệt cây theo thứ tự sau
Dữ liệu: bao gồm các dòng, mỗi dòng là 1 trong số các hành động được mô tả ở trên, dòng cuối dùng là * (đánh dấu sự kết thúc của dữ liệu).
Kết quả: ghi ra trên mỗi dòng, thứ tự các nút được thăm trong phép duyệt theo thứ tự trước, giữa, sau của các hành động PreOrder, InOrder, PostOrder tương ứng đọc được từ dữ liệu đầu vào
Ví dụ
Dữ liệu
MakeRoot 10
Insert 11 10
Insert 1 10
Insert 3 10
InOrder
Insert 5 11
Insert 4 11
Insert 8 3
PreOrder
Insert 2 3
Insert 7 3
Insert 6 4
Insert 9 4
InOrder
PostOrder
*
Kết quả
11 10 1 3
10 11 5 4 1 3 8
5 11 6 4 9 10 1 8 3 2 7
5 6 9 4 11 1 8 2 7 3 10 */