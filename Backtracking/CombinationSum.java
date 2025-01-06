import java.util.ArrayList;
import java.util.List;

// Draw two different decision trees for the following two backtracking problems:
public class CombinationSum{
    // from back to front!
    // O(N^(T/M), N be the number of candidates, T be the target value, and M be the minimal value among the candidates.)
    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        backtrack(nums, target, results, currList, 0, 0);
        return results;
    }

    private static void backtrack(int[] nums, int target, List<List<Integer>> results, List<Integer> currList, int start, int total) {
        if (total == target) {
            results.add(new ArrayList(currList));
            return;
        }
        if (total > target) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            currList.add(nums[i]);
            backtrack(nums, target, results, currList, i, total + nums[i]);
            currList.remove(currList.size() - 1);
        }
    }

    // Time complexity: O(2^(t/m))
    private void backtrack2(int[] nums, int target, List<Integer> currList, List<List<Integer>> results, int start, int sum) {
        if (sum == target) {
            results.add(new ArrayList(currList));
            return;
        }
        if (start >= nums.length || sum > target) {
            return;
        }
        currList.add(nums[start]);
        backtrack2(nums, target, currList, results, start, sum+nums[start]);
        currList.remove(currList.size() - 1);
        backtrack2(nums, target, currList, results, start + 1, sum);
    }


    public static void main(String[] args) {
        int[] nums = { 2, 3, 6, 7 };
        int target = 7;
        List<List<Integer>> results = combinationSum(nums, target);
        for (List<Integer> result : results) {
            System.out.println(result);
        }            
    }
}