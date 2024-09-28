public class LengthOfLongestPrefix {

    // Brute Force
    public static int maxPair(int a, int b) {
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);
        int len = Math.min(a1.length(), b1.length());

        int j = 0;
        String newStr = "";
        for (int i = 0; i < len; i++) {
            if (a1.charAt(i) != b1.charAt(j)) {
                break;
            }
            newStr += a1.charAt(i);
            j++;
            System.out.println("New String: " + newStr);
        }
        return newStr.length();
    }

    public static int longestCommonPrefix(int[] arr1, int[] arr2) {
        int n1 = arr1.length;
        int n2 = arr2.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                System.out.println("Pairs: " + arr1[i] + " " + arr2[j]);
                int calcForPair = maxPair(arr1[i], arr2[j]);
                System.out.println("Calc Pair value of string: " + calcForPair);
                max = Math.max(max, calcForPair);
            }
        }
        return max;
    }
    

    public static void main(String[] args) {
        int[] arr1 = { 1, 10, 100 };
        int[] arr2 = { 1000 };
        System.out.println(longestCommonPrefix(arr1, arr2));
    }
}
