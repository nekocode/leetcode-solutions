import java.math.BigDecimal;

/**
 * Created by nekocode on 16/7/13.
 */
public class _342 {
    public boolean isPowerOfFour(int num) {
        switch (num) {
            case 1:
            case 4:
            case 16:
            case 64:
            case 256:
            case 1024:
            case 4096:
            case 16384:
            case 65536:
            case 262144:
            case 1048576:
            case 4194304:
            case 16777216:
            case 67108864:
            case 268435456:
            case 1073741824:
                return true;

            default:
                return false;
        }
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 20; i ++) {
//            System.out.print(new BigDecimal(Math.pow(4, i)).toString() + "\n");
//        }

        System.out.print(new _342().isPowerOfFour(32));
    }
}
