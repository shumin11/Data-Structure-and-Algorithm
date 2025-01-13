import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {   
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        HashMap<Character, Integer> map = new HashMap();
        int result = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            map.put(c, i);
            result = Math.max(result, i - left + 1);
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));        
    }
}