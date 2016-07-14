import java.math.BigDecimal;

/**
 * Created by nekocode on 16/7/7.
 */
public class _231 {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && 1073741824 % n == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++)
            System.out.print(new BigDecimal(Math.pow(2, i)).toString() + "\n");

//        System.out.print(new _231().isPowerOfTwo(2147483648));
    }
}
