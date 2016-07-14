/**
 * Created by nekocode on 16/6/26.
 */
public class _344 {
    public String reverseString(String s) {
        int len = s.length();
        char chars[] = s.toCharArray();
        char reverseChars[] = new char[len];

        for (int i =0; i < len; i++) {
            reverseChars[i] = chars[len - i - 1];
        }
        return new String(reverseChars);
    }

    public static void main(String[] args) {
        _344 p = new _344();
        System.out.print(p.reverseString("123456"));
    }
}
