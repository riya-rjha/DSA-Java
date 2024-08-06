public class SumOfSquareNo {

    // TLE Error
    // TC - O(n)
    public static boolean judgeSquareSumBruteForce(int c) {
        for (int i = 0; i * i <= c; i++) {
            for (int j = 0; j * j <= c; j++) {
                if ((i * i + j * j) == c) {
                    return true;
                }
            }
        }
        return false;
    }

    // Optimized Brute Force
    // O(root c * log c)
    // O(Root c) - iteration over c
    // O(log c) - Finding square root of b
    public static boolean judgeSquareSumOptimizedBruteForce(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    // Binary Search
    // O(root c * log c)
    public static boolean binSearchJudgeSquareSum(int c) {
        return false;
    }

    public static void main(String[] args) {
        int c = 5;
        System.out.println("By Brute Force: " + judgeSquareSumBruteForce(c));
        System.out.println("By Optimized Brute Force: " + judgeSquareSumOptimizedBruteForce(c));
    }
}
