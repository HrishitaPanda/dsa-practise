import java.util.Scanner;

public class SudokuSolver {

    // Function to solve Sudoku
    public static boolean solveSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    // Try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, row, col, num)) {

                            board[row][col] = num;

                            if (solveSudoku(board))
                                return true;

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    // Check whether placing num is valid
    public static boolean isSafe(char[][] board, int row, int col, char num) {

        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num)
                return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        // Check 3x3 box
        int startRow = row - row % 3;
        int startCol = col - col % 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    // Print Sudoku board
    public static void printBoard(char[][] board) {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        System.out.println("========== Sudoku Solver ==========\n");

        System.out.println("Enter the Sudoku board.");
        System.out.println("Use '.' for empty cells.");
        System.out.println("Enter 9 rows, each containing 9 characters separated by spaces.\n");

        System.out.println("Example:");
        System.out.println("5 3 . . 7 . . . .");
        System.out.println("6 . . 1 9 5 . . .");
        System.out.println(". 9 8 . . . . 6 .");
        System.out.println("8 . . . 6 . . . 3");
        System.out.println("4 . . 8 . 3 . . 1");
        System.out.println("7 . . . 2 . . . 6");
        System.out.println(". 6 . . . . 2 8 .");
        System.out.println(". . . 4 1 9 . . 5");
        System.out.println(". . . . 8 . . 7 9\n");

        System.out.println("Enter the Sudoku:");

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                board[i][j] = sc.next().charAt(0);
            }
        }

        if (solveSudoku(board)) {

            System.out.println("\nSolved Sudoku:\n");

            printBoard(board);

        } else {

            System.out.println("\nNo solution exists.");
        }

        sc.close();
    }
}