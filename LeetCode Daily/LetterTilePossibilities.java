import java.util.*;

public class LetterTilePossibilities {

    public static void helper(int idx, String curr, String tiles, int n, boolean[] freq, HashSet<String> set) {
        set.add(curr);
        for (int i = 0; i < n; i++) {
            char ch = tiles.charAt(i);
            if (!freq[ch - 'A']) {
                freq[ch - 'A'] = true;
                helper(i + 1, curr + ch, tiles, n, freq, set);
                freq[ch - 'A'] = false;
            }
        }
    }

    public static int numTilePossibilities(String tiles) {
        boolean[] freq = new boolean[26];
        Arrays.fill(freq, false);
        HashSet<String> set = new HashSet<>();
        helper(0, "", tiles, tiles.length(), freq, set);
        return set.size();
    }

    public static void main(String[] args) {
        String s = "AAB";
        System.out.println(numTilePossibilities(s));
    }
}
