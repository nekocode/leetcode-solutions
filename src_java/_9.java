import java.util.ArrayList;

/**
 * Created by nekocode on 16/7/15.
 */
public class _9 {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        else if (x < 10) return true;

        ArrayList<Integer> diviNums = new ArrayList<>();
        int diviNum = x;
        while (true) {
            diviNum = diviNum / 10;
            if (diviNum == 0) break;
            diviNums.add(diviNum);
        }
        // 得出数字的长度
        int numLen = diviNums.size() + 1;

        int digits[] = new int[numLen];
        int p = numLen - 1;
        // 获取个位数
        digits[p--] = x % 10;

        // 获取其他位数
        for (int dn : diviNums) {
            digits[p--] = dn % 10;
        }

        // 判断是否为回文
        int half = numLen / 2;
        for (int i = 0; i < half; i ++) {
            if (digits[i] != digits[numLen - 1 - i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.print(new _9().isPalindrome(1122));
    }
}
