public class KadanesAlgo {

    long maxSubarraySum(int[] arr) {
        long currSum = 0;
        long maxSum = Long.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += arr[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = { -1, -2, -3 };
        KadanesAlgo s = new KadanesAlgo();
        System.out.println(s.maxSubarraySum(arr));
    }
}
