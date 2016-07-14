import java.util.HashSet;
import java.util.Set;

/**
 * Created by nekocode on 16/7/14.
 */
public class _26 {
    public int removeDuplicates2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ps[] = new int[nums.length];
        int psLen = 0;

        // 找出所有重复数字的位置
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!set.contains(num)) {
                set.add(num);

            } else {
                ps[psLen] = i;
                psLen++;
            }
        }

        int count = nums.length - psLen;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (--psLen < 0) break;

            int p = ps[psLen];
            if (i != p) {
                nums[p] = nums[i];
            }
        }

        return count;
    }

    public int removeDuplicates(int[] nums) {
        int dupLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums.length - 1 && nums[i] == nums[i + 1]) {
                dupLen ++;
            } else {
                nums[i - dupLen] = nums[i];
            }
        }

        return nums.length - dupLen;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {1, 1, 2, 3, 4, 4, 5, 6, 7, 7};
        int len = new _26().removeDuplicates(nums);

        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
