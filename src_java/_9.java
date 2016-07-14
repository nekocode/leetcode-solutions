import java.util.ArrayList;

/**
 * Created by nekocode on 16/7/15.
 */
public class _9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        int digits[] = new int[100];
        int p = 0;
        while (true) {
            digits[p++] = x % 10;
            x /= 10;
            if (x == 0) break;
        }

        // 判断是否为回文
        int half = p / 2;
        for (int i = 0; i < half; i ++) {
            if (digits[i] != digits[p - 1 - i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.print(new _9().isPalindrome(2147483647));
    }
}
