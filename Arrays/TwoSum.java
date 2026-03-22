import java.util.HashMap;

/**
 * Problem: Two Sum
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers that add up to target.
 *
 * Example:
 *   Input:  nums = [2, 7, 11, 15], target = 9
 *   Output: [0, 1]  (nums[0] + nums[1] == 9)
 *
 * Approach: Hash Map — O(n) time, O(n) space
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum solution = new TwoSum();

        int[] nums1 = {2, 7, 11, 15};
        int[] result1 = solution.twoSum(nums1, 9);
        System.out.println("Test 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]

        int[] nums2 = {3, 2, 4};
        int[] result2 = solution.twoSum(nums2, 6);
        System.out.println("Test 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 2]

        int[] nums3 = {3, 3};
        int[] result3 = solution.twoSum(nums3, 6);
        System.out.println("Test 3: [" + result3[0] + ", " + result3[1] + "]"); // Expected: [0, 1]
    }
}
