import java.util.*;

public class Deletion_and_Difference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            Map<Integer, Set<Integer>> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (!hm.containsKey(arr[i])) {
                    hm.put(arr[i], new HashSet<>());
                } else {
                    Set<Integer> set = hm.get(arr[i]);
                    set.add(i);
                    hm.put(arr[i], set);
                }
            }
            int cnt = 0;
            boolean flag = false;
            for (Map.Entry<Integer, Set<Integer>> entry : hm.entrySet()) {
                if (entry.getValue().size() != 0) {
                    cnt += entry.getValue().size() % 2;
                    flag = true;
                }
            }
            if(flag) System.out.println(cnt);
            else System.out.println(n);
        }
        sc.close();
    }
}