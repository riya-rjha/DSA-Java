import java.util.*;

public class B_The_Third_Side {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
            for (int i = 0; i < n; i++) {
                pq.add(sc.nextInt());
            }
            int ans = 0;
            if (pq.size() == 1) ans = pq.poll();
            else {
                while (!pq.isEmpty()) {
                    if(pq.size() == 1) break;
                    int first = pq.poll();
                    int second = pq.poll();
                    int sum = (first + second) - 1;
                    pq.add(sum);
                }
                ans = pq.poll();
            }
            System.out.println(ans);
        }
    }
}