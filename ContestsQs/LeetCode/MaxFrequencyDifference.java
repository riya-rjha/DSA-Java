public class MaxFrequencyDifference {

    public static int maxDifference(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }
        int maxOdd = Integer.MIN_VALUE;
        int minEven = Integer.MAX_VALUE;
        for (int count : freq) {
            if (count > 0) {
                if (count % 2 == 0) {
                    minEven = Math.min(minEven, count);
                } else {
                    maxOdd = Math.max(maxOdd, count);
                }
            }
        }
        if (maxOdd == Integer.MIN_VALUE || minEven == Integer.MAX_VALUE) {
            return -1; 
        }
        return maxOdd - minEven;
    }

    public static void main(String[] args) {
        System.out.println(maxDifference("aaaaabbc")); // Output: 3
        System.out.println(maxDifference("abcabcab")); // Output: 1
    }
}
