import java.sql.Time;
import java.util.*;

public class Merge {
    // Time Complexity: O(n+m), where n is the length of nums1 and m is the length of nums2.
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        for (int i = m + n -1 ; i >= 0; i--) {
            if (p2 < 0) {
                break;
            }
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        for (int i = 0; i < m; i++) {
            nums1Copy[i] = nums1[i];
        };
        int p1 = 0, p2 = 0;
        for (int i = 0; i < m + n; i++) {
            if ((p1 < m && p2 < n && nums1Copy[p1] < nums2[p2]) || (p2 >= n)) {
                nums1[i] = nums1Copy[p1];
                p1++;
            } else if (p2 < n) {
                nums1[i] = nums2[p2];
                p2++;
            }
        }

    }
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };
        merge.merge(nums1, 3, nums2, 3);
        for (int num : nums1) {
            System.out.println(num);
        }
    }
}