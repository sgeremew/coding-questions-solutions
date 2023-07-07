import java.util.*;
class WordSearch {

    // Tip: You may use some of the code templates provided
    // in the support files
    public static boolean wordSearch(char[][] grid, String word) {
        // Write your code here
        
        int M = grid.length; // rows
        int N = grid[0].length; // cols

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(dfs(grid, word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] grid, String word, int i, int j) {
        // base case 1: word is finished
        if(word.length() == 0) {
            return true;
        }

        // base case 2: cell is not valid
        // - out of bounds OR does not match next char in word
        if(i < 0 || j < 0 
            || i >= grid.length || j >= grid[0].length 
            || grid[i][j] != word.charAt(0)) {
            return false;
        }

        // mark cell as visited
        grid[i][j] = '*';

        // used for dfs result
        boolean result = false;

        // continue down path
        int[][] offsets = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int[] offset : offsets) {

            result = dfs(grid, word.substring(1), i + offset[0], j + offset[1]);

            // if result is true than finish
            if (result) {
                break;
            }

        }

        // backtracking
        grid[i][j] = word.charAt(0);


        return result;
    }
}

