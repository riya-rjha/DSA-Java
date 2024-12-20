import java.util.*;

public class A_Kevin_and_Combination_Lock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            // int x = 6369;
            // System.out.println("Current value of X: " + x);
            x = x % 33;
            String num = Integer.toString(x);
            if (x == 0 || num.contains("33")) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();

        PriorityQueue<Integer> pq1 = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return 1;
            }
            return -1;
        });

        PriorityQueue<Integer> pq2 = new PriorityQueue<>((b, a) -> {
            if (a < b) {
                return 1;
            }
            return -1;
        });

        PriorityQueue<Integer> pq3 = new PriorityQueue<>((a, b) -> {
            if (a > b) {
                return -1;
            }
            return 0;
        });

        PriorityQueue<Integer> pq4 = new PriorityQueue<>((a, b) -> {
            if (a < b) {
                return -1;
            }
            return 1;
        });

        pq1.add(5);
        pq1.add(8);
        pq1.add(1);
        pq1.add(10);
        pq1.add(4);

        pq2.add(5);
        pq2.add(8);
        pq2.add(1);
        pq2.add(10);
        pq2.add(4);

        pq3.add(13);
        pq3.add(10);
        pq3.add(41);
        pq3.add(15);
        pq3.add(28);
        pq3.add(17);

        pq4.add(10);
        pq4.add(4);
        pq4.add(6);
        pq4.add(1);
        pq4.add(9);

        System.out.println("PriorityQueue 1: " + pq1);
        System.out.println("PriorityQueue 2: " + pq2);
        System.out.println("PriorityQueue 3: " + pq3);
        System.out.println("PriorityQueue 4: " + pq4);

    }
}