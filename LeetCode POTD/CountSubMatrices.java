import java.util.Arrays;

public class CountSubMatrices {

    static int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int[] arr : dp) {
            Arrays.fill(arr, 0);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = 1;
                    }
                } else {
                    if (matrix[i][j] == 1) {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }
            }
        }
        for (int[] is : dp) {
            System.out.println(Arrays.toString(is));
        }
        int sum = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // int[][] matrix = {
        // { 0, 1, 1, 1 },
        // { 1, 1, 1, 1 },
        // { 0, 1, 1, 1 }
        // };
        int[][] arr = {
                { 1, 0, 1 },
                { 1, 1, 0 },
                { 1, 1, 0 }
        };
        System.out.println(countSquares(arr));
    }
}
