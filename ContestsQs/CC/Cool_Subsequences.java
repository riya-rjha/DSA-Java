import java.util.*;

public class Cool_Subsequences {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Map<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            }
            int ansCnt = 0;
            List<Integer> ans = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                int val = entry.getValue();
                int key = entry.getKey();
                if (val > 1) {
                    ansCnt = 1;
                    ans.add(key);
                    break;
                }
            }
            if (ansCnt == 1) {
                System.out.println(ansCnt);
                System.out.println(ans.get(0));
            }else{
                System.out.println(-1);
            }
        }
        sc.close();
    }
}