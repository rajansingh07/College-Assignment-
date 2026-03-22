import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: Binary Tree Traversals
 * Given the root of a binary tree, return the nodes in:
 *   1. Inorder   (Left → Root → Right)
 *   2. Preorder  (Root → Left → Right)
 *   3. Postorder (Left → Right → Root)
 *   4. Level-order (BFS)
 *
 * Example tree:
 *         1
 *        / \
 *       2   3
 *      / \
 *     4   5
 *
 * Inorder:    [4, 2, 5, 1, 3]
 * Preorder:   [1, 2, 4, 5, 3]
 * Postorder:  [4, 5, 2, 3, 1]
 * Level-order:[1, 2, 3, 4, 5]
 *
 * Approach: Recursive DFS / Iterative BFS — O(n) time, O(n) space
 */
public class BinaryTreeTraversals {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

    // Inorder: Left → Root → Right
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Preorder: Root → Left → Right
    public void preorder(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder: Left → Right → Root
    public void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // Level-order (BFS)
    public void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTreeTraversals solution = new BinaryTreeTraversals();

        // Build tree:
        //       1
        //      / \
        //     2   3
        //    / \
        //   4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.print("Inorder:     "); solution.inorder(root);     System.out.println(); // 4 2 5 1 3
        System.out.print("Preorder:    "); solution.preorder(root);    System.out.println(); // 1 2 4 5 3
        System.out.print("Postorder:   "); solution.postorder(root);   System.out.println(); // 4 5 2 3 1
        System.out.print("Level-order: "); solution.levelOrder(root);  System.out.println(); // 1 2 3 4 5
    }
}
