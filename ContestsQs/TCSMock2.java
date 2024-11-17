import java.util.*;

public class TCSMock2 {

    public static int hammingDistance(String str, int A, int B) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '0' && str.charAt(i) != '1') {
                return -1;
            }
        }
        int zeroes = 0;
        int ones = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                zeroes++;
            } else {
                ones++;
            }
        }
        int count = 0;
        String newStr = "";
        if (A < B) {
            newStr = "0".repeat(zeroes) + "1".repeat(ones);
        } else {
            newStr = "1".repeat(ones) + "0".repeat(zeroes);
        }
        for (int i = 0; i < newStr.length(); i++) {
            if (str.charAt(i) != newStr.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    public static void helper(int n, int m, int[][] arr, int[][] dp, int i, int j) {
        int curr = arr[i][j];
        if (i + 1 < n && arr[i + 1][j] >= curr) {
            dp[i + 1][j] += 1;
            helper(n, m, arr, dp, i + 1, j);
        }
        if (j + 1 < m && arr[i][j + 1] >= curr) {
            dp[i][j + 1] += 1;
            helper(n, m, arr, dp, i, j + 1);
        }
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t-- > 0) {
        // String str = sc.next();
        // int A = sc.nextInt();
        // int B = sc.nextInt();
        // int ans = hammingDistance(str, A, B);
        // if (ans == -1) {
        // System.out.println("Invalid");
        // } else {
        // System.out.println(ans);
        // }
        // }
        // sc.close();
        // String str = "0100";
        // int A = 3;
        // int B = 2;
        // int ans = hammingDistance(str, A, B);
        // if (ans == -1) {
        // System.out.println("Invalid");
        // } else {
        // System.out.println(ans);
        // }

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int[][] dp = new int[n][m];
        boolean flag = false;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                helper(n, m, arr, dp, i, j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == k) {
                    flag = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!flag) {
            System.out.println("NO");
        }
        sc.close();
    }
}