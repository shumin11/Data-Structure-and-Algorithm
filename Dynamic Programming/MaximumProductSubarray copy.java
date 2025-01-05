public class MaximumProductSubarray {

    public static int maxProduct(int[] nums) {
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int max = maxProduct;
            int min = minProduct;

            maxProduct = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            minProduct = Math.min(Math.min(max * nums[i], min * nums[i]), nums[i]);
            result = Math.max(result, maxProduct);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        int[] nums2 = { 1, 2, -3, 4 };
        System.out.println("Maximum product subarray is: " + maxProduct(nums));
        System.out.println("Maximum product subarray is: " + maxProduct(nums2));
    }
}