import java.sql.Time;
import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int tmp = target - numbers[i];
            if (mp.containsKey(tmp)) {
                return new int[] { mp.get(tmp), i + 1 };
            }
            mp.put(numbers[i], i + 1);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum ts = new TwoSum();
        int[] numbers = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = ts.twoSum(numbers, target);
        for (int i : result) {
            System.out.println(i);
        }                 
    }
}