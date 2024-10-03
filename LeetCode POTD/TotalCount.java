class Solution {
    int totalCount(int k, int[] arr) {
        int count = 0;
        int q = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                count++;
            } else if (arr[i] % k > 0) {
                q = arr[i] / k;
                System.out.println("Array value: " + arr[i]);
                System.out.println("Second loop: " + q);
                count += (q + 1);
            } else {
                q = arr[i] / k;
                System.out.println("Array value: " + arr[i]);
                System.out.println("Third loop: " + q);
                count += q;
            }
        }
        return count;
    }
}

public class TotalCount {
    public static void main(String[] args) {
        Solution ans = new Solution();
        int k = 4;
        int[] arr = { 10, 2, 3, 4, 7 };
        System.out.println(ans.totalCount(k, arr));
    }
}
