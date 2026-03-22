/**
 * Problem: Fibonacci Number
 * The Fibonacci sequence: F(0) = 0, F(1) = 1,
 * F(n) = F(n-1) + F(n-2) for n > 1.
 * Given n, return F(n).
 *
 * Example:
 *   F(0)=0, F(1)=1, F(2)=1, F(3)=2, F(4)=3, F(5)=5, F(10)=55
 *
 * Three approaches demonstrated:
 *   1. Naive recursion         — O(2^n) time, O(n) space
 *   2. Memoization (top-down)  — O(n)   time, O(n) space
 *   3. Tabulation (bottom-up)  — O(n)   time, O(n) space
 *   4. Space-optimized DP      — O(n)   time, O(1) space
 */
public class Fibonacci {

    // 1. Naive recursion (exponential — avoid for large n)
    public int fibRecursive(int n) {
        if (n <= 1) return n;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    // 2. Memoization (top-down DP)
    public int fibMemo(int n) {
        int[] memo = new int[n + 1];
        return memoHelper(n, memo);
    }

    private int memoHelper(int n, int[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = memoHelper(n - 1, memo) + memoHelper(n - 2, memo);
        return memo[n];
    }

    // 3. Tabulation (bottom-up DP)
    public int fibTabulation(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // 4. Space-optimized DP (constant space)
    public int fibOptimized(int n) {
        if (n <= 1) return n;
        int prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        Fibonacci solution = new Fibonacci();
        int[] testCases = {0, 1, 2, 5, 10};
        int[] expected   = {0, 1, 1, 5, 55};

        System.out.println("n\tRecursive\tMemo\tTabulation\tOptimized");
        for (int i = 0; i < testCases.length; i++) {
            int n = testCases[i];
            System.out.printf("%d\t%d\t\t%d\t%d\t\t%d%n",
                n,
                solution.fibRecursive(n),
                solution.fibMemo(n),
                solution.fibTabulation(n),
                solution.fibOptimized(n));
        }
    }
}
