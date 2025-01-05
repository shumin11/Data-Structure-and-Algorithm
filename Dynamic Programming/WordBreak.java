import java.util.List;

public class WordBreak {
    // from back to front!
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= n && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i] == true) {
                    break;
                }
            }
        }
        return dp[0];

    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        System.out.println("Result: "
                + wordBreak(s, wordDict));       
    }
}