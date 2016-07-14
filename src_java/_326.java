import java.math.BigDecimal;

/**
 * Created by nekocode on 16/7/7.
 */
public class _326 {
    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++)
            System.out.print(new BigDecimal(Math.pow(3, i)).toString() + "\n");

//        System.out.print(new _231().isPowerOfThree(2147483648));
    }
}
