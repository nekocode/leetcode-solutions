/**
 * Created by nekocode on 16/6/28.
 */
public class _169 {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int cc = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == maj) {
                cc++;
            }

            else {
                cc--;
                if(cc == 0) {
                    maj = nums[i];
                    cc = 1;
                }
            }
        }
        return maj;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 4, 4, 4, 4, 1, 1, 1};
        System.out.print(new _169().majorityElement(nums));
    }
}
