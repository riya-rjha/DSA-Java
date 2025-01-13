import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class EqualPairs {

    public static int ans(int[] arr, int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        int count_zeroes = 0;
        int maxVal = -1;
        int maxIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                // either put 0 for first occurrence or
                // add 1 to previous value of number of occurrences
                hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
                if (hm.get(arr[i]) > maxIdx) {
                    // Store number with most occurrences
                    maxIdx = hm.get(arr[i]);
                    maxVal = arr[i];
                }
            }
            else  {
                count_zeroes++;
            }
        }

        if (maxVal != -1) {
            hm.put(maxVal, count_zeroes + maxIdx);
        } else {
            hm.put(0, count_zeroes);
            return count_zeroes;
        }

        int res = 0;
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int currVal = entry.getValue();
            if (currVal > 1) {
                // formula to make pairs with similar numbers
                // Explanation: The key in hashmap has corresponing value of the number of
                // occurrences
                // it occurrend in the array. Now for 4 occurrences of a number 1, there can be
                // 6 possible pairs that can be formed with itself
                // ie. 3+2+1 = 6
                // ie, sum of numbers upto n - 1
                res += currVal * (currVal - 1) / 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(ans(arr, n));
        }
        sc.close();
    }
}