public class NoWithEvenDigits {

    public static int findNoOfDigits(int n) {
        int count = 0;
        while (n != 0) {
            n = n / 10;
            count++;
        }
        return count;
    }

    public static int countNoOfDigits(int n) {
        return (int) (Math.log10(n)) + 1;
    }

    public static int nosWithEvenDigits(int nums[]) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int numToFind = findNoOfDigits(nums[i]);
            // System.out.println("No of digits in " + nums[i] + " : " + numToFind);
            if (numToFind % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = { 12, 345, 2, 6, 7896 };
        System.out.println(nosWithEvenDigits(nums));
        int aNum = 3872456;
        System.out.println("No of digits in " + aNum + " is: " + countNoOfDigits(aNum));
    }

}
