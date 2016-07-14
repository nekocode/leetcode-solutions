/**
 * Created by nekocode on 16/7/13.
 */
public class _27 {
    public int removeElement(int[] nums, int val) {
        int ps[] = new int[nums.length];
        int psLen = 0;

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num == val) {
                count++;
                ps[psLen] = i;
                psLen ++;
            }
        }

        int i2 = psLen;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (--i2 < 0) break;
            int p = ps[i2];
            if (p == i) continue;
            nums[p] = nums[i];
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 3, 1, 5, 6, 7, 3, 3, 8};
        int len = new _27().removeElement(a, 3);
        System.out.print("len: " + len + "\n");

        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + ", ");
        }
    }
}
