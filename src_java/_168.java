/**
 * Created by nekocode on 16/7/21.
 */
public class _168 {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        for (; n != 0; n = (n - 1) / 26) {
            char c = (char)(n % 26 + 64);
            if (c == 64) c = 90;
            builder.append(c);
        }
        builder.reverse();
        return new String(builder);
    }

    public static void main(String[] args) {
        for (int i = 999; i < 1200; i ++)
            System.out.println(new _168().convertToTitle(i));
    }
}
