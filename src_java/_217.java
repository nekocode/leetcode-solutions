import java.util.Arrays;

/**
 * Created by nekocode on 16/6/30.
 */
public class _217 {

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 1 || nums.length == 0)
            return false;
        Arrays.sort(nums);
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (temp == nums[i]) {
                return true;
            } else {
                temp = nums[i];
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(new _217().containsDuplicate(new int[]{0, 1, 2, 3, 0}));
    }
}
