public class RepeatedSubStringPattern {
    // Brute Force - O(n2)
    public static boolean repeatedSubstringPattern(String s) {
        String newString = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            newString += s.charAt(i);
            String nString = newString;
            int j = 0;
            while (!nString.equals(s)) {
                if (j == n) {
                    if (nString.equals(s)) {
                        return true;
                    }
                    break;
                }
                nString += newString;
                j++;
            }
            if (nString.equals(s)) {
                return true;
            }
        }
        return false;
    }

    // Optimized is to use KMP Algo to first construct LPS and then iterate

    public static void main(String[] args) {
        String s = "aba";
        System.out.println(repeatedSubstringPattern(s));
    }
}