public class OriginalTypedString {

    public static int possibleStringCount(String word) {
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                count++;
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        String word = "abcd";
        System.out.println(possibleStringCount(word));
    }
}