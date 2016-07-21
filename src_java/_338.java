/**
 * Created by nekocode on 16/7/21.
 */
public class _338 {
    public int[] countBits(int num) {
        int counts[] = new int[num + 1];
        int c, n;
        for (int i = 0; i <= num; i ++) {
            for (c = 0, n = i; n != 0; n >>= 1) if ((n & 1) == 1) c ++;
            counts[i] = c;
        }
        return counts;
    }

    public static void main(String[] args) {
        int rlt[] = new _338().countBits(0);
        for (int i : rlt)
            System.out.print(i + ", ");
    }
}
