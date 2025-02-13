package CodeForces;

import java.util.*;

public class A_Preparing_for_the_Olympiad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] A = new int[n];
            int[] B = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < B.length; i++) {
                B[i] = sc.nextInt();
            }
            int res = A[n - 1];
            for (int i = 0; i < n - 1; i++) {
                if (A[i] > B[i + 1]) {
                    res += (A[i] - B[i + 1]); 
                }
            }
            System.out.println(res);
        }
        sc.close();
    }
}