import java.sql.Time;
import java.util.*;

public class ValidSudoku {
    public static boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            HashSet<Character> set = new HashSet<>();
            for (int col = 0; col < 9; col++) {
                char curr = board[row][col];
                if (curr == '.') continue;
                if (set.contains(curr)) {
                    System.out.println(curr);
                    return false;
                }
                set.add(curr);
            }
        }

        for (int col = 0; col < 9; col++) {
            HashSet<Character> setCol = new HashSet<>();
            for (int row = 0; row < 9; row++) {
                char curr = board[row][col];
                if (curr == '.') continue;
                if (setCol.contains(curr)) {
                    return false;
                }
                setCol.add(curr);
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                HashSet<Character> setBox = new HashSet<>();
                for (int i = row; i < 3+row; i++) {
                    for (int j = col; j < 3+col; j++) {
                        char boxChar = board[i][j];
                        if (boxChar == '.') continue;
                        if (setBox.contains(boxChar)) {
                            return false;
                        }
                        setBox.add(boxChar);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        System.out.println(isValidSudoku(board));                 
    }
}