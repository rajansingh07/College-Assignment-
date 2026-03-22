/**
 * Problem: Circular Queue (Ring Buffer)
 * Design a circular queue with fixed capacity supporting:
 *   - enQueue(value): insert an element. Returns false if full.
 *   - deQueue():      delete the front element. Returns false if empty.
 *   - Front():        get the front element. Returns -1 if empty.
 *   - Rear():         get the rear element. Returns -1 if empty.
 *   - isEmpty():      checks whether the queue is empty.
 *   - isFull():       checks whether the queue is full.
 *
 * Approach: Array + two pointers (head, tail) — O(1) per operation, O(k) space
 */
public class CircularQueue {

    private final int[] data;
    private int head;
    private int tail;
    private int size;
    private final int capacity;

    public CircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[tail] = value;
        tail = (tail + 1) % capacity;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % capacity;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        return isEmpty() ? -1 : data[(tail - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(3);
        System.out.println("enQueue(1): " + queue.enQueue(1)); // true
        System.out.println("enQueue(2): " + queue.enQueue(2)); // true
        System.out.println("enQueue(3): " + queue.enQueue(3)); // true
        System.out.println("enQueue(4): " + queue.enQueue(4)); // false (full)
        System.out.println("Rear:       " + queue.Rear());     // 3
        System.out.println("isFull:     " + queue.isFull());   // true
        System.out.println("deQueue:    " + queue.deQueue());  // true
        System.out.println("enQueue(4): " + queue.enQueue(4)); // true
        System.out.println("Rear:       " + queue.Rear());     // 4
    }
}
