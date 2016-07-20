/**
 * Created by nekocode on 16/7/20.
 */
public class _1 {
    public int[] twoSum(int[] nums, int target) {
        int num1, num2;
        for (int i = 0; i < nums.length; i ++) {
            num1 = nums[i];
            for (int j = i + 1; j < nums.length; j ++) {
                num2 = nums[j];
                if (num1 + num2 == target) return new int[] {i, j};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int rlt[] = new _1().twoSum(new int[]{-1,-2,-3,-4,-5}, -8);
        System.out.println(rlt[0] + ", " + rlt[1]);
    }
}
