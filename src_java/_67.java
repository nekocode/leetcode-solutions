/**
 * Created by nekocode on 16/7/20.
 */
public class _67 {

    public String addBinary(String a, String b) {
        StringBuffer buf = new StringBuffer();
        char charsA[] = a.toCharArray();
        char charsB[] = b.toCharArray();

        int carry = 0;  // 进位
        for (int pa = charsA.length - 1, pb = charsB.length - 1; pa >= 0 || pb >= 0; pa --, pb --) {
            char ca = 48, cb = 48;
            if (pa >= 0) ca = charsA[pa];
            if (pb >= 0) cb = charsB[pb];

            switch (ca + cb + carry) {
                case 96:
                    // 0 + 0 + 0 = 0
                    buf.append(0);
                    carry = 0;
                    break;
                case 97:
                    // 0 + 1 + 0 = 1
                    buf.append(1);
                    carry = 0;
                    break;
                case 98:
                    // 1 + 1 + 0 = 10
                    buf.append(0);
                    carry = 1;
                    break;
                case 99:
                    // 1 + 1 + 1 = 11
                    buf.append(1);
                    carry = 1;
                    break;
            }
        }
        if (carry == 1) buf.append(1);

        return new String(buf.reverse());
    }

    public static void main(String[] args) {
        String a = "1101011101101010101011111111111110000110101010110101010001010101111111111010101010100110101001010101";
        String b = "1101101010101010101010100101010001010101010101010101010101001011010101010101001010101010101010110110111010101111011";
        System.out.println(new _67().addBinary(a, b));
        System.out.println(Long.toBinaryString(Long.valueOf(a, 2) + Long.valueOf(b, 2)));
    }
}
