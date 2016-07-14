/**
 * Created by nekocode on 16/6/28.
 */
public class _171 {
    public int titleToNumber(String s) {
        char chars[] = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++)
            sum += ((int)chars[i] - 64) * (Math.pow(26, (chars.length - i - 1)));
        return sum;
    }

    public static void main(String[] args) {
        System.out.print(new _171().titleToNumber("AA"));
    }
}
