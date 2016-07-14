/**
 * Created by nekocode on 16/7/13.
 */
public class _345 {
    public String reverseVowels(String s) {
        char ss[] = s.toCharArray();
        char vs[] = new char[ss.length];
        int sp[] = new int[ss.length];

        int i2 = 0;
        for (int i = 0; i < ss.length; i ++) {
            char c = ss[i];
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'A':
                case 'E':
                case 'I':
                case 'O':
                case 'U':
                    sp[i2] = i;
                    vs[i2] = c;
                    i2 ++;
            }
        }

        int len = i2;
        for (i2 --; i2 >= 0; i2 --) {
            ss[sp[i2]] = vs[len - i2 - 1];
        }

        return String.valueOf(ss);
    }

    public static void main(String[] args) {
        System.out.print(new _345().reverseVowels(""));
    }
}
