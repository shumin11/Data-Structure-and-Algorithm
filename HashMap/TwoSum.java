import java.util.*;

public class TwoSum {   
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                int index = map.get(complement);
                return new int[]{index, i};
            }
            map.put(nums[i], i);
        }
        return new int[2];      
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        TwoSum sol = new TwoSum();
        int[] result = sol.twoSum(nums, target);
        for (int i : result) {
            System.out.print(i + " ");
        }             
    }
}