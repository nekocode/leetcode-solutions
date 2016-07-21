/**
 * Created by nekocode on 16/7/21.
 */
public class _189 {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0) return;
        int mod = k % nums.length;
        if (mod == 0) return;

        int tmp[] = new int[mod];
        System.arraycopy(nums, nums.length - mod, tmp, 0, mod);
        System.arraycopy(nums, 0, nums, mod, nums.length - mod);
        System.arraycopy(tmp, 0, nums, 0, mod);
    }

    public static void main(String[] args) {
        int rlt[] = new int[]{1,2,3,4,5,6,7};
        new _189().rotate(rlt, 3);
        for (int i : rlt) System.out.println(i);
    }
}
