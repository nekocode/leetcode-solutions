import javax.sound.midi.SysexMessage;

/**
 * Created by nekocode on 16/7/17.
 */
public class _88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
            return;
        }
        int offset = n;     // 注意这里的偏移量不是 m + n(可能会溢出)
        int end1 = offset + m - 1;
        int end2 = n - 1;
        System.arraycopy(nums1, 0, nums1, offset, m);

        for (int i = offset, j = 0, p = 0; ; p++) {
            if (i > end1) {
                // num1 已经遍历完
                System.arraycopy(nums2, j, nums1, p, n - j);
                return;
            }

            if (j > end2) {
                // num2 已经遍历完
                System.arraycopy(nums1, i, nums1, p, offset + m - i);
                return;
            }

            if (nums1[i] < nums2[j]) {
                nums1[p] = nums1[i];
                i++;
            } else {
                nums1[p] = nums2[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int nums1[] = new int[] {
                2, 3, 5, 6, 8, 9,
                0, 0, 0, 0,
        };
        int nums2[] = new int[] {
                1, 4, 7, 11
        };
        new _88().merge(nums1, 6, nums2, 4);
        for (int num : nums1) {
            System.out.print(num + ", ");
        }
    }
}
