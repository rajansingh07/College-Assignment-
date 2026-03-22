/**
 * Problem: Detect Cycle in a Linked List
 * Given the head of a linked list, determine if the list contains a cycle.
 * A cycle exists if some node can be reached again by continuously following
 * the next pointer.
 *
 * Example:
 *   Input:  3 -> 2 -> 0 -> -4 (tail connects back to index 1)
 *   Output: true
 *
 * Approach: Floyd's Tortoise and Hare (fast/slow pointers) — O(n) time, O(1) space
 */
public class DetectCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycle solution = new DetectCycle();

        // Build list with cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // cycle
        System.out.println("Test 1 (cycle):    " + solution.hasCycle(head1)); // Expected: true

        // Build list without cycle: 1 -> 2 -> 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        System.out.println("Test 2 (no cycle): " + solution.hasCycle(head2)); // Expected: false

        // Single node, no cycle
        ListNode head3 = new ListNode(1);
        System.out.println("Test 3 (single):   " + solution.hasCycle(head3)); // Expected: false
    }
}
