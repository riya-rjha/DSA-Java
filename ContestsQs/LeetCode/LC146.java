import java.util.Arrays;

public class LC146 {

    static int countSubarrays(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int n1 = nums[i];
            int n2 = nums[i + 1];
            int n3 = nums[i + 2];
            float floatVal = n2 / (float) 2;
            System.out.println(floatVal);
            if (n1 + n3 == floatVal) {
                count++;
            }
        }
        if (nums.length == 3) {
            float floorVal = nums[1] / (float) 2;
            System.out.println(floorVal);
            if (nums[0] + nums[2] == floorVal) {
                return 1;
            }
        }
        return count;
    }

    static int countPathsWithXorValue(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][16];
        for (int[][] is : dp) {
            for (int[] is2 : is) {
                Arrays.fill(is2, 0);
            }
        }
        dp[0][0][grid[0][0]] = 1;
        int xorVal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int j2 = 0; j2 < 16; j2++) {
                    if (dp[i][j][j2] > 0) {
                        int currVal = j2;
                        int prev = dp[i][j][currVal];
                        if (j + 1 < m) {
                            int right = grid[i][j + 1];
                            xorVal = currVal ^ right;
                            dp[i][j + 1][xorVal] = (dp[i][j + 1][xorVal] + prev) % 1000000007;
                        }
                        if (i + 1 < n) {
                            int down = grid[i + 1][j];
                            xorVal = currVal ^ down;
                            dp[i + 1][j][xorVal] = (dp[i + 1][j][xorVal] + prev) % 1000000007;
                        }
                    }
                }
            }
        }
        return (dp[n - 1][m - 1][k]);
    }

    public static void main(String[] args) {
        // int[] nums = { -1, -4, -1, 4 };
        // System.out.println(countSubarrays(nums));
        int[][] grid = { { 2, 1, 5 }, { 7, 10, 0 }, { 12, 6, 4 } };
        System.out.println(countPathsWithXorValue(grid, 11));
    }
}
