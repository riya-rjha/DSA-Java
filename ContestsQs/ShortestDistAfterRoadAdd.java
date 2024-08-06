import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistAfterRoadAdd {

    private static List<List<Integer>> graph;

    public static int bfsAlgo(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean isVisited[] = new boolean[n];
        int dist[] = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        queue.add(0);
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println("Node: " + node);
            if (node == n - 1) {
                return dist[node];
            }
            for (int currEl : graph.get(node)) {
                if (!isVisited[currEl]) {
                    dist[currEl] = dist[node] + 1;
                    queue.add(currEl);
                    System.out.println("Current El: " + currEl);
                    System.out.println("Queue: " + queue);
                    isVisited[currEl] = true;
                }
            }

        }

        return -1;
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            graph.get(i).add(i + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int query[] : queries) {
            graph.get(query[0]).add(query[1]);
            ans.add(bfsAlgo(n));
        }
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = { { 2, 4 }, { 0, 2 }, { 0, 4 } };
        System.out.println(Arrays.toString(shortestDistanceAfterQueries(n, queries)));
    }
}
