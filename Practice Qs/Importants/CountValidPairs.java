public class CountValidPairs {

    public static int GCD(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        
        for (int i = min; i >= 1; i--) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public long validPairs(int a[], int b[], int n, int m) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int gcd = GCD(a[i], b[j]);
                if (gcd > 1) {
                    System.out.println("(" + a[i] + ", " + b[j] + ")");
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountValidPairs cp = new CountValidPairs();
        int[] a = {2, 3, 4};
        int[] b = {4, 5, 6};
        long result = cp.validPairs(a, b, a.length, b.length);
        System.out.println("Number of valid pairs: " + result);
    }
}
