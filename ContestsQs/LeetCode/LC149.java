import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class LC149 {

    public static int count(int n, String s) {
        int freq = 0;
        String ch = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch.charAt(0)) {
                freq++;
            }
        }
        return freq;
    }

    public static String findValidPair(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            int num1 = Integer.parseInt(String.valueOf(s.charAt(i)));
            int num2 = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
            int c1 = count(num1, s);
            int c2 = count(num2, s);
            if (c1 == num1 && c2 == num2 && c1 != c2) {
                String ans = String.valueOf(num1) + num2;
                return ans;
            }
        }
        return "";
    }

    public static int maxFreeTime(int eventTime, int k, int[] st, int[] end) {
        int n = st.length;
        List<Integer> diff = new ArrayList<>();
        diff.add(st[0] - 0); 
        for (int i = 1; i < n; i++) {
            diff.add(st[i] - end[i - 1]); 
        }
        diff.add(eventTime - end[n - 1]); 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int gap : diff) {
            pq.offer(gap);
        }
        for (int i = 0; i < k; i++) {
            if (!pq.isEmpty()) {
                int maxDiff = pq.poll();
                pq.offer(maxDiff + 1); 
            }
        }
        if(pq.isEmpty()) return 0;
        return pq.poll();
    }

    public static void main(String[] args) {
        String s = "22";
        System.out.println(findValidPair(s));

        int eventTime = 5, k = 1;
        int[] st = { 1, 3 }, end = { 2, 5 };
        System.out.println(maxFreeTime(eventTime, k, st, end));
    }
}
