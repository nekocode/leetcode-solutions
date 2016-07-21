import java.util.HashMap;

/**
 * Created by nekocode on 16/7/21.
 */
public class _136 {
    public int singleNumber(int[] nums) {
        // 使用 0 来表示某个数字出现过两次
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            if (num == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (num == nums[j]) {
                    nums[j] = 0;
                    nums[i] = 0;
                    break;
                }
            }
            if (nums[i] != 0) return num;
        }

        return 0;
    }

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            if (!hash.containsKey(num)) hash.put(num, 0);
            else hash.remove(num);
        }
        return hash.keySet().iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(new _136().singleNumber(new int[]{1, 2, 1, 3, 2, 0, 3}));
    }
}
