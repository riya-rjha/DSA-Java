import java.util.Arrays;

public class SpiralMatrix {

    static class Solution {

        public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
            int[][] dir = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
            int[][] traversed = new int[rows * cols][2];
            int idx = 0;

            for (int step = 1, direction = 0; idx < rows * cols;) {
                for (int i = 0; i < 2; ++i) {
                    for (int j = 0; j < step; ++j) {
                        if (rStart >= 0 &&
                                rStart < rows &&
                                cStart >= 0 &&
                                cStart < cols) {
                            traversed[idx][0] = rStart;
                            System.out.println("Traversed: " + Arrays.deepToString(traversed) + " ");
                            traversed[idx][1] = cStart;
                            ++idx;
                        }
                        rStart += dir[direction][0];
                        cStart += dir[direction][1];
                    }

                    direction = (direction + 1) % 4;
                }
                ++step;
            }
            return traversed;
        }
    }

    public static void main(String[] args) {
        Solution ans = new Solution();
        int rows = 5;
        int cols = 6;
        int rStart = 1;
        int cStart = 4;
        int answer[][] = ans.spiralMatrixIII(rows, cols, rStart, cStart);
        System.err.println(Arrays.deepToString(answer));
    }
}
