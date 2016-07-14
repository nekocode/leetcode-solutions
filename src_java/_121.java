/**
 * Created by nekocode on 16/7/10.
 */
public class _121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) minPrice = prices[i];
            else if (prices[i] - minPrice > maxProfit) maxProfit = prices[i] - minPrice;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        _121 p = new _121();
        System.out.print("" + p.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
