public class SubArraySumdivByK {

    public static int subArraySumCount(int arr[], int k) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = 0; //for every new sub array formed
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        System.out.println(subArraySumCount(nums, k));
    }
}