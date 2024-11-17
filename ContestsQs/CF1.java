import java.util.Arrays;
import java.util.Scanner;

public class CF1 {

    public static void Quintomania(Scanner sc) {
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] brandCost = new int[k];
            for (int i = 0; i < k; i++) {
                int brand = sc.nextInt();
                int cost = sc.nextInt();
                brandCost[brand - 1] += cost;
            }
            Arrays.sort(brandCost);
            int sum = 0;
            for (int i = k - 1; i >= k - Math.min(n, k); i--) {
                sum += brandCost[i];
            }
            System.out.println(sum);
        }
    }

    public static String AnyaAnd100(int i, int v, char[] arr) {
        if (arr.length < 4) {
            return "NO";
        }
        char new_v = '0';
        if (v == 1) {
            new_v = '1';
        }
        arr[i - 1] = new_v;
        for (int j = 0; j < arr.length - 3; j++) {
            if (arr[j] == '1' && arr[j + 1] == '1' && arr[j + 2] == '0' && arr[j + 3] == '0') {
                return "YES";
            }
        }
        return "NO";
    }

    public static int Love1543(int n, int m, int[][] arr) {
        int[] layer = new int[Math.max(n, m)];
        int pos = 0;
        int count = 0;
        for (int curr = 0; curr * 2 < n && curr * 2 < m; curr++) {
            pos = 0;
            // Top Row
            for (int j = curr; j < m - curr; j++) {
                layer[pos++] = arr[curr][j];
            }
            // Right Column
            for (int i = curr + 1; i < n - curr; i++) {
                layer[pos++] = arr[i][m - curr - 1];
            }
            // Bottom Row
            if (curr < n - curr - 1) {
                for (int j = m - curr - 2; j >= curr; j--) {
                    layer[pos++] = arr[n - curr - 1][j];
                }
            }
            // Left Column
            if (curr < m - curr - 1) {
                for (int i = n - curr - 2; i > curr; i--) {
                    layer[pos++] = arr[i][curr];
                }
            }
            // Check for 1543
            for (int i = 0; i < pos; i++) {
                if (layer[i] == 1 && layer[(i + 1) % pos] == 5 && layer[(i + 2) % pos] == 4
                        && layer[(i + 3) % pos] == 3) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // Quintomania(sc);
        Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t-- > 0) {
        // String s = sc.next();
        // char[] arr = s.toCharArray();
        // int q = sc.nextInt();
        // while (q-- > 0) {
        // int i = sc.nextInt();
        // int v = sc.nextInt();
        // System.out.println(AnyaAnd100(i, v, arr));
        // }
        // }

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                String line = sc.next();
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Character.getNumericValue(line.charAt(j));
                }
            }
            System.out.println(Love1543(n, m, arr));
        }

        sc.close();
    }
}
