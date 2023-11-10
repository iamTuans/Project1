package week3;
import java.util.Scanner;

class Sequence {
    int value;
    Sequence next;

    Sequence(int value) {
        this.value = value;
        this.next = null;
    }
}

public class linked_list_manipulation {
    static void display(Sequence s) {
        while (s != null) {
            System.out.print(s.value + " ");
            s = s.next;
        }
    }

    static void addLast(Sequence[] s, int k) {
        Sequence temp = s[0];
        while (temp != null) {
            if (temp.value == k) {
                return;
            }
            temp = temp.next;
        }

        if (s[0] == null) {
            s[0] = new Sequence(k);
        } else {
            temp = s[0];

            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Sequence(k);
        }
    }

    static void addAfter(Sequence s, int u, int v) {
        Sequence temp = s;
        while (s != null) {
            if (s.value == u) {
                return;
            }
            s = s.next;
        }
        s = temp;

        while (s != null && s.value != v) {
            if (s.value == u) return;
            s = s.next;
        }
        if (s == null) {
            return;
        }
        temp = new Sequence(u);
        temp.next = s.next;
        s.next = temp;
    }

    static void addBefore(Sequence s, int u, int v) {
        if (s == null) return;

        while (s.next != null && s.next.value != v) {
            if (s.value == u) return;
            s = s.next;
        }
        Sequence temp = new Sequence(u);
        temp.next = s.next;
        s.next = temp;
    }

    static void remove(Sequence s, int k) {
        while (s != null && s.next != null) {
            while (s.next != null && s.next.value == k) {
                s.next = s.next.next;
            }
            s = s.next;
        }
    }

    static Sequence reverse(Sequence s) {
        Sequence tempL, tempR;

        tempL = s;
        tempR = s.next;
        s.next = null;
        while (tempR != null) {
            s = tempR;
            tempR = tempR.next;
            s.next = tempL;
            tempL = s;
        }
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command;
        int n, a;
        Sequence[] head = new Sequence[1];

        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            a = sc.nextInt();

            addLast(head, a);
        }

        command = sc.next();
        while (!command.equals("#")) {
            if (command.equals("addlast")) {
                int k = sc.nextInt();
                addLast(head, k);
            } else if (command.equals("addfirst")) {
                int k = sc.nextInt();
                Sequence temp = new Sequence(k);
                temp.next = head[0];
                head[0] = temp;
            } else if (command.equals("addafter")) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                addAfter(head[0], u, v);
            } else if (command.equals("addbefore")) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                if (head[0] != null && head[0].value == v) {
                    Sequence temp = new Sequence(u);
                    temp.next = head[0];
                    head[0] = temp;
                } else addBefore(head[0], u, v);
            } else if (command.equals("remove")) {
                int k = sc.nextInt();
                while (head[0].value == k) {
                    head[0] = head[0].next;
                }
                remove(head[0], k);
            } else if (command.equals("reverse")) {
                if (head[0] != null) {
                    head[0] = reverse(head[0]);
                }
            }

            command = sc.next();
        }

        display(head[0]);
        sc.close();
    }
}

/*Problem: Linked List Manipulation
Description
Viết chương trình thực hiện công việc sau:
Xây dựng danh sách liên kết với các khóa được cung cấp ban đầu là dãy a1, a2,...,an
sau đó thực hiện các thao tác trên danh sách bao gồm: thêm 1 phần tử vào đầu, vào cuối danh sách, hoặc vào trước, vào sau 1 phần tử nào đó trong danh sách, hoặc loại bỏ 1 phần tử nào đó trong danh sách

Input
Dòng 1: ghi số nguyên dương n (1 <= n <= 1000)
Dòng 2: ghi các số nguyên dương a1,a2,...,an
Các dòng tiếp theo lần lượt là các lệnh để thao tác (kết thúc bởi ký hiệu #) với các loại sau:
addlast  k: thêm phần tử có key bằng k vào cuối danh sách (nếu k chưa tồn tại)
addfirst  k: thêm phần tử có key bằng k vào đầu danh sách (nếu k chưa tồn tại)
addafter  u  v: thêm phần tử có key bằng u vào sau phần tử có key bằng v trên danh sách (nếu v đã tồn tại trên danh sách và u chưa tồn tại)
addbefore  u  v: thêm phần tử có key bằng  u vào trước phần tử có key bằng v trên danh sách (nếu v đã tồn tại trên danh sách và u của tồn tại)
remove  k: loại bỏ phần tử có key bằng k khỏi danh sách
reverse: đảo ngược thứ tự các phần tử của danh sách (không được cấp phát mới các phần tử, chỉ được thay đổi mối nối liên kết)
Output
Ghi ra dãy khóa của danh sách thu được sau 1 chuỗi các lệnh thao tác đã cho

Example
Input
5
5 4 3 2 1
addlast 3
addlast 10
addfirst 1
addafter 10 4
remove 1
#

Output
5 4 3 2 10  */