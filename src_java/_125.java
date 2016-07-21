/**
 * Created by nekocode on 16/7/21.
 */
public class _125 {
    public boolean isPalindrome(String s) {
        char chars[] = s.toCharArray();
        for (int p1 = 0, p2 = chars.length - 1; p2 >= p1;) {
            char a = chars[p1++];
            while (!(a > 64 && a < 91) && !(a > 96 && a < 123) && !(a > 47 && a < 58)) {
                if (p1 >= chars.length) return true;
                a = chars[p1++];
                if (p2 < p1) return true;
            }
            // 转化为大写
            if (a > 96) a = (char)(a - 32);

            char b = chars[p2--];
            while (!(b > 64 && b < 91) && !(b > 96 && b < 123) && !(b > 47 && b < 58)) {
                if (p2 < 0) return true;
                b = chars[p2--];
                if (p2 < p1) return true;
            }
            // 转化为大写
            if (b > 96) b = (char)(b - 32);

            if (a != b) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _125().isPalindrome("a.b,."));
    }
}
