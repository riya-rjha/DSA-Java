public class KthBinString {

    // Brute Force
    public char findKthBit(int n, int k) {
        String ans = genBin(n);
        return ans.charAt(k - 1);
    }

    public String genBin(int n) {
        if (n == 1) {
            return "0";
        }
        String previous = genBin(n - 1);
        String inverted = invert(previous);
        return previous + "1" + rev(inverted);
    }

    public String rev(String str) {
        char[] s = str.toCharArray();
        int st = 0;
        int end = s.length - 1;
        while (st <= end) {
            char temp = s[st];
            s[st] = s[end];
            s[end] = temp;
            st++;
            end--;
        }
        String newStr = "";
        for (int i = 0; i < s.length; i++) {
            newStr += s[i];
        }
        return newStr;
    }

    public String invert(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                newStr += "1";
            }
            if (str.charAt(i) == '1') {
                newStr += "0";
            }
        }
        return newStr;
    }

    public static void main(String[] args) {
        KthBinString ans = new KthBinString();
        System.out.println(ans.findKthBit(4, 11));
    }
}
