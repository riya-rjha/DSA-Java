import java.util.*;

public class LC430 {

    static int minimumOperations(int[][] grid) {
        int cnt = 0;
        int m = grid[0].length;
        int n = grid.length;
        int i = 0;
        int j = 0;

        while (j < m) {
            List<Integer> lst = new ArrayList<>();
            i = 0;
            while (i < n) {
                lst.add(grid[i][j]);
                i++;
            }
            for (int k = 0; k < lst.size() - 1; k++) {
                if (lst.get(k) >= lst.get(k + 1)) {
                    while (lst.get(k + 1) != lst.get(k) + 1) {
                        lst.set(k + 1, lst.get(k + 1) + 1);
                        cnt++;
                    }
                }
                if (k == lst.size() - 2 && lst.size() == 2) {
                    // System.out.println(k + "k: " + " " + (k - 1));
                    if (lst.get(lst.size() - 1) <= lst.get(k + 1)) {
                        while (lst.get(lst.size() - 1) > lst.get(k + 1)) {
                            lst.set(lst.size() - 1, lst.get(k) + 1);
                            cnt++;
                        }
                    }
                }
            }
            j++;
        }
        return cnt;
    }

    static String answerString(String word, int cnt) {
        return "";
    }

    static long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        long[] dp = new long[n * n * n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            int j = i + 2;
            while (j < n) {
                for (int k = j + 2; k < n; k++) {
                    long pr = (long) nums[i] * nums[k];
                    dp[idx++] = pr;

                    int s = k + 2;
                    while (s < n) {
                        long qs = (long) nums[j] * nums[s];
                        if (pr == qs) {
                            cnt++;
                        }
                        s++;
                    }
                }
                j++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        // int[][] grid = { { 50 }, { 0 } };
        // System.out.println(minimumOperations(grid));

        // String word = "dbca";
        // int numFriends = 2;
        // System.out.println(answerString(word, numFriends));

        int[] nums = { 1, 2, 3, 4, 3, 6, 1 };
        System.out.println(numberOfSubsequences(nums));
    }
}