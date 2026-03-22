/**
 * Problem: Reverse a Linked List
 * Given the head of a singly linked list, reverse the list and return
 * the reversed list's head.
 *
 * Example:
 *   Input:  1 -> 2 -> 3 -> 4 -> 5 -> null
 *   Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * Approach: Iterative with three pointers — O(n) time, O(1) space
 */
public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    private static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        sb.append(" -> null");
        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Build list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before: " + listToString(head));
        head = solution.reverseList(head);
        System.out.println("After:  " + listToString(head)); // Expected: 5 -> 4 -> 3 -> 2 -> 1

        // Single element
        ListNode single = new ListNode(1);
        single = solution.reverseList(single);
        System.out.println("Single: " + listToString(single)); // Expected: 1
    }
}
