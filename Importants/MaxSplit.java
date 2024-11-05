import java.util.HashMap;

public class MaxSplit {

    static int[] sCount = new int[26];
    static int[] tCount = new int[26];

    public static int maxSplits(String s, String t) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            tCount[t.charAt(i) - 'a']++;

            if (areArraysEqual(sCount, tCount)) {
                count++;
                sCount = new int[26];
                tCount = new int[26];
            }
        }

        return count;
    }

    private static boolean areArraysEqual(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int hashMapApproachMaxSplits(String s, String t) {
        int count = 0;
        int n = s.length();

        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (hm1.size() == 0 && s.charAt(i) == t.charAt(i)) {
                count++;
                hm1.clear();
                hm2.clear();
            } else {
                hm1.put(s.charAt(i), hm1.getOrDefault(s.charAt(i), 0) + 1);
                hm2.put(t.charAt(i), hm2.getOrDefault(t.charAt(i), 0) + 1);
                if (hm1.equals(hm2)) {
                    count++;
                    hm1.clear();
                    hm2.clear();
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        String s = "aaabc";
        String t = "aaacb";
        System.out.println(hashMapApproachMaxSplits(s, t)); // Output should be 4
    }
}
