/**
 * Created by nekocode on 16/6/27.
 */
public class _283 {
    public void moveZeroes(int[] nums) {
        int zeroNumber = 0;
        int len = nums.length;
        for (int i = 0; i < len; i ++) {
            if (nums[i] == 0) {
                zeroNumber ++;
            } else if (zeroNumber != 0) {
                nums[i - zeroNumber] = nums[i];
            }
        }

        for (int i = len - zeroNumber; i < len; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        _283 p = new _283();
        int nums[] = {0, 0, 1};
        p.moveZeroes(nums);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + ", ");
        }
    }
}
