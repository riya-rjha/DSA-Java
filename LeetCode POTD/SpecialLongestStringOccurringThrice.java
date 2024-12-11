public class SpecialLongestStringOccurringThrice {
    static int maximumLength(String s) {
        int n = s.length();
        String str = "";
        int count = -1;
        int maxCount = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            char ch = s.charAt(i);
            if (ch == s.charAt(i + 1)) {
                str += ch;
            }
            String newStr = "";
            count = -1;
            for (int j = 0; j < n; j++) {
                newStr += s.charAt(j);
                if (newStr.equals(str)) {
                    count++;
                    newStr = "";
                    continue;
                }
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        String s = "abcaba";
        System.out.println(maximumLength(s));
    }
}
