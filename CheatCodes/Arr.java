package CheatCodes;

import java.util.*;

public class Arr {
    public static void main(String[] args) {

        // Contest Driver Code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
        }
        sc.close();

    }
}
