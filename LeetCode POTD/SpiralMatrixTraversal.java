import java.util.*;

public class SpiralMatrixTraversal {

    static ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int sr = 0;
        int sc = 0;
        int er = n - 1;
        int ec = m - 1;
        while (sr < er) {
            for (int j = sc; j <= ec; j++) {
                ans.add(matrix[sr][j]);
            }
            for (int i = sr + 1; i <= er; i++) {
                ans.add(matrix[i][ec]);
            }
            for (int j = ec - 1; j >= sc; j--) {
                ans.add(matrix[er][j]);
            }
            for (int i = er - 1; i >= sr + 1; i--) {
                ans.add(matrix[i][sc]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 7, 8, 9, 10, 11, 12 }, { 13, 14, 15, 16, 17, 18 } };
        System.out.println(spirallyTraverse(matrix));
    }
}
