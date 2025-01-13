import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CircleOfStrings {

    public static void dfs(char u, Map<Character, List<Character>> graph, boolean[] vis) {
        vis[u - 'a'] = true;
        for (char v : graph.get(u))
            if (vis[v - 'a'] == false)
                dfs(v, graph, vis);
    }

    static int isCircle(String A[]) {
        Map<Character, List<Character>> graph = new HashMap<>();
        for (String str : A) {
            graph.computeIfAbsent(str.charAt(0), l -> new ArrayList<>()).add(str.charAt(str.length() - 1));
            graph.computeIfAbsent(str.charAt(str.length() - 1), l -> new ArrayList<>()).add(str.charAt(0));
        }

        /* traverse in the graph and compute visited array for cycle detect */
        char u = A[0].charAt(0);
        boolean[] vis = new boolean[26];
        dfs(u, graph, vis);

        /* find cycle in a graph */
        for (char c = 'a'; c <= 'z'; c++) {
            if (graph.containsKey(c) && vis[c - 'a'] == false)
                return 0;
            if (graph.containsKey(c) && graph.get(c).size() % 2 == 1)
                return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        String[] arr = { "ab", "bc", "cd", "da" };
        System.out.println(isCircle(arr));

    }
}
