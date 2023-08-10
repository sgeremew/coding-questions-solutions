import java.util.*;
public class Main{
/*

n=4

    0  0  0  0       0  X  0  0       0  0  X  0
    0  0  0  0  --\  0  0  0  X  --\  X  0  0  0
    0  0  0  0  --/  X  0  0  0  --/  0  0  0  X
    0  0  0  0       0  0  X  0       0  X  0  0

result = 2; 2 ways to place n queens on an nxn board


loop through columns from 0 -> n-1
place queen at [0,0]
go to next row
loop through columns looking for valid placement
    - if found repeat above steps
    - else backtrack (taking current queen off and go back to previous step)
end of loop backtrack
if no more columns then done
if valid placement in last row - increment solved count

*/

    /**  SAM SOLUTION BACKTRACKING */
    public static int solveNQueens(int n) {
        // initialize an empty board
        int[][] board = new int[n][n];
        ArrayList<Integer> solvedCount = new ArrayList<>();
        nQueensHelper(board, 0, solvedCount);
        return solvedCount.size();
    }

    public static void nQueensHelper(int[][] board, int row, ArrayList<Integer> solvedCount) {
        // printBoard(board);
        if(row >= board.length) {
            solvedCount.add(1);
            return;
        }

        for(int col = 0; col < board[0].length; col++) {
            if(isValid(board, row, col)) {
                board[row][col] = '*';
                nQueensHelper(board, row + 1, solvedCount);
            }
            board[row][col] = 0;
        }

        return;
    }

    public static boolean isValid(int[][] board, int row, int col) {
        // valid queen placement?
        // need to look at column above me and the diagonal to the right and left above me
        int diagOffset = 1; // add/subtract from this

        for(int r = row-1; r >= 0; r--) {
            int leftDiag = col - diagOffset;
            int rightDiag = col + diagOffset;

            // column above me
            if(board[r][col] == '*')
                return false;
            // diagonals above me
            if(leftDiag >= 0 && board[r][leftDiag] == '*')
                return false;
            if(rightDiag < board[0].length && board[r][rightDiag] == '*')
                return false;
            diagOffset++;
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] x : board){
            for (int y : x){
                System.out.print(y + " ");
            }
            System.out.println();
        }
        System.out.println("==============\n");
    }

}