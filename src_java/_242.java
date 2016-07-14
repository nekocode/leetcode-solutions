/**
 * Created by nekocode on 16/6/28.
 */
public class _242 {

    public boolean isAnagram(String s, String t) {
        char cs[] = s.toCharArray();
        char ct[] = t.toCharArray();

        long csSum = 0;
        long ctSum = 0;
        for (int c : cs) csSum += c;
        for (int c : ct) ctSum += c;

        // 通过校验和(checkSum)来快速筛选掉不匹配的结果
        if (csSum != ctSum) return false;

        // 双重 checkSum
        for (int c : cs) csSum = csSum + ((c * 1313) % 1000 ^ 0x555555);
        for (int c : ct) ctSum = ctSum + ((c * 1313) % 1000 ^ 0x555555);

        return csSum == ctSum;
    }

    public static void main(String[] args) {
        System.out.print(new _242().isAnagram("fe", "ja") + "\n");
        System.out.print(new _242().isAnagram("ac", "bb"));
    }
}
