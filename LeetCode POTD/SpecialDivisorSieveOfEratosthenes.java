import java.util.*;

public class SpecialDivisorSieveOfEratosthenes {

    // Sieve of Eratosthenes to find all primes up to a certain n
    private List<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    public int nonSpecialCount(int l, int r) {
        int sqrtR = (int) Math.sqrt(r);
        List<Integer> primes = sieve(sqrtR);
        Set<Integer> specialNumbers = new HashSet<>();

        for (int p : primes) {
            int pSquare = p * p;
            if (pSquare >= l && pSquare <= r) {
                specialNumbers.add(pSquare);
            }
        }

        int totalCount = r - l + 1;
        int specialCount = specialNumbers.size();

        return totalCount - specialCount;
    }

    public static void main(String[] args) {
        SpecialDivisorSieveOfEratosthenes solution = new SpecialDivisorSieveOfEratosthenes();
        System.out.println(solution.nonSpecialCount(5, 7)); 
    }
}

