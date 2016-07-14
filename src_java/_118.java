import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by nekocode on 16/7/14.
 */
public class _118 {

    private List<Integer> generateNextRow(List<Integer> nowRow) {
        List<Integer> row = new ArrayList<>();

        int i = 0;
        int last = 1;
        for (Integer integer : nowRow) {
            if (i == 0) {
                row.add(integer);
                i++;
                continue;
            } else {
                row.add(integer + last);
                last = integer;
            }
            i++;
        }

        row.add(1);

        return row;
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0)  return new ArrayList<>();

        List<List<Integer>> rlt = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        rlt.add(firstRow);

        List<Integer> lastList = firstRow;
        for (int row = 1; row < numRows; row ++) {
            List<Integer> list = generateNextRow(lastList);
            lastList = list;
            rlt.add(list);
        }

        return rlt;
    }

    public static void main(String[] args) {
        List<List<Integer>> rlt = new _118().generate(5);

        for (List<Integer> list : rlt) {
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.print("\n");
        }
    }
}
