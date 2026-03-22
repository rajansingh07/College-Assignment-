import java.util.Stack;

/**
 * Problem: Min Stack
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 *
 * Implement the MinStack class:
 *   - push(val): pushes val onto the stack.
 *   - pop():     removes the element on the top.
 *   - top():     gets the top element.
 *   - getMin():  retrieves the minimum element in the stack.
 *
 * All operations must run in O(1) time.
 *
 * Approach: Two stacks (main stack + auxiliary min stack) — O(1) per operation
 */
public class MinStack {

    private final Stack<Integer> stack;
    private final Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int removed = stack.pop();
        if (removed == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("getMin: " + minStack.getMin()); // Expected: -3
        minStack.pop();
        System.out.println("top:    " + minStack.top());    // Expected: 0
        System.out.println("getMin: " + minStack.getMin()); // Expected: -2
    }
}
