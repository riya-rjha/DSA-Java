public class LongestCommonPrefix {

    public static String longestPrefix(String[] arr) {
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                System.out.println(arr[i].indexOf(prefix));
                prefix = prefix.substring(0, prefix.length() - 1);
            }
            System.out.println(arr[i].indexOf(prefix));
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] arr = { "flower", "flought", "flow", "flock" };
        System.out.println(longestPrefix(arr));
    }
}
