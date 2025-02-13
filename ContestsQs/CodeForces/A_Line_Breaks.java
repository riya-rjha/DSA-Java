package CodeForces;

import java.util.*;

public class A_Line_Breaks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            String[] arr = new String[n];
            int count = 0;
            int i = 0;
            for (i = 0; i < arr.length; i++) {
                arr[i] = sc.next();
            }
            i = 0;
            for (i = 0; i < arr.length; i++) {
                count += arr[i].length();
                if (count > m) {
                    break;
                }
            }
            if (i == 0)
                System.out.println(0);
            else
                System.out.println(i);
        }
        sc.close();
    }
}