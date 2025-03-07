// package LeetCode;

import java.util.Arrays;

// import java.util.*;

public class LC437 {
    public static boolean hasSpecialSubstring(String s, int k) {
        int n = s.length();
        if (k > n)
            return false;
        boolean flag = false;

        for (int i = 0; i <= n - k; i++) {
            flag = true;
            String newStr = s.substring(i, i + k);

            for (int l = 0; l < newStr.length() - 1; l++) {
                if (newStr.charAt(l) != newStr.charAt(l + 1)) {
                    flag = false;
                    break;
                }
            }

            if (!flag)
                continue;

            if ((i > 0 && s.charAt(i - 1) == newStr.charAt(0)) ||
                    (i + k < n && s.charAt(i + k) == newStr.charAt(0))) {
                continue;
            }

            return true;
        }
        return false;
    }

    public static long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int n = pizzas.length;
        int m = n / 4;
        int odd = (m + 1) / 2;
        int even = m - odd;
        long tot = 0;
        int cnt = n - 1;
        for (int i = 0; i < odd; i++) {
            tot += pizzas[cnt];
            cnt--;
        }
        for (int i = 0; i < even; i++) {
            cnt--;
            int Y = pizzas[cnt];
            cnt--;
            tot += Y;
        }
        return tot;
    }

    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(hasSpecialSubstring(s, k));
        // int[] pizzas = { 2, 1, 1, 1, 1, 1, 1, 1 };
        int[] pizzas = { 1, 2, 3, 4, 5, 6, 7, 8 };
        // int[] pizzas = { 2,5,2,3 };
        System.out.println(maxWeight(pizzas));
    }
}
