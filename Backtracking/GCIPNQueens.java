import java.util.*;
public class Main{

    // This solution uses a stack to store the solution.
    // Stack will hold only the column values and one solution
    // will be stored in the stack at a time.
    public static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
        // we need to check with all queens
        // in current solution
        int oldRow =0, oldCol = 0, diagonalOffset = 0;
        for (int i = 0; i<proposedRow; ++i) {
            oldRow = i;
            oldCol = solution.get(i);
            diagonalOffset = proposedRow - oldRow;
            // oldCol == proposedCol --> Checks if there are any queens in the proposed column
            // oldCol == proposedCol - diagonalOffset --> Checks if there are any queens on the bottom left diagonal to the proposed place
            // oldCol == proposedCol + diagonalOffset --> Checks if there are any queens on the bottom right diagonal to the proposed place
            if (oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol + diagonalOffset) {
                return false;
            }
        }
        return true;
    }


    public static void nQueensSolver(int n, List<Integer> solution, int row, List<List<Integer>> results) {
        if (row == n) {
            results.add(solution);
            return;
        }

        for (int i = 0; i<n; i++) {
            boolean valid = isValidMove(row, i, solution);
            if (valid) {
                solution.set(row, i);
                nQueensSolver(n, solution, row + 1, results);
            } 
        }
    }

    // Function to solve N-Queens problem
    public static int solveNQueensRecursive(int n) {
        // GCIP CODE SOLUTION RECURSIVE

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> solution = new ArrayList<Integer> (Collections.nCopies(n, -1));
        nQueensSolver(n, solution, 0, results);
        return results.size();
    }



    public static int solveNQueensIterative(int n) {
        // GCIP CODE SOLUTION ITERATIVE

        /*

        1. start at [0,0] place a queen
        2. we know row is occupied, so check next row
        3. look at [1,0] - check column and diagonals for queens
        4. if none, place it and go to next row
        5. else, check next column
        6. if next column is out of bounds and no queen placed remove it
        6a. backtrack to queen before this and move her over
        7. start at [0,1] place a queen
        ... continue

        */

        List<List<Integer>> results = new ArrayList<List<Integer>> ();
        List<Integer> solution = new ArrayList<Integer> (Collections.nCopies(n, -1));
        Stack<Integer> solStack = new Stack<Integer> ();
        //
        // for (int i = 0; i<n; ++i) {
        // solution.add(-1);
        // }
        int row = 0;
        int col = 0;
        while (row<n) {
            // For the current state of the solution, check if a queen can be placed in any
            // column of this row
            while (col<n) {
                if (isValidMove(row, col, solution)) {
                    // If this is a safe position for a queen (a valid move), save
                    // it to the current solution on the stack...
                    solStack.push(col);
                    solution.set(row, col);
                    row++;
                    col = 0;
                    // ... and move on to checking the next row (breaking out of the inner loop)
                    break;
                }
                col++;
            }
            // If we have checked all the columns
            if (col == n) {
                // If we are working on a solution
                if (!solStack.empty()) {
                    // Backtracking, as current row does not offer a safe spot given the previous
                    // move
                    // So, get set up to check the previous row with the next column
                    col = solStack.peek() + 1;
                    solStack.pop();
                    row--;
                } else {
                    // If we have backtracked all the way and found this to be a dead-end,
                    // break out of the inner loop as no more solutions exist
                    break;
                }
            }
            // If we have found a safe spot for a queen in each of the rows
            if (row == n) {
                // Add the solution into results
                results.add(new ArrayList<Integer> (solution));

                // Backtrack to find the next solution
                row--;
                col = solStack.peek() + 1;
                solStack.pop();
            }
        }
        return results.size();
    }
}