import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by nekocode on 16/7/19.
 */
public class _190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        long unsignedN = Integer.toUnsignedLong(n);

        byte bits[] = new byte[32];
        int p = 31;
        while (unsignedN != 0) {
            bits[p--] = (byte)(unsignedN % 2);
            unsignedN /= 2;
        }

        p = 0;
        long rlt = 0;
        for (int decimal = 0; ; decimal++) {
            if (p > 31) break;

            rlt += bits[p++] * Math.pow(2, decimal);
        }

        return (int)rlt;
    }

    public static void main(String[] args) {
        System.out.println(new _190().reverseBits(-2147483648));
//        System.out.println(Integer.toBinaryString(-2147483648));
        int a = -8;
        a >>= 1;
        System.out.println(String.valueOf(a));
    }
}
