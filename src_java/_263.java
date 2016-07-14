/**
 * Created by nekocode on 16/6/27.
 */
public class _263 {
    private static final int PRIME_FACTORS[] = {2, 3, 5};

    public boolean isUgly(int num) {
        if (num == 1) return true;
        if (num == 0) return false;

        for (int factor : PRIME_FACTORS) {
            if (num % factor == 0) {
                num /= factor;
                return isUgly(num);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _263 p = new _263();
        System.out.print(p.isUgly(1048576));
    }
}
