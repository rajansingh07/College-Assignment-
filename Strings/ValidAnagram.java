import java.util.Arrays;

/**
 * Problem: Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s,
 * and false otherwise.
 *
 * Example:
 *   Input:  s = "anagram", t = "nagaram"
 *   Output: true
 *
 *   Input:  s = "rat", t = "car"
 *   Output: false
 *
 * Approach: Character frequency count — O(n) time, O(1) space (fixed 26-char alphabet)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int freq : count) {
            if (freq != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidAnagram solution = new ValidAnagram();

        System.out.println("Test 1: " + solution.isAnagram("anagram", "nagaram")); // Expected: true
        System.out.println("Test 2: " + solution.isAnagram("rat", "car"));         // Expected: false
        System.out.println("Test 3: " + solution.isAnagram("listen", "silent"));   // Expected: true
        System.out.println("Test 4: " + solution.isAnagram("ab", "a"));            // Expected: false
    }
}
