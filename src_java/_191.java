import java.math.BigDecimal;

/**
 * Created by nekocode on 16/7/6.
 */
public class _191 {
    public int hammingWeight(int n) {
        long l = Integer.toUnsignedLong(n);

        int count = 0;
        for (; l != 0; l = l >> 1) {
            if ((l & 1) == 1) count ++;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int count = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') count ++;
        }

        return count;
    }

    public static void main(String[] args) {
//        System.out.print("" + Integer.toBinaryString(-1));
        System.out.print("" + new _191().hammingWeight(-1));   // 4294967295
    }
}
