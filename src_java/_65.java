/**
 * Created by nekocode on 16/7/15.
 */
public class _65 {
    public boolean isNumber(String s) {
        char cs[] = s.toCharArray();
        // 0: 开始态
        // 1: 左边的空格
        // 2: 左边的正负号

        // 3: 左边小数点前的数字
        // 4: 左边的小数点  -4: 左边没有数字的小数点
        // 5: 左边小数点后面的数字

        // 6: 'e'

        // 7: 右边的正负号
        // 8: 右边的数字
        // 9: 右边的空格
        // 当 status 为负数 -n 时,说明下一个状态必须为 n+1 否则非法
        int status = 0;

        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];

            // 字符处理
            switch (c) {
                case ' ':
                case '\t':
                    if (status == 0 || status == 1) {   // 包括自身
                        status = 1; break;
                    }
                    if (status == 3 || status == 4 || status == 5 || status == 8 || status == 9) {  // 包括自身
                        status = 9; break;
                    }
                    // 前面的状态只能为 0, 8 否则非法
                    return false;

                case '+':
                case '-':
                    if (status == 0 || status == 1) {
                        status = 2; break;
                    }
                    if (status == 6) {
                        status = 7; break;
                    }
                    return false;

                case '.':
                    if (status >= 0 && status < 3) {   // 0,1,2 遇到小数点之前没有数字
                        status = -4; break;
                    }
                    if (status == 3) {  // 左边有数字
                        status = 4; break;
                    }
                    return false;

                case 'e':
                    if (status > 2 && status < 6) {
                        status = 6; break;
                    }
                    return false;

                // 遇到其他非法字符
                default:
                    // 处理数字
                    if (c > 47 && c < 58) {
                        if (status >= 0 && status < 4) {   // 包括自身
                            status = 3; break;
                        }
                        if (status == 4 || status == -4 || status == 5) {   // 包括自身
                            status = 5; break;
                        }

                        if (status == 6 || status == 7 || status == 8) {    // 包括自身
                            status = 8; break;
                        }
                    }

                    // 非法字符
                    return false;
            }
        }
        return status == 3 || status == 4 || status == 5 || status == 8 || status == 9;
    }

    public static void main(String[] args) {
        _65 p = new _65();
        System.out.print(p.isNumber("1 ") + "\n");
        System.out.print(p.isNumber("  1") + "\n");
        System.out.print(p.isNumber("-100") + "\n");
        System.out.print(p.isNumber("0e23") + "\n");
        System.out.print(p.isNumber(" -3e+3 ") + "\n");
        System.out.print(p.isNumber(".1e1") + "\n");
        System.out.print(p.isNumber(" 1.e10") + "\n");
        System.out.print(p.isNumber("-.1e-0") + "\n");

        System.out.print("\n");

        System.out.print(p.isNumber("1 e") + "\n");
        System.out.print(p.isNumber(" 1 0") + "\n");
        System.out.print(p.isNumber("1-6") + "\n");
        System.out.print(p.isNumber("+ 1") + "\n");
        System.out.print(p.isNumber("e23") + "\n");
        System.out.print(p.isNumber("1e6+1") + "\n");
        System.out.print(p.isNumber("120e") + "\n");
        System.out.print(p.isNumber(".1e.1") + "\n");

    }
}
