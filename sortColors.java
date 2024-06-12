import utils.printArrUtility;

public class sortColors {

    public static void sortColor(int[] nums) {
        // In-Place Sorting Algorithm
        // Counting Sort

        int countArr[] = new int[3];
        for (int i = 0; i < nums.length; i++) {
            countArr[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < 3; i++) {
            while (countArr[i] != 0) {
                nums[j] = i;
                countArr[i]--;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        sortColor(nums);
        printArrUtility.printArr(nums); // static declaration
    }
}
