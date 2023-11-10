package week3;
import java.util.*;

public class family_tree {
    static class Member {
        String name;
        Member child;

        Member(String name) {
            this.name = name;
            this.child = null;
        }

        Member(String name, Member child) {
            this.name = name;
            this.child = child;
        }
    }

    static boolean insert(List<Member> family, String child, String parent) {
        Member temp;

        for (Member value : family) {
            temp = value;

            if (temp.name.equals(parent)) {
                while (temp.child != null) {
                    temp = temp.child;
                }
                temp.child = new Member(child);

                return true;
            }
        }

        return false;
    }

    static int descendant(List<Member> family, String name) {
        int count = 0;
        Member member;

        for (Member value : family) {
            if (value.name.equals(name)) {
                member = value;

                while (member.child != null) {
                    member = member.child;
                    count++;
                    count += descendant(family, member.name);
                }
            }
        }

        return count;
    }

    static int generation(List<Member> family, String name) {
        int count = 0;
        Member temp;

        for (Member value : family) {
            if (value.name.equals(name)) {
                count++;

                int max = 0;
                temp = value;

                while (temp.child != null) {
                    temp = temp.child;
                    int _max = generation(family, temp.name);

                    if (_max > max) max = _max;
                }
                count += max;
            }
        }

        return count;
    }

    static void display(List<Member> family) {
        Member temp;

        for (Member value : family) {
            System.out.print(value.name + ": ");
            temp = value;
            while (temp.child != null) {
                temp = temp.child;
                System.out.print(temp.name + ' ');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Member> family = new ArrayList<>();
        String child, parent;

        child = sc.next();
        while (!child.equals("***")) {
            parent = sc.next();

            if (!insert(family, child, parent)) {
                family.add(new Member(parent, new Member(child)));
            }

            child = sc.next();
        }

        // display(family);

        child = sc.next();
        while (!child.equals("***")) {
            parent = sc.next();

            if (child.equals("descendants")) {
                System.out.println(descendant(family, parent));
            } else {
                System.out.println(generation(family, parent));
            }

            child = sc.next();
        }
        sc.close();
    }
}


/*Problem: Family Tree
Description
Given a family tree represented by child-parent (c,p) relations in which c is a child of p. Perform queries about the family tree:
descendants <name>: return number of descendants of the given <name>
generation <name>: return the number of generations of the descendants of the given <name>

Note that: the total number of people in the family is less than or equal to 10
4
Input
Contains two blocks. The first block contains information about child-parent, including lines (terminated by a line containing ***), each line contains: <child> <parent> where <child> is a string represented the name of the child and <parent> is a string represented the name of the parent. The second block contains lines (terminated by a line containing ***), each line contains two string <cmd> and <param> where <cmd> is the command (which can be descendants or generation) and <param> is the given name of the person participating in the  query.
Output
Each line is the result of a corresponding query.
Example
Input
Peter Newman
Michael Thomas
John David
Paul Mark
Stephan Mark
Pierre Thomas
Mark Newman
Bill David
David Newman
Thomas Mark
***
descendants Newman
descendants Mark
descendants David
generation Mark
***
Output
10
5
2
2 */