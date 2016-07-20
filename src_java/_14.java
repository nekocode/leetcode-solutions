import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by nekocode on 16/7/20.
 */
public class _14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";

        char strsChars[][] = new char[strs.length][];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i ++) {
            char chars[] = strs[i].toCharArray();
            strsChars[i] = chars;
            if (chars.length < minLen) minLen = chars.length;
        }
        if (minLen == 0) return "";

        char commonChar;
        int col = 0;
        for (; col < minLen; col ++) {
            commonChar = strsChars[0][col];
            for (int row = 0; row < strs.length; row ++) {
                char c = strsChars[row][col];
                if (c != commonChar) {
                    return strs[row].substring(0, col);
                }
            }
        }

        return strs[0].substring(0, col);
    }

    public String errLongestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        char strsChars[][] = new char[strs.length][];
        int maxLen = 0;
        for (int i = 0; i < strs.length; i ++) {
            char chars[] = strs[i].toCharArray();
            strsChars[i] = chars;
            if (chars.length > maxLen) maxLen = chars.length;
        }

        // 分组
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        ArrayList<Integer> groupOfAll = new ArrayList<>();
        for (int i = 0; i < strs.length; i ++) groupOfAll.add(i);
        groups.add(groupOfAll);

        for (int col = 0; col < maxLen; col ++) {

            ArrayList<ArrayList<Integer>> newGroups = new ArrayList<>();
            for (ArrayList<Integer> group : groups) {

                HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
                for (Integer position : group) {
                    char str[] = strsChars[position];
                    if (col >= str.length) continue;
                    char c = str[col];

                    ArrayList<Integer> newGroup = map.get(c);
                    if (newGroup == null) {
                        newGroup = new ArrayList<>();
                        newGroup.add(position);
                        map.put(c, newGroup);

                    } else {
                        newGroup.add(position);
                    }
                }

                // 找出能够进入下一次遍历的组
                for (ArrayList<Integer> newGroup : map.values()) {
                    if (newGroup.size() != 1) {
                        newGroups.add(newGroup);
                    }
                }
            }

            if (newGroups.size() != 0) groups = newGroups;
            else return strs[groups.get(0).get(0)].substring(0, col);
        }

        if (groups.size() == 0) return "";
        else return strs[groups.get(0).get(0)];
    }

    public static void main(String[] args) {
        System.out.println(new _14().longestCommonPrefix(new String[] {
                ""
        }));

        System.out.println(new _14().longestCommonPrefix(new String[] {
                "", "a", "", "a"
        }));
    }
}
