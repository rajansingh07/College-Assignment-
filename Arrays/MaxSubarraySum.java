/**
 * Problem: Maximum Subarray Sum (Kadane's Algorithm)
 * Given an integer array nums, find the contiguous subarray
 * with the largest sum and return its sum.
 *
 * Example:
 *   Input:  nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
 *   Output: 6  (subarray [4, -1, 2, 1])
 *
 * Approach: Kadane's Algorithm — O(n) time, O(1) space
 */
public class MaxSubarraySum {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSubarraySum solution = new MaxSubarraySum();

        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Test 1: " + solution.maxSubArray(nums1)); // Expected: 6

        int[] nums2 = {1};
        System.out.println("Test 2: " + solution.maxSubArray(nums2)); // Expected: 1

        int[] nums3 = {5, 4, -1, 7, 8};
        System.out.println("Test 3: " + solution.maxSubArray(nums3)); // Expected: 23
    }
}
