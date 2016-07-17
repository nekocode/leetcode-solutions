import javax.swing.text.Position;
import java.util.HashMap;

/**
 * Created by nekocode on 16/7/17.
 */
public class _219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num) || i - map.get(num) > k) {
                // 没有重复, 或者与上一次重复距离大于 k
                map.put(num, i);

            } else {
                // 与上一次重复字符的距离小于 k
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.print(new _219().containsNearbyDuplicate(new int[]{0, 1, 2, 3, 1, 0, 5, 7}, 4));
    }
}
