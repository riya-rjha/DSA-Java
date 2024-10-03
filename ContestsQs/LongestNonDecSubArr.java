public class LongestNonDecSubArr {

    public static int longestSubarray(int n, int[] arr, int k) {
        int maxLen = 0;
        boolean isIncreasing = true;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                isIncreasing = true;
                sum = 0;
                for (int j2 = i; j2 < j2; k++) {
                    if (arr[j2] > arr[j2 + 1]) {
                        isIncreasing = false;
                        break;
                    }
                }
                if (isIncreasing) {
                    for (int j2 = 0; j2 < arr.length; j2++) {
                        sum += arr[j2];
                    }
                    if (sum % k == 0) {
                        int len = j - i + 1;
                        maxLen = Math.max(maxLen, len);
                    }
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int n = 2;
        int[] arr = { 6, 7 };
        int k = 9;
        System.out.println(longestSubarray(n, arr, k));
    }
}