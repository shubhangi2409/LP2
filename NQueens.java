import java.util.*;

public class NQueens {

    static int N; // Board size

    // Print the board
    static void printSolution(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1)
                    System.out.print("Q ");
                else
                    System.out.print(". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if queen can be placed safely
    static boolean isSafe(int[][] board, int row, int col) {

        // Check left side of current row
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal
        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive function to solve N-Queens
    static boolean solveNQUtil(int[][] board, int col) {

        // All queens placed
        if (col >= N)
            return true;

        // Try placing queen in each row
        for (int i = 0; i < N; i++) {

            if (isSafe(board, i, col)) {

                board[i][col] = 1; // Place queen

                // Recur for next column
                if (solveNQUtil(board, col + 1))
                    return true;

                // BACKTRACK
                board[i][col] = 0;
            }
        }

        return false;
    }

    static void solveNQ() {

        int[][] board = new int[N][N];

        if (!solveNQUtil(board, 0)) {
            System.out.println("Solution does not exist");
            return;
        }

        printSolution(board);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take board size input from user
        System.out.print("Enter the value of N: ");
        N = sc.nextInt();

        solveNQ();

        sc.close();
    }
}