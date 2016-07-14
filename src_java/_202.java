/**
 * Created by nekocode on 16/6/26.
 */
public class _202 {
    // 预留数组第一位用于储存 num 的位数
    private int digits[] = new int[1024];

    public int[] getDigits(int num) {
        int i = 1;

        if (num == 0) {
            digits[0] = 0;
            digits[1] = 0;

        } else {
            for (; num != 0; i++) {
                int digit = num % 10;
                num = (num - digit) / 10;
                digits[i] = digit;
            }

            // 储存 num 的位数
            digits[0] = i - 1;
        }

        return digits;
    }

    public int getDigitsSum(int num) {
        int sum = 0;
        int digits[] = getDigits(num);
        int len = digits[0];
        for (int i = 0; i < len; i++) {
            int digit = digits[i + 1];
            sum += digit * digit;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int sum = n;
        for (; sum > 9; ) sum = getDigitsSum(sum);
        return sum == 1 || sum == 7;
    }

    public static void main(String[] args) {
        _202 p = new _202();

        System.out.print(p.isHappy(45));
    }
}
