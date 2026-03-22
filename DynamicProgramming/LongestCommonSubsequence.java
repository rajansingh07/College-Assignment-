/**
 * Problem: Longest Common Subsequence (LCS)
 * Given two strings text1 and text2, return the length of their
 * longest common subsequence. A subsequence is a sequence that can be
 * derived from a string by deleting some characters without changing the
 * relative order.
 *
 * Example:
 *   text1 = "abcde", text2 = "ace"
 *   LCS    = "ace"  → length 3
 *
 *   text1 = "abc",   text2 = "abc"
 *   LCS    = "abc"  → length 3
 *
 *   text1 = "abc",   text2 = "def"
 *   LCS    = ""     → length 0
 *
 * Approach: 2-D DP table — O(m*n) time, O(m*n) space
 *
 * Recurrence:
 *   dp[i][j] = dp[i-1][j-1] + 1            if text1[i-1] == text2[j-1]
 *            = max(dp[i-1][j], dp[i][j-1]) otherwise
 */
public class LongestCommonSubsequence {

    public int lcs(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();

        System.out.println("Test 1: " + solution.lcs("abcde", "ace"));  // Expected: 3
        System.out.println("Test 2: " + solution.lcs("abc", "abc"));    // Expected: 3
        System.out.println("Test 3: " + solution.lcs("abc", "def"));    // Expected: 0
        System.out.println("Test 4: " + solution.lcs("AGGTAB", "GXTXAYB")); // Expected: 4
    }
}
