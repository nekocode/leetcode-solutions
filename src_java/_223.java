/**
 * Created by nekocode on 16/7/16.
 */
public class _223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1 = (C - A) * (D - B);
        int rect2 = (G - E) * (H - F);

        long intersectionWidth = (long)Math.min(G, C) - (long)Math.max(A, E);
        if (intersectionWidth <= 0) return rect1 + rect2;   // 左边边缘相贴,无交集

        long intersectionHeight = (long)Math.min(D, H) - (long)Math.max(F, B);
        if (intersectionHeight <= 0) return rect1 + rect2;   // 上下边缘相贴,无交集
        return rect1 + rect2 - (int)(intersectionWidth * intersectionHeight);
    }

    public static void main(String[] args) {
        System.out.print(new _223().computeArea(
                /**A**/-1500000001, /**B**/0, /**C**/-1500000000, /**D**/1,
                /**E**/1500000000, /**F**/0, /**G**/1500000001, /**H**/1));
    }
}
