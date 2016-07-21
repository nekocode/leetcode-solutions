/**
 * Created by nekocode on 16/7/20.
 */
public class _155 {
    private int stack[] = new int[65536];
    private int size = 0;
    private int top = 0;
    private int min = Integer.MAX_VALUE;
    private int minPos = -1;

    /** initialize your data structure here. */
    public _155() {

    }

    public void push(int x) {
        top = (stack[size++] = x);
        if (top < min) {
            min = top;
            minPos = size - 1;
        }
    }

    public void pop() {
        size --;
        if (size == 0) {
            min = Integer.MAX_VALUE;
            return;
        }

        top = stack[size - 1];
        if (minPos > size - 1) {
            // 重新找最小的
            min = Integer.MAX_VALUE;
            for (int i = 0; i < size; i ++) {
                int val = stack[i];
                if (val < min) {
                    min = val;
                    minPos = size - 1;
                }
            }
        }
    }

    public int top() {
        return top;
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        _155 stack = new _155();
        stack.push(0);
        stack.push(-1);
        stack.push(5);
        System.out.println("top:" + stack.top + " min:" + stack.getMin());
        stack.push(-5);
        System.out.println("top:" + stack.top + " min:" + stack.getMin());
        stack.pop();
        System.out.println("top:" + stack.top + " min:" + stack.getMin());
    }
}
