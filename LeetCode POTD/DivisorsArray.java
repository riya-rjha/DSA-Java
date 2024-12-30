import java.util.*;

public class DivisorsArray {
    public static long countDivs(long n) {
        Map<Long, Long> hm = new HashMap<>();
        for (long i = 2; i <= Math.sqrt(n); i++) {
            while (n % i == 0) {
                hm.put(i, hm.getOrDefault(i, 0L) + 1);
                n = n / i;
            }
        }
        if (n > 1) {
            hm.put(n, hm.getOrDefault(n, 0L) + 1);
        }
        long ans = 1;
        for (Map.Entry<Long, Long> entry : hm.entrySet()) {
            long val = entry.getValue();
            ans = (ans * (val + 1)) % 1000000007;
        }
        return ans;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long fact = 1;
        for (int i = 1; i <= m; i++) {
            fact = fact * i;
        }
        for (int el : arr) {
            long num = fact * el;
            long divisors = countDivs(num);
            System.out.print(divisors + " ");
        }
        sc.close();
    }
}
