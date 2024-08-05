import java.util.*;

public class SpecialDivisorSieveOfEratosthenes {

    public static int printPrimes(int l, int r) {
        int n = (int) Math.sqrt(r);
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j = j + i) {
                    isPrime[j] = false; // not prime for every multiple of i
                }
            }
        }

        int specialDivisorCount = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                int square = i * i; // find multiples of prime no i
                if (square >= l && square <= r) {
                    specialDivisorCount++;
                }
            }
        }

        int notSpecialDivisorCount = (r - l + 1) - specialDivisorCount; 
        return notSpecialDivisorCount;
    }

    public static void main(String[] args) {
        System.out.println(printPrimes(4, 16));
    }
}
