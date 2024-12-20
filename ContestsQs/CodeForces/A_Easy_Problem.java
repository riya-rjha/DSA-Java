package CodeForces;
import java.util.*;

public class A_Easy_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Map<Integer, Integer> hm = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                hm.put(i, i);
            }
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                if(hm.containsKey(n - entry.getKey())){
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}