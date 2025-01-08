import java.util.*;

public class WordSearch{
    
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                boolean[][] visited = new boolean[m][n];
                if (dfs(board, word, row, col, visited, 0)) {
                    return true;
                }
            }
        }  
        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int col, boolean[][] visited, int index) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length ||
            board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean res = dfs(board, word, row + 1, col, visited, index + 1) ||
                      dfs(board, word, row, col + 1, visited, index + 1) ||
                      dfs(board, word, row - 1, col, visited, index + 1) ||
                      dfs(board, word, row, col - 1, visited, index + 1);
        visited[row][col] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        System.out.println(exist(board, word)); // true
                  
    }
}