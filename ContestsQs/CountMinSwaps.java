public class CountMinSwaps {

    private static int[] calculateSum(String str) {
        int sumEven = 0;
        int sumOdd = 0;
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - '0';
            if (i % 2 == 0) {
                sumEven += value;
            } else {
                sumOdd += value;
            }
        }
        return new int[] { sumEven, sumOdd };
    }

    public static int minSwaps(String str) {
        int[] sum = calculateSum(str);
        int sumEven = sum[0];
        int sumOdd = sum[1];

        if ((sumEven - sumOdd) % 2 != 0) {
            return -1;
        }

        int diff = (sumEven - sumOdd) / 2;
        if (diff == 0) {
            return 0;
        }

        int swapCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (diff > 0 && i % 2 == 0 && str.charAt(i) == '1') {
                swapCount++;
                diff -= 1;
            } else if (diff < 0 && i % 2 == 1 && str.charAt(i) == '0') {
                swapCount++;
                diff += 1;
            }
        }

        return (diff == 0) ? swapCount : -1;
    }

    public static int minSwapsEasyApproach(String str) {
        
    }

    public static void main(String[] args) {
        String str = "111";
        System.out.println(minSwaps(str));
    }
}
