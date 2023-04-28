import java.util.*;
public class NQueens {
    private int N;
    private int[] rows;

    public NQueens(int N) {
        this.N = N;
        rows = new int[N];
    }

    public void solve() {
        if (placeQueens(0)) {
            printSolution();
        } else {
            System.out.println("No solution exists");
        }
    }

    private boolean placeQueens(int row) {
        if (row == N) {
            return true;  // All queens have been placed
        }
        for (int col = 0; col < N; col++) {
            if (isValid(row, col)) {
                rows[row] = col;  // Place queen in this column
                if (placeQueens(row+1)) {
                    return true;
                }
                // Backtrack: remove queen from this column
                rows[row] = 0;
            }
        }
        return false;  // Could not place queen in this row
    }

    private boolean isValid(int row, int col) {
        // Check if the queen can be placed in this column without attacking other queens
        for (int i = 0; i < row; i++) {
            if (rows[i] == col || rows[i] - i == col - row || rows[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (rows[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.print("Enter the number of queens: ");
        int n = key.nextInt();
        NQueens problem = new NQueens(n);
        problem.solve();
        key.close();
    }
}
