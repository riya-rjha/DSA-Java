import java.util.*;

public class LC431 {

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            long pr = 1;
            int gcd = 0;
            int lcm = 1;
            for (int j = i; j < n; j++) {
                if (pr > Long.MAX_VALUE / nums[j]) {
                    break;
                }
                pr = pr * nums[j];
                gcd = (j == i) ? nums[j] : gcd(gcd, nums[j]);
                lcm = (j == i) ? nums[j] : (lcm / gcd(lcm, nums[j])) * nums[j];
                if (pr == gcd * lcm) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    static Map<Character, Character> alphabets = new HashMap<>();

    static class Pair {
        boolean mark;
        int idx;
        char curr;
        char mirror;

        public Pair(boolean mark, int idx, char curr, char mirror) {
            this.mark = mark;
            this.idx = idx;
            this.curr = curr;
            this.mirror = mirror;
        }
    }

    public long calculateScore(String s) {
        for (char i = 'a'; i <= 'z'; i++) {
            alphabets.put(i, (char) ('z' - (i - 'a')));
        }
        Map<Pair, Integer> map = new HashMap<>();
        boolean[] used = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int idx = i;
            char curr = s.charAt(i);
            char mirror = alphabets.get(curr);
            if (!s.contains(String.valueOf(mirror))) {
                continue;
            }
            int mirrorIndex = -1;
            for (int j = i - 1; j >= 0; j--) {
                if (!used[j] && s.charAt(j) == mirror) {
                    mirrorIndex = j;
                    break;
                }
            }

            if (mirrorIndex != -1 && !used[i]) {
                map.put(new Pair(false, idx, curr, mirror), mirrorIndex);
                used[i] = true;
                used[mirrorIndex] = true;
            }
        }
        // for (Map.Entry<Pair, Integer> entry : map.entrySet()) {
        //     System.out.print(entry.getKey().mark);
        //     System.out.print(entry.getKey().idx);
        //     System.out.print(entry.getKey().curr);
        //     System.out.print(entry.getKey().mirror);
        //     System.out.println(entry.getValue());
        //     System.out.println();
        // }
        long ans = 0;
        for (Map.Entry<Pair, Integer> entry : map.entrySet()) {
            boolean marked = entry.getKey().mark;
            int i = entry.getKey().idx;
            int j = entry.getValue();
            System.out.println(i + " " + j);
            if (j < i && !marked) {
                ans += i - j;
                System.out.println("Answer calc");
            }
        }
        return ans;
    }

    public long getScore(String s) {
        for (char i = 'a'; i <= 'z'; i++) {
            alphabets.put(i, (char) ('z' - (i - 'a')));
        }
        Map<Character, int[]> index = new HashMap<>();
        long score = 0;
        for (int i = 0; i < s.length(); i++) {
            char mirror = alphabets.get(s.charAt(i));
            if (index.get(mirror).length != 0) {
                int[] mirrorIndices = index.get(mirror);
                int j = mirrorIndices[mirrorIndices.length - 1];
                index.remove(mirror);
                score += (i - j);
            } else {
                index.put(s.charAt(i), new int[] { i });
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 2, 1, 1, 1 };
        LC431 lc = new LC431();
        System.out.println(lc.maxLength(nums));

        String s = "aczzx";
        System.out.println(lc.getScore(s));

    }
}