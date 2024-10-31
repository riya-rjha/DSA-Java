import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MultiplyToMinimize {
    public static int[] getAns(int[] arr, int n) {
        int count = 0;
        int[] ans = new int[n];
        Set<Long> set = new HashSet<>();
        for (int el : arr) {
            if (!set.contains((long) el)) {
                set.add((long) el);
            } else {
                long t = el;
                while (set.contains(t)) {
                    set.remove(t);
                    t = t * 2;
                }
                set.add(t);
            }
            ans[count] = set.size();
            count++;
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = getAns(arr, n);
            for (int el : ans) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        sc.close();

    }
}
