import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class MaximumNumberOfFish {
    public static int findMaxFish(int[][] grid) {
        int result = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    int[] curr = new int[1];
                    dfs(grid, i, j, curr, visited);
                    result = Math.max(result, curr[0]);
                }
            }
        }
        return result;        
    }

    public static void dfs(int[][] grid, int r, int c, int[] result, boolean[][] visited) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 0 || visited[r][c] == true) {
            return;
        }
        result[0] += grid[r][c];
        visited[r][c] = true;   
        dfs(grid, r+1, c, result, visited);
        dfs(grid, r, c+1, result, visited);
        dfs(grid, r - 1, c, result, visited);
        dfs(grid, r, c - 1, result, visited);
    }
    public static void main(String[] args) {
        int[][] grid = {
            {0, 1, 1, 0},
            {1, 0, 0, 1},
            {1, 1, 0, 0},
            {0, 0, 1, 1}
        };
        System.out.println(findMaxFish(grid)); // 6       
    }
}