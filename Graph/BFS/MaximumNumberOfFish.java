import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

public class MaximumNumberOfFish {
    private static int[] directions1 = new int[] {0, 0, 1, -1};
    private static int[] directions2 = new int[] {1, -1, 0, 0};
    
    public static int findMaxFish(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    result = Math.max(result, bfs(grid, i, j));
                }
            }
        }
        return result;        
    }

    public static int bfs(int[][] grid, int r, int c) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[] {r, c});
        int result = 0;
        

        while (!queue.isEmpty()) {
            int[] currPosition = queue.poll();
            int row = currPosition[0];
            int col = currPosition[1];
            result += grid[row][col];
            grid[row][col] = 0;
            
            for (int i = 0; i < 4; i++) {
                int newRow = row + directions1[i];
                int newCol = col + directions2[i];
                if (newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && grid[newRow][newCol] != 0) {
                    queue.add(new int[] {newRow, newCol});
                }
            }
        }
        return result;
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