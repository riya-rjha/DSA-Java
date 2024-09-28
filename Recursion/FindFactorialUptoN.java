import java.util.ArrayList;

public class FindFactorialUptoN {

    // Brute Force
    static boolean isFactChecker(long n) {
        long fact = 1;
        for (long i = 1; i <= n; i++) {
            if (fact == n) {
                return true;
            }
            fact = fact * i;
        }
        if (fact == n) {
            return true;
        }
        return false;
    }

    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> lst = new ArrayList<>();
        for (long i = 1; i <= n; i++) {
            if (isFactChecker(i)) {
                lst.add(i);
            }
        }
        return lst;

    }

    // Optimized Approach
    static ArrayList<Long> optimizedFactorialUptoN(long n){
        ArrayList<Long> lst = new ArrayList<>();
        getListOfFactorialRecursive(1, 1, n, lst);
        return lst;
    }

    static void getListOfFactorialRecursive(long st, long fact, long n, ArrayList<Long> lst){
        if(st > n || fact > n){
            return;
        }
        lst.add(fact);
        getListOfFactorialRecursive(st + 1, fact * (st + 1), n, lst);
        return;
    }


    public static void main(String[] args) {
        int n = 100;
        // System.out.println(factorialNumbers(n));
        System.out.println(optimizedFactorialUptoN(n));
    }
}
