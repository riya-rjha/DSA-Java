import java.util.*;

public class Startup {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            List<List<Integer>> lst = new ArrayList<>();
            for (int i = 0; i <= k; i++) {
                lst.add(new ArrayList<>());
            }

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                lst.get(a).add(b);
            }

            List<Integer> cost = new ArrayList<>();

            for (List<Integer> costs : lst) {
                if (!costs.isEmpty()) {
                    costs.sort(Collections.reverseOrder());
                    int cost_values = 0;
                    for (int el : costs) {
                        cost_values += el;
                    }
                    cost.add(cost_values);
                }
            }

            cost.sort(Collections.reverseOrder());
            int sum = 0;
            for (int i = 0; i < Math.min(n, cost.size()); i++) {
                sum += cost.get(i);
            }

            System.out.println(sum);
        }

        sc.close();
    }
}
