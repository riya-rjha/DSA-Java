import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static ArrayList<Integer> bfsAlgo(int n, ArrayList<Integer>adjacenyList){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean isVisited [] = new boolean[n];

        queue.add(0);
        isVisited[0] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            bfs.add(node);

            for (Integer currEl : adjacenyList) {
                if(isVisited[currEl] == false){
                    isVisited[currEl] = true;
                    queue.add(currEl);
                }
            }

        }

        return bfs;
    }

    public static void main(String[] args) {
        int n = 6; // Number of nodes
        ArrayList<Integer> adjacencyList = new ArrayList<>();
        adjacencyList.add(1); // Node 0 is connected to Node 1
        adjacencyList.add(2); // Node 0 is connected to Node 2
        adjacencyList.add(3); // Node 0 is connected to Node 3
        adjacencyList.add(4); // Node 0 is connected to Node 4
        adjacencyList.add(5); // Node 0 is connected to Node 5

        ArrayList<Integer> bfsResult = bfsAlgo(n, adjacencyList);
        System.out.println("BFS traversal: " + bfsResult);
    }
}
