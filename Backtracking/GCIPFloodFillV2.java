import java.util.*;

public class FloodFill {


    public static int[][] floodFill(int[][] grid, int sr, int sc, int target) {
        if(grid[sr][sc] == target) {
            return grid;
        }
        // dfs fill
        int fillMe = grid[sr][sc];
        grid[sr][sc] = target;
        floodFillHelper(grid, sr, sc, target, fillMe);
        return grid;
    }

    public static void floodFillHelper(int[][] grid, int sr, int sc, int target, int fillMe) {
        int[][] DIRS = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        int N = grid.length;
        int M = grid[0].length;

        for(int[] dir : DIRS) {
            int nextRow = sr + dir[0];
            int nextCol = sc + dir[1];
            if(nextRow < N && nextRow >= 0 && nextCol < M && nextCol >= 0 && grid[nextRow][nextCol] == fillMe) {
                grid[nextRow][nextCol] = target;
                floodFillHelper(grid, nextRow, nextCol, target, fillMe);
            }
        }
    }

}
