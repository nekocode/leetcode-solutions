import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by nekocode on 16/7/15.
 */
public class _225 {
    private final ArrayDeque<Integer> queue = new ArrayDeque<>();
    private final ArrayDeque<Integer> reversedQueue = new ArrayDeque<>();

    private void reverseQueueTo(Queue<Integer> src, Queue<Integer> dst) {
        while (!src.isEmpty()) {
            dst.add(src.poll());
        }
    }

    // Push element x onto stack.
    public void push(int x) {
        if (queue.isEmpty()) {
            reverseQueueTo(reversedQueue, queue);
        }
        queue.push(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (reversedQueue.isEmpty()) {
            reverseQueueTo(queue, reversedQueue);
        }
        reversedQueue.poll();
    }

    // Get the top element.
    public int top() {
        if (reversedQueue.isEmpty()) {
            reverseQueueTo(queue, reversedQueue);
        }
        return reversedQueue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty() && reversedQueue.isEmpty();
    }

    public static void main(String[] args) {
        _225 stack = new _225();
        stack.push(1);
        stack.push(2);
        System.out.print(stack.top());
    }
}
