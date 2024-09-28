import java.util.ArrayList;

public class KsizedSubArrMax {

    // Brute Force (Does not work for all testcases)
    public static ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int currMax = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < i + k; j++) {
                if (j < arr.length && arr[j] > max) {
                    currMax = arr[j];
                    max = Math.max(max, currMax);
                }
            }
            ans.add(max);
        }
        for (int i = ans.size() - k + 1; i < ans.size(); i++) {
            ans.remove(i);
        }
        ans.remove(ans.size() - 1);
        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = { 8, 5, 10, 7, 9, 4, 15, 12, 90, 13 };
        // int k = 4;
        int[] arr = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        int k = 3;
        System.out.println(max_of_subarrays(k, arr));
    }
}
