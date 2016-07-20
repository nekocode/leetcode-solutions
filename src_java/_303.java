/**
 * Created by nekocode on 16/7/20.
 */
public class _303 {
    private int nums[];

    public _303(int[] nums) {
        this.nums = nums;
//        this.nums = new int[nums.length];
//        System.arraycopy(nums, 0, this.nums, 0, nums.length);
    }

    public int sumRange(int i, int j) {
        if (i < 0) i = 0;
        if (j >= nums.length) j = nums.length - 1;

        int sum = 0;
        for (int p = i; p <= j; p ++) {
            sum += nums[p];
        }
        return sum;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {1, 2, -1, 3, 4, 5};
        System.out.println(new _303(nums).sumRange(-1, 2));
    }
}
