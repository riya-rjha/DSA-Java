import java.util.*;

public class IPO {

    private static class Project {
        int capital;
        int profit;

        Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }
    }

    /*
     * Other way to write Lambda Expression using Comparator
     * Collection.sort(projects, new Comparator<Project>(){
     * 
     * @Override
     * public int compare(Project a, Project b){
     * return a.capital - b.capital;
     * }
     * })
     */

    public static int findMaximizedCapital(int k, int w, int profits[], int capital[]) {
        int n = profits.length;
        ArrayList<Project> project = new ArrayList<>();

        // Add every profit & capital to the list for every iteration
        for (int i = 0; i < n; i++) {
            project.add(new Project(capital[i], profits[i]));
        }

        // Sort capital to get the minimum possible buyPrice <=w
        Collections.sort(project, (a, b) -> a.capital - b.capital);

        // Create maxHeap to store max profits at the front of queue
        // By default, Priority Queue in Java is minHeap
        // Use Lambda expression to convert minHeap to maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);
        int i = 0;
        for (int j = 0; j < k; j++) {
            while (i < n && project.get(i).capital <= w) {
                maxHeap.add(project.get(i).profit);
                i++;
            }
            if (maxHeap.isEmpty()) {
                break;
            }
            w += maxHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int k = 3; // atmost number of projects
        int w = 0; // initial capital
        int profits[] = { 1, 2, 3 };
        int capital[] = { 0, 1, 2 };
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
}
