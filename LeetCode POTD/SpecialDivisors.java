public class SpecialDivisors {

    public static int noOfDiv(int n) {
        int count = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i <= n - 1; i++) {
            if (n % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static int nonSpecialCount(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            if (noOfDiv(i) != 2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(nonSpecialCount(5392, 26050));
    }
}
