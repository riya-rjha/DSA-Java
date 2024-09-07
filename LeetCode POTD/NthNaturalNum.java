public class NthNaturalNum {

    boolean containsNine(long n) {

        String num = String.valueOf(n);

        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '9') {
                return true;
            }
        }

        return false;
    }

    // TLE - Time Limit Exceeded
    long findNth(long n) {
        long count = 0;
        long currNum = 0;
        while (count < n) {
            currNum++;
            if (!containsNine(currNum)) {
                count++;
            }
        }
        return currNum;
    }

    // Base 9 Conversion - Only 9 possible digits

    long findNthOptimized(long n) {
        String res = "";
        while (n > 0) {
            res = (n % 9) + res;
            n = n / 9;
        }
        return Long.valueOf(res);
    }

    public static void main(String[] args) {
        NthNaturalNum ans = new NthNaturalNum();
        System.out.println(ans.findNth(18));
        System.out.println(ans.findNthOptimized(18));
    }
}
