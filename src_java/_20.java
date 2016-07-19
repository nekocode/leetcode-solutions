/**
 * Created by nekocode on 16/7/19.
 */
public class _20 {
    private static final char stack[] = new char[65536];
    private static int top;

    public boolean isValid(String s) {
        top = -1;
        char chars[] = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack[++top] = c;
                    break;

                case ')':
                    if (top < 0) return false;
                    if (stack[top--] != '(') return false;
                        break;

                case '}':
                    if (top < 0) return false;
                    if (stack[top--] != '{') return false;
                    break;

                case ']':
                    if (top < 0) return false;
                    if (stack[top--] != '[') return false;
                    break;
            }
        }

        return top == -1;
    }

    public static void main(String[] args) {
        System.out.println(new _20().isValid("([fds{}[sfa]])fjdskajflksajf"));
    }
}
