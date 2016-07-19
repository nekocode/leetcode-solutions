import java.util.ArrayList;

/**
 * Created by nekocode on 16/7/19.
 */
public class _38 {
    private static ArrayList<String> cache;

    static {
        cache = new ArrayList<>();
        cache.add("1");
    }

    private String countAndSay(String str) {
        StringBuffer buf = new StringBuffer();

        char chars[] = str.toCharArray();
        char lastChar = chars[0];
        int lastCharCount = 0;
        for (char c : chars) {
            if (c != lastChar) {
                buf.append(lastCharCount).append(lastChar);
                lastChar = c;
                lastCharCount = 1;

            } else {
                lastCharCount++;
            }
        }
        buf.append(lastCharCount).append(lastChar);

        return new String(buf);
    }

    public String countAndSay(int n) {
        int size = cache.size();
        if (n <= size) return cache.get(n - 1);

        int dif = n - size;
        String lastStr = cache.get(size -1);

        for (int i = 0; i < dif; i ++) {
            lastStr = countAndSay(lastStr);
            cache.add(lastStr);
        }

        return lastStr;
    }

    public static void main(String[] args) {
        System.out.println(new _38().countAndSay(11));
        System.out.println(new _38().countAndSay(6));
    }
}
