import java.util.Arrays;

public class OneDToTwoDArray {

    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] arr = new int[m][n];
        if (original.length != m * n) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            // start from index 0, then add n, that is value of columns
            // for each next row
            // for ending point, use the start index and add every time
            // value of column length
            arr[i] = Arrays.copyOfRange(original, i * n, i * n + n);
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
