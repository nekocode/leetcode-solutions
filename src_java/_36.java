/**
 * Created by nekocode on 16/7/14.
 */
public class _36 {
    public boolean isValidSudoku(char[][] board) {
        byte rowMap[];
        byte colMap[][] = new byte[board.length][10];
        byte nineCellMap[][][] = new byte[board.length / 3][board.length / 3][10];
        boolean isValid = true;

        for (int row = 0; row < board.length && isValid; row++) {
            rowMap = new byte[10];
            for (int col = 0; col < board.length; col++) {
                char c = board[row][col];
                if (c == '.') continue;

                // 取数字
                int number = c - 48;

                // 验证该行是否有重复数字
                if (rowMap[number] == 1) {
                    isValid = false;
                    break;
                }
                rowMap[number] = 1;

                // 验证该列是否有重复数字
                if (colMap[col][number] == 1) {
                    isValid = false;
                    break;
                }
                colMap[col][number] = 1;

                // 验证九宫格是否有重复数字
                int nrow = row / 3;
                int ncol = col / 3;
                if (nineCellMap[ncol][nrow][number] == 1) {
                    isValid = false;
                    break;
                }
                nineCellMap[ncol][nrow][number] = 1;
            }
        }

        return isValid;
    }

    public static void main(String[] args) {
        char r1[] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char r2[] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char r3[] = new char[]{'.', '9', '.', '.', '.', '.', '.', '6', '.'};
        char r4[] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char r5[] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char r6[] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char r7[] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char r8[] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char r9[] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        char sudoku[][] = new char[][]{r1, r2, r3, r4, r5, r6, r7, r8, r9};

        System.out.print(new _36().isValidSudoku(sudoku));
    }
}
