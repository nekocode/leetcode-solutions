/**
 * Created by nekocode on 16/7/21.
 */
public class _238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return nums;
        int rlt[] = new int[nums.length];

        rlt[0] = 1;
        int l = 1;
        for (int i = 0; i < nums.length - 1; i ++) {
            l *= nums[i];
            rlt[i + 1] = l;
        }

        int r = 1;
        for (int i = nums.length - 1; i > 0; i --) {
            r *= nums[i];
            rlt[i - 1] *= r;
        }

        return rlt;
    }

    public static void main(String[] args) {
        int rlt[] = new _238().productExceptSelf(new int[]{2,3,4,5});
        for (int i : rlt) System.out.print(i + ", ");
    }
}
