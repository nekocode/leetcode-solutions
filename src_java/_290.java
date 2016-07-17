import java.util.HashMap;

/**
 * Created by nekocode on 16/7/17.
 */
public class _290 {
    public boolean wordPattern(String pattern, String str) {
        String words[] = str.split(" ");
        char chars[] = pattern.toCharArray();
        if (words.length != chars.length) return false;

        HashMap<String, Integer> strMap = new HashMap<>();
        for (int p = 0; p < words.length; p ++) {
            String word = words[p];
            if (!strMap.containsKey(word)) {
                strMap.put(word, (int)chars[p]);

            } else {
                if ((int)chars[p] != strMap.get(word)) return false;
            }
        }
        return true;
    }

    public boolean wordPattern2(String pattern, String str) {
        String words[] = str.split(" ");
        char chars[] = pattern.toCharArray();
        if (words.length != chars.length) return false;

        int id = 1;
        int charMap[] = new int[26];
        int patternIds[] = new int[pattern.length()];
        for (int p = 0; p < chars.length; p ++) {
            char c = (char)(chars[p] - 97);
            if (charMap[c] == 0) {
                charMap[c] = id;
                patternIds[p] = id;
                id++;

            } else {
                patternIds[p] = charMap[c];
            }
        }

        id = 1;
        HashMap<String, Integer> strMap = new HashMap<>();
        for (int p = 0; p < words.length; p ++) {
            String word = words[p];
            if (!strMap.containsKey(word)) {
                strMap.put(word, id);
                if (patternIds[p] != id) return false;
                id ++;

            } else {
                if (patternIds[p] != strMap.get(word)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.print(new _290().wordPattern("baab", "dog cat cat dog"));
    }
}
