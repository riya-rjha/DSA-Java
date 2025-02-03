import java.util.*;

public class C_Game_of_Mathletes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Map<Integer, Integer> hm = new HashMap<>();
            for (int i = 0; i < n; i++) {
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
            }
            int score = 0;
            for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
                int key = entry.getKey();
                int val = entry.getValue();
                int diff = k - key;                
                if (hm.containsKey(diff)) {
                    int cnt = Math.min(val, hm.get(diff));
                    if (key == diff) {
                        cnt /= 2;  
                    }
                    score += cnt;
                    hm.put(key, hm.get(key) - cnt);
                    hm.put(diff, hm.get(diff) - cnt);
                }
            }
            System.out.println(score);
        }
        sc.close();
    }
}