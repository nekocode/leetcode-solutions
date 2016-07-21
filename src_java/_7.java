/**
 * Created by nekocode on 16/7/21.
 */
public class _7 {
    public int reverse(int x) {
        int digits[] = new int[10];
        int len = 0;
        for (; x != 0; len ++, x /= 10) digits[len] = x % 10;
        long rlt = 0;
        for (int p = len -1, f = 0; f < len; f ++, p --) rlt += digits[p] * Math.pow(10, f);
        if (rlt > Integer.MAX_VALUE || rlt < Integer.MIN_VALUE) rlt = 0;
        return (int) rlt;
    }

    public static void main(String[] args) {
        System.out.println(new _7().reverse(-100000003));
    }
}
