import java.util.Stack;

/**
 * Problem: Implement Queue using Two Stacks
 * Implement a FIFO queue using only two stacks. The implemented queue
 * must support push, pop, peek, and empty operations.
 *
 * Approach: Lazy transfer — amortized O(1) per operation, O(n) space
 *   - push: always push onto the input stack.
 *   - pop/peek: if the output stack is empty, pour all elements from
 *               the input stack into the output stack (reverses order),
 *               then operate on the output stack.
 */
public class QueueUsingStacks {

    private final Stack<Integer> inputStack;
    private final Stack<Integer> outputStack;

    public QueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    public int pop() {
        transfer();
        return outputStack.pop();
    }

    public int peek() {
        transfer();
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    private void transfer() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println("peek: " + queue.peek());  // Expected: 1
        System.out.println("pop:  " + queue.pop());   // Expected: 1
        System.out.println("empty:" + queue.empty()); // Expected: false
        System.out.println("pop:  " + queue.pop());   // Expected: 2
        System.out.println("empty:" + queue.empty()); // Expected: true
    }
}
