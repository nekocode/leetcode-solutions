/**
 * Created by nekocode on 16/7/20.
 */
public class _28 {
    public int strStr(String haystack, String needle) {
        char src[] = haystack.toCharArray();
        char dest[] = needle.toCharArray();
        if (src.length < dest.length) return -1;

        int ps = 0;
        int end = src.length - dest.length;
        int rlt = -1;
        for (; ps <= end && rlt == -1; ps ++) {
            rlt = ps;
            int _ps = ps;
            for (int pd = 0; pd < dest.length; pd ++, _ps ++) {
                if (dest[pd] != src[_ps]) {
                    rlt = -1;
                    break;
                }
            }
        }
        return rlt;
    }

    public static void main(String[] args) {
        System.out.println(new _28().strStr("abcdefghijklmn", "cde"));
    }
}
