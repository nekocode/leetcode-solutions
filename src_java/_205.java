import java.util.HashMap;

/**
 * Created by nekocode on 16/7/15.
 */
public class _205 {
    public boolean isIsomorphic(String s, String t) {
        char str1[] = s.toCharArray();
        char str2[] = t.toCharArray();
        char charMap[] = new char[65536];
        char charMap2[] = new char[65536];
        for (int i = 0; i < str1.length; i++) {
            char c1 = str1[i];
            char c2 = str2[i];
            char charInMap = charMap[c1];
            if (charInMap == 0) {
                if (charMap2[c2] != 0) return false;
                charMap[c1] = c2;
                charMap2[c2] = c1;
            } else {
                if (charInMap != c2) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(new _205().isIsomorphic("ab", "aa"));
    }
}
