import java.util.Stack;

/**
 * Created by nekocode on 16/7/14.
 */
public class _232 {
    private Stack<Integer> stack = new Stack<>();           // 正向栈
    private Stack<Integer> reversedStack = new Stack<>();   // 反向栈

    private void reverseToStack(Stack<Integer> src, Stack<Integer> dest) {
        int size = src.size();
        for (int i = 0; i < size; i++) {
            dest.push(src.peek());
            src.pop();
        }
    }

    // Push element x to the back of queue.
    public void push(int x) {
        if (stack.empty() && !reversedStack.empty()) {
            reverseToStack(reversedStack, stack);
        }

        stack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (!stack.empty() && reversedStack.empty()) {
            reverseToStack(stack, reversedStack);
        }

        reversedStack.pop();
    }

    // Get the front element.
    public int peek() {
        if (!stack.empty() && reversedStack.empty()) {
            reverseToStack(stack, reversedStack);
        }

        return reversedStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack.empty() && reversedStack.empty();
    }

    public static void main(String[] args) {
        _232 queue = new _232();
        queue.push(0);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        queue.push(4);
        queue.pop();
        queue.push(5);

        while (!queue.empty()) {
            System.out.print(queue.peek() + ", ");
            queue.pop();
        }
    }
}
