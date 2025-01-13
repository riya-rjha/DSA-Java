public class StringDigitsSum {

   
    public int getLucky(String s, int k) {
        // Convert character to numerical val
        String numericString = "";
        for (char ch : s.toCharArray()) {
            numericString += Integer.toString(ch - 'a' + 1);
        }

        // Calculate sum
        while (k-->0) {
            int sum_of_digits = 0;
            for (char digit : numericString.toCharArray()) {
                sum_of_digits += digit - '0';
            }
            numericString = Integer.toString(sum_of_digits);
        }
        return Integer.parseInt(numericString);
    }

    public static void main(String[] args) {
        String s = "leetcode";
        int k = 2;
        StringDigitsSum ans = new StringDigitsSum();
        System.out.println(ans.getLucky(s, k));
    }
}
