/**
 * Created by nekocode on 16/7/21.
 */
public class _6 {
    public String convert(String s, int numRows) {
        StringBuilder builder = new StringBuilder();
        char chars[] = s.toCharArray();

        // 计算出 numCols
        int twoLines = (numRows * 2 - 2);
        if (twoLines == 0) return s;

        int numCols = (chars.length / twoLines) * 2;
        int rest = chars.length - twoLines * (numCols / 2);
        if (rest > 0 && rest <= numRows) {
            numCols ++;
        } else if (rest > numRows) {
            numCols += 2;
        }

        int p = 0;
        // 开始转换
        for (int row = 0; row < numRows; row ++) {
            for (int col = 0; col < numCols; col ++) {
                if (row == 0 || row == numRows - 1) {
                    // 第一行或者最后一行
                    if (col % 2 == 0) {
                        // 奇数行
                        p = (col / 2) * twoLines + row;
                        if (p < chars.length) builder.append(chars[p]);
                    }

                } else {
                    // 第二行到倒数第二行
                    if (col % 2 == 0) {
                        // 奇数行
                        p = (col / 2) * twoLines + row;
                        if (p < chars.length) builder.append(chars[p]);

                    } else {
                        // 偶数行
                        p = (col / 2) * twoLines + (twoLines - row);
                        if (p < chars.length) builder.append(chars[p]);
                    }
                }
            }
        }

        return new String(builder);
    }

    public static void main(String[] args) {
        System.out.println(new _6().convert("ABC", 1));
    }
}
