/**
 * Problem: Reverse a String
 * Write a function that reverses a string. The input string is given
 * as an array of characters. Do it in-place with O(1) extra space.
 *
 * Example:
 *   Input:  ['h','e','l','l','o']
 *   Output: ['o','l','l','e','h']
 *
 * Approach: Two-pointer swap — O(n) time, O(1) space
 */
public class ReverseString {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseString solution = new ReverseString();

        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s1);
        System.out.println("Test 1: " + new String(s1)); // Expected: olleh

        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(s2);
        System.out.println("Test 2: " + new String(s2)); // Expected: hannaH

        char[] s3 = {'A'};
        solution.reverseString(s3);
        System.out.println("Test 3: " + new String(s3)); // Expected: A
    }
}
