import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class NumbeOfIslands {
    // from back to front!
    public static int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && dfs(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {
            return false;
        }
        grid[row][col] = '0';
        dfs(grid, row, col + 1);
        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col - 1);
        return true;
    }
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        System.out.println("Number of islands: " + numIslands(grid));
               
    }
}