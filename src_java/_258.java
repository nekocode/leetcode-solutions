/**
 * Created by nekocode on 16/7/15.
 */
public class _258 {
    public int addDigits(int num) {
        int sum = 0;
        for (; num != 0;) {
            sum += num % 10;
            num /= 10;
        }

        if (sum < 10) return sum;
        return addDigits(sum);
    }

    public static void main(String[] args) {
        System.out.print(new _258().addDigits(12345678));
    }
}
