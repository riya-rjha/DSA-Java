public class ValidPalindrome {

    // Brute Force
    public boolean isPalindrome(String s) {
        String newStr = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                newStr += Character.toLowerCase(ch);
                // System.out.println(newStr);
            }
        }
        for (int i = 0; i < newStr.length() / 2; i++) {
            if (newStr.charAt(i) != newStr.charAt(newStr.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    // Recurisve Approach
    public boolean isPalindromeRecurisve(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return isPalindromeChecker(sb.toString(), 0, sb.length() - 1);
    }

    public boolean isPalindromeChecker(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }
        return isPalindromeChecker(s, left + 1, right - 1);
    }

    public static void main(String[] args) {
        String a = "A man, a plan, a canal: Panama";
        ValidPalindrome ans = new ValidPalindrome();
        System.out.println(ans.isPalindromeRecurisve(a));
    }
}
