/**
 * Created by nekocode on 16/7/21.
 */
public class _278 {
    public static int count = 1;
    boolean isBadVersion(int version) {
        count ++;
        return version > 1702766718;
    }

    public int firstBadVersion(int n) {
        int l = 1, r = n;

        while (true) {
            n = (r - l) / 2;
            if (n < l) n = l;
            if (n > r) n = r;

            if (isBadVersion(n)) {
                // 前半段继续搜寻
                r = n - 1;
                if (r < l) return n;

            } else {
                // 后半段继续搜寻
                l = n + 1;
                if (r < l) return n + 1;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new _278().firstBadVersion(2126753390));
        System.out.println(_278.count);
    }

    public int firstBadVersion2(int n) {
        int l = 1, r = n;

        while (true) {
            n = (r - l) / 2 + 1;
            if (n < l) n = l;
            if (n > r) n = r;

            if (isBadVersion(n)) {
                // 如果 n 为 bad version
                if (!isBadVersion(n - 1)) {
                    return n;

                } else {
                    // 前半段继续搜寻
                    r = n - 1;
                }
            } else {
                if (isBadVersion(n + 1)) {
                    return n + 1;

                } else {
                    // 后半段继续搜寻
                    l = n + 1;
                }
            }
        }
    }
}
