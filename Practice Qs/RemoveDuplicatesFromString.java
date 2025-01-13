import java.util.LinkedHashSet;

public class RemoveDuplicatesFromString {

    public static String removeDups(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        String ans = "";
        for (Character character : set) {
            ans += character;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(removeDups("zvvo"));
    }
}
