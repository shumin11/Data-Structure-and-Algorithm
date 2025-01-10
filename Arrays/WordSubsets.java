import java.sql.Time;
import java.util.*;

public class WordSubsets {
    // Time Complexity: O(A+B), where A and B is the total amount of information in
    // A and B respectively.

    // Space Complexity: O(A.length+B.length).
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> results = new ArrayList<>();
        int[] words2List = new int[26];
        for (String word : words2) {
            int[] curr = new int[26];
            for (char c : word.toCharArray()) {
                curr[c - 'a']++;
                words2List[c - 'a'] = Math.max(words2List[c - 'a'], curr[c - 'a']);
            }
        }
        for (String w : words1) {
            int[] word1 = new int[26];
            for (char wc : w.toCharArray()) {
                word1[wc - 'a']++;
            }
            boolean universe = true;
            for (int i = 0; i < 26; i++) {
                if (word1[i] < words2List[i]) {
                    universe = false;
                }
            }
            if (universe) {
                results.add(w);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        WordSubsets ws = new WordSubsets();
        String[] words1 = { "amazon", "apple", "facebook", "google", "leetcode" };
        String[] words2 = { "e", "o" };
        List<String> results = ws.wordSubsets(words1, words2);
        for (String result : results) {
            System.out.println(result);
        }
                  
    }
}