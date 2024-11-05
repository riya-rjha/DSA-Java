import java.util.*;

public class GoodNodesCounter {
    // Class to represent the solution
    static class Solution {
        private int ans = 0;

        public int countGoodNodes(int[][] edges) {
            int n = edges.length;

            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++)
                adj.add(new ArrayList<>());

            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                System.out.println(adj.get(edge[0]));
                adj.get(edge[1]).add(edge[0]);
            }

            dfs(adj, 0, -1);
            return ans;
        }

        private int dfs(List<List<Integer>> adj, int node, int parent) {
            Set<Integer> set = new HashSet<>();
            int total = 1;
            for (int nd : adj.get(node)) {
                if (nd != parent) {
                    int c = dfs(adj, nd, node);
                    total += c;
                    set.add(c);
                }
            }

            if (set.size() < 2)
                ans++;
            return total;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1
        int[][] edges1 = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 } };
        System.out.println(solution.countGoodNodes(edges1)); // Output: 7

        // Example 2
        int[][] edges2 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 0, 5 }, { 1, 6 }, { 2, 7 }, { 3, 8 } };
        System.out.println(solution.countGoodNodes(edges2)); // Output: 6
    }
}
