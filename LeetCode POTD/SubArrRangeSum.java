import java.util.HashMap;

public class SubArrRangeSum {

    // Using cummulative sum
    static int subArraySum(int arr[], int tar) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : arr) {
            sum += num;
            count += hm.getOrDefault(sum - tar, 0);
            hm.put(sum, hm.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 2, -2, -20, 10 };
        int tar = -10;
        System.out.println(subArraySum(arr, tar));
    }
}