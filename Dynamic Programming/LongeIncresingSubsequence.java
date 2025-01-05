import java.util.List;

public class LongeIncresingSubsequence{
    
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {9,1,4,2,3,3,7};
        System.out.println("Length of Longest Increasing Subsequence is: " + lengthOfLIS(nums));    
    }
}