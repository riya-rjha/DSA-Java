public class CountValidPairs {

    public static int GCD(int a, int b) {
        int min = 0;
        int max = 0;
        if (a < b) {
            min = a;
            max = b;
        } else {
            min = b;
            max = a;
        }
        for (int i = 1; i < min; i++) {
            if (max % i == 0 && min % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public long validPairs(int a[], int b[], int n, int m) {
        int pair;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int gcd = GCD(a[i], b[j]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
