/**
 * Problem: Maximum Depth of Binary Tree
 * Given the root of a binary tree, return its maximum depth.
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Example:
 *         3
 *        / \
 *       9  20
 *          / \
 *         15   7
 *
 *   Output: 3
 *
 * Approach: Recursive DFS — O(n) time, O(h) space (h = height of tree)
 */
public class MaxDepth {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth  = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    public static void main(String[] args) {
        MaxDepth solution = new MaxDepth();

        // Tree:  3 -> (9, 20 -> (15, 7))
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test 1: " + solution.maxDepth(root1)); // Expected: 3

        // Single node
        TreeNode root2 = new TreeNode(1);
        System.out.println("Test 2: " + solution.maxDepth(root2)); // Expected: 1

        // Empty tree
        System.out.println("Test 3: " + solution.maxDepth(null)); // Expected: 0
    }
}
