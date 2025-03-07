import java.util.*;

public class LC438 {

    public static boolean hasSameDigits(String s) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int curr = Integer.parseInt(String.valueOf(s.charAt(i)));
            numbers.add(curr);
        }
        while (numbers.size() > 2) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < numbers.size() - 1; i++) {
                int fs = numbers.get(i);
                int sec = numbers.get(i + 1);
                int sum = (fs + sec) % 10;
                ans.add(sum);
            }
            numbers = ans;
            // System.out.println(numbers);
        }
        return numbers.get(0) == numbers.get(1);
    }

    public static long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int n = grid.length;

        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
            int count = Math.min(limits[i], grid[i].length);
            for (int j = grid[i].length - 1; j >= grid[i].length - count; j--) {
                pq.add(grid[i][j]);
            }
        }

        long sum = 0;
        while (k-- > 0 && !pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        // String s = "34789";
        String s = "0761";
        // String s = "323";
        // String s = "3902";
        System.out.println(hasSameDigits(s));

        int[][] grid = { { 5, 3, 7 }, { 8, 2, 6 } };
        int[] limits = { 2, 2 };
        int k = 3;

        // int[][] grid = new int[][] { { 1, 2 }, { 3, 4 } };
        // int[] limits = new int[] { 1, 2 };
        // int k = 2;

        System.out.println(maxSum(grid, limits, k));

    }
}
