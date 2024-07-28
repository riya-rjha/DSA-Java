public class AliceBobSum {
    public static int noOfDigit(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n / 10;
        }
        return count;
    }

    public static boolean canAliceWin(int[] nums) {
        int sumSingle = 0;
        int sumDouble = 0;
        for (int i = 0; i < nums.length; i++) {
            if (noOfDigit(nums[i]) == 1) {
                sumSingle += nums[i];
            }
            if (noOfDigit(nums[i]) == 2) {
                sumDouble += nums[i];
            }
        }
        if (sumSingle > sumDouble || sumDouble > sumSingle) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 10 };
        System.out.println(canAliceWin(nums));
    }
}
