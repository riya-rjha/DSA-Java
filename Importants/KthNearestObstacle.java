import java.util.Arrays;
import java.util.TreeSet;

public class KthNearestObstacle {

    // Works only for 2 testcases
    public int[] resultsArrayBruteForce(int[][] queries, int k) {
        int[] result = new int[queries.length];
        int count = 0;

        for (int i = 0; i < queries.length; i++) {
            if (queries[0][0] <= k && queries[0][1] <= k) {
                result[0] = -1;
                count++;
                i++;
                queries[0][0] = Integer.MAX_VALUE;
            }
            int a = queries[i][0];
            int b = queries[i][1];
            int ans = Math.abs(a) + Math.abs(b);
            result[count] = ans;
            count++;
        }
        return result;
    }

    // Optimized Solution
    // Use trees to calculate Manhattan distance and keep them in order
    // Manhattan distance is the distance between two points in a grid system

    public int[] resultsArray(int[][] queries, int k) {
        TreeSet<Integer> tree = new TreeSet<>();
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            tree.add(Math.abs(queries[i][0]) + Math.abs(queries[i][1]));
            if (tree.size() >= k) {
                result[i] = tree.toArray(new Integer[0])[tree.size() - k];
            } else {
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] queries = { { 5, 5 }, { 4, 4 }, { 3, 3 } };
        int k = 2;
        KthNearestObstacle s = new KthNearestObstacle();
        System.out.println(Arrays.toString(s.resultsArray(queries, k)));
    }
}
