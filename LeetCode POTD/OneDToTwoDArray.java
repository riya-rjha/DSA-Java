import java.util.Arrays;

public class OneDToTwoDArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][n];
        if (original.length > m * n) {
            return arr;
        }
        for (int i = 0; i < n; i++) {
            arr[0][i] = original[i];
        }
        for (int i = 0; i < m; i++) {
            for (int j = n; j < 2 * n; j++) {
                arr[i][j] = original[i];
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] original = { 1, 2, 3, 4 };
        int m = 2, n = 2;
        OneDToTwoDArray ans = new OneDToTwoDArray();
        int[][] arr = ans.construct2DArray(original, m, n);
        System.out.println(Arrays.deepToString(arr));
    }
}
