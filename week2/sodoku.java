package week2;
import java.util.Scanner;
public class sodoku {
    static final int n = 9;
    static int count = 0;

    static boolean isSafe(int[][] a, int row, int col, int num) {
        for (int x = 0; x < n; x++) {
            if (a[row][x] == num) {
                return false;
            }
        }

        for (int y = 0; y < n; y++) {
            if (a[y][col] == num) {
                return false;
            }
        }

        int sRow = row - (row % 3);
        int sCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i + sRow][j + sCol] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean findEmptyPosition(int[][] a, int[] pos) {
        for (pos[0] = 0; pos[0] < n; pos[0]++) {
            for (pos[1] = 0; pos[1] < n; pos[1]++) {
                if (a[pos[0]][pos[1]] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean solveSudoku(int[][] a) {
        int[] pos = new int[2];
        if (!findEmptyPosition(a, pos)) {
            return true;
        }
        int row = pos[0];
        int col = pos[1];

        for (int num = 1; num <= 9; num++) {
            if (isSafe(a, row, col, num)) {
                a[row][col] = num;

                if (solveSudoku(a)) {
                    count++;
                }

                a[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        solveSudoku(a);
        System.out.println(count);
    }
}
