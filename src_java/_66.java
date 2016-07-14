/**
 * Created by nekocode on 16/7/14.
 */
public class _66 {
    public int[] plusOne(int[] digits) {
        digits[digits.length - 1] += 1;

        boolean carry = false;
        for (int i = digits.length - 1; i >= 0; i--) {
            int d = digits[i];
            if (d == 10) {
                digits[i] = 0;
                if (i == 0) {
                    carry = true;
                    break;
                }
                digits[i - 1] += 1;
            }
        }

        int rlt[];
        if (carry) {
            rlt = new int[digits.length + 1];
            rlt[0] = 1;
            System.arraycopy(digits, 0, rlt, 1, digits.length);

        } else {
            rlt = new int[digits.length];
            System.arraycopy(digits, 0, rlt, 0, digits.length);
        }

        return rlt;
    }

    public static void main(String[] args) {
        int rlt[] = new _66().plusOne(new int[]{1, 9, 9});
        for (int digit : rlt)
            System.out.print(digit + ", ");
    }
}
