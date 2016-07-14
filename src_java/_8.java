/**
 * Created by nekocode on 16/7/14.
 */
public class _8 {
    public int myAtoi(String str) {
        // 特殊情况
        if (str == null || str.length() == 0) return 0;

        // 定义状态变量, 0 为初始态, 1 表示上一个字符是数字, 2 代表上一个字符是符号, -1 表示错误, -2 表示提取数字终止
        int status = 0;
        char digits[] = str.toCharArray();
        long rlt = 0;           // 定义结果数字, 注意使用 long 是因为有输入有可能产生溢出
        int sign = 0;           // 定义符号, 注意 sign 为 0 表示尚未检测到正负号
        int vaildStart = -1;    // 有效数字的开始位置
        int vaildEnd = -1;      // 有效数字的结束位置

        // 遍历字符串
        for (int i = 0; i < digits.length && status >= 0; i++) {
            char c = digits[i];

            // 处理数字
            if (c > 47 && c < 58) {
                // 记录数字的开始
                if (vaildStart == -1) vaildStart = i;
                // 记录当前数字的结尾
                vaildEnd = i;
                // 记录状态
                status = 1;

                continue;
            }

            // 处理其他字符
            switch (c) {
                // 遇到空格的话跳过
                case ' ':
                case '\t':
                    if (status != 0) {
                        // 如果之前是数字的话, 终止提取
                        if (status == 1) status = -2;
                        // 如果之前是符号的话, 非法
                        else if (status == 2) status = -1;
                    }
                    // 如果是初始态的话则跳过
                    break;

                case '+':
                    if (sign != 0) {
                        // 如果已经在左边检测出正负号的话, 非法
                        status = -1;
                        continue;
                    }
                    status = 2;
                    sign = 1;
                    break;

                case '-':
                    if (sign != 0) {
                        // 如果已经在左边检测出正负号的话, 非法
                        status = -1;
                        continue;
                    }
                    status = 2;
                    sign = -1;
                    break;

                // 检测到非法字符
                default:
                    // 如果之前是数字的话, 终止提取
                    if (status == 1) status = -2;
                    // 如果之前是符号的话或者开始的话, 非法
                    else if (status == 2 || status == 0) status = -1;
            }
        }

        // 无有效数字, 或则遭遇非法的话返回 0
        if (vaildStart == -1 || vaildEnd == -1 || status == -1) return 0;

        // 构造数字
        for (int i = vaildEnd, figure = 0; i >= vaildStart; i--, figure++) {
            char c = digits[i];
            // 取得数字
            c -= 48;
            rlt += c * Math.pow(10, figure);
        }

        // 加上正负号
        if (sign == 0) sign = 1;
        rlt = sign * rlt;

        // 数字越界处理
        if (rlt > Integer.MAX_VALUE) rlt = Integer.MAX_VALUE;
        else if (rlt < Integer.MIN_VALUE) rlt = Integer.MIN_VALUE;

        return (int) rlt;
    }

    public static void main(String[] args) {
        System.out.print(new _8().myAtoi(" a +101-1"));
    }
}
