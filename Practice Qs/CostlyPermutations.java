import java.util.*;

public class CostlyPermutations {
    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                arr[i] = sc.nextInt();
            }
            List<Integer> cycle = new ArrayList<>();
            boolean[] isVisited = new boolean[n + 1];
            int i = 1;
            while (i <= n) {
                if (!isVisited[i]) {
                    int size = 0;
                    int curr = i;
                    while (!isVisited[curr]) {
                        isVisited[curr] = true;
                        curr = arr[curr];
                        size++;
                    }
                    cycle.add(size);
                }
                i++;
            }
            boolean flag = true;
            if (cycle.size() == 1) {
                System.out.println(0);
                flag = false;
            }
            long minTotCost = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int el : cycle) {
                pq.offer(el);
            }
            if (flag) {
                while (pq.size() > 1) {
                    int first = pq.poll();
                    int second = pq.poll();
                    minTotCost += first + second;
                    pq.add(first + second);
                }
                System.out.println(minTotCost);
            }
        }
        sc.close();

    }
}
