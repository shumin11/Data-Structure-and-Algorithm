import java.util.List;

public class maximumAmount {
    // from back to front!
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        dp[0][0][0] = coins[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (i == 0 && j == 0) continue;
                    dp[i][j][k] = Integer.MIN_VALUE;
                    if (i - 1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], coins[i][j] + dp[i - 1][j][k]);
                        if (k > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k - 1]);
                        }
                    }                 
                    if (j - 1 >= 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], coins[i][j] + dp[i][j-1][k]);
                        if (k > 0) {
                            dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j-1][k - 1]);
                        }
                    }                    
                }
            }
        }
        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }

    public static void main(String[] args) {
        int[][] coins = {
            {0, 1, -1},
            {1, -2, 3},
            {2, -1, 4}
        };
        maximumAmount sol = new maximumAmount();
        System.out.println(sol.maximumAmount(coins)); // 24       
    }
}