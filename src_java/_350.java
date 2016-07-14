/**
 * Created by nekocode on 16/7/6.
 */
public class _350 {
    private final int map1[] = new int[1000];
    private final int buf[] = new int[1000];

    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
        for (int num1 : nums1) {
            map1[num1] += 1;
        }

        for (int num2 : nums2) {
            if (map1[num2] != 0) {
                buf[i++] = num2;
                map1[num2]--;
            }
        }

        int rlt[] = new int[i];
        System.arraycopy(buf, 0, rlt, 0, i);
        return rlt;
    }

    public static void main(String[] args) {
        _350 p = new _350();
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        int nums[] = p.intersect(nums1, nums2);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + ",");
        }
    }
}
