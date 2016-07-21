import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by nekocode on 16/7/21.
 */
public class _260 {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for (int num : nums) {
            if (!hash.containsKey(num)) hash.put(num, 0);
            else hash.remove(num);
        }
        int rlt[] = new int[2];
        Iterator<Integer> it = hash.keySet().iterator();
        rlt[0] = it.next();
        rlt[1] = it.next();
        return rlt;
    }

    public static void main(String[] args) {
        int rlt[] = new _260().singleNumber(new int[]{1, 2, 1, 3, 2, 0});
        System.out.println(rlt[0] + ", " + rlt[1]);
    }
}
