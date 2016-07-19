/**
 * Created by nekocode on 16/7/19.
 */
public class _58 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        char chars[] = s.toCharArray();
        for (char c : chars) {
            if (c == ' ') {
                if (length > 0) length = -length;

            } else {
                if (length < 0) length = 1;
                else length ++;
            }
        }
        return Math.abs(length);
    }

    public static void main(String[] args) {
        System.out.println(new _58().lengthOfLastWord(""));
    }
}
