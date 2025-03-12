import java.util.*;

public class MinimumColors {

    public static int minimumRecolors(String blocks, int k) {
        StringBuilder sb = new StringBuilder("");
        int m = k;
        while (m-- > 0) {
            sb.append("B");
        }
        if (blocks.contains(sb.toString()))
            return 0;
        int n = blocks.length();
        int i = 0;
        int j = k - 1;
        m = i;
        int cnt = 0;
        int minCount = Integer.MAX_VALUE;
        while (j < n) {
            // System.out.println("i: " + i);
            // System.out.println("j: " + j);
            cnt = 0;
            while (i <= j) {
                if (blocks.charAt(i) == 'W')
                    cnt++;
                i++;
            }
            System.out.println("Count: " + cnt);
            i = ++m;
            j++;
            minCount = Math.min(minCount, cnt);
        }
        return minCount;
    }

    // Sliding Window
    // TC - O(k)
    public static int minColors(String s, int k) {
        int whites = 0;
        int n = s.length();
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == 'W')
                whites++;
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = k; i < n; i++) {
            if (s.charAt(i - k) == 'W')
                whites--;
            if (s.charAt(i) == 'W')
                whites++;
            minCount = Math.min(minCount, whites);
        }
        return minCount;
    }

    // Count of Substrings Containing Every Vowel and K Consonants II
    public static long countOfSubstrings(String word, int k) {
        if (!word.contains("a") || !word.contains("e") || !word.contains("i")
                || !word.contains("o") || !word.contains("u")) {
            return 0;
        }
        int n = word.length();
        int right = 0;
        int left = 0;
        long count = 0;
        Set<Character> consonants = new HashSet<>();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                consonants.add(ch);
            }
        }
        int len = 5 + k;
        int count_consonants = 0;
        Map<Character, Integer> hm = new HashMap<>();
        while (right < n) {
            char ch = word.charAt(right);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                count_consonants++;
            }
            int currWindowSize = right - left + 1;
            while (currWindowSize > len && left < n) {
                char leftMostCharacter = word.charAt(left);
                if (hm.containsKey(leftMostCharacter)) {
                    hm.put(leftMostCharacter, hm.get(leftMostCharacter) - 1);
                    if (hm.get(leftMostCharacter) == 0)
                        hm.remove(leftMostCharacter);
                    if (leftMostCharacter != 'a' && leftMostCharacter != 'e' && leftMostCharacter != 'i'
                            && leftMostCharacter != 'o' && leftMostCharacter != 'u')
                        count_consonants--;
                }
                left++;
                // System.out.println("String: " + word.substring(left, right + 1));
            }
            if (currWindowSize == len) {
                if (hm.get('a') >= 1 && hm.get('e') >= 1 && hm.get('i') >= 1 && hm.get('o') >= 1 && hm.get('u') >= 1
                        && count_consonants == k) {
                    count++;
                    // System.out.println("String that incremented count: " + word.substring(left,
                    // right));
                }
                System.out.println(hm);
            }
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        // String blocks = "WBBWWBBWBW";
        // int k = 7;
        // System.out.println(minimumRecolors(blocks, k));
        // System.out.println(minColors(blocks, k));
        System.out.println("Ans: " + countOfSubstrings("ieaouqqieaouqq", 1));
    }
}
