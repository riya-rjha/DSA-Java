import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

class Solution {

    private void dfs(List<Integer>[] graph, int sus, boolean[] isVisited, Set<Integer> susMethods) {
        if (isVisited[sus]) {
            return;
        }
        isVisited[sus] = true;
        susMethods.add(sus);
        for (int neighbour : graph[sus]) {
            dfs(graph, neighbour, isVisited, susMethods);
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] invo : invocations) {
            graph[invo[0]].add(invo[1]);
        }
        boolean[] isVisited = new boolean[n];
        Set<Integer> sus = new HashSet<>();
        dfs(graph, k, isVisited, sus);

        for (int i = 0; i < n; i++) {
            if (!sus.contains(i)) {
                for (int neighbor : graph[i]) {
                    if (sus.contains(neighbor)) {
                        return new ArrayList<>();
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!sus.contains(i)) {
                ans.add(i);
            }
        }
        return ans;
    }
}

public class RemoveMethodsFromProject {
    public static void main(String[] args) {
        int n = 5, k = 0;
        Solution ans = new Solution();
        int[][] invocations = { { 1, 2 }, { 0, 2 }, { 0, 1 }, { 3, 4 } };
        System.out.println(ans.remainingMethods(n, k, invocations));
    }
}
