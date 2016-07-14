/**
 * Created by nekocode on 16/6/27.
 */
public class _349 {
    private final int map1[] = new int[1000];
    private final int map2[] = new int[1000];
    private final int buf[] = new int[1000];

    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0;
        for (int num1 : nums1) {
            if (map1[num1] != 1) {
                map1[num1] = 1;
            }
        }

        for (int num2 : nums2) {
            if (map1[num2] == 1 && map2[num2] != 1) {
                map2[num2] = 1;
                buf[i++] = num2;
            }
        }

        int rlt[] = new int[i];
        System.arraycopy(buf, 0, rlt, 0, i);
        return rlt;
    }

    public static void main(String[] args) {
        _349 p = new _349();
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        int nums[] = p.intersection(nums1, nums2);

        for (int num : nums) {
            System.out.print(String.valueOf(num) + ",");
        }
    }
}
