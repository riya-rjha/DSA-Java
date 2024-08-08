import java.util.HashMap;

public class demo {

    public int minimumPushes(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int count = hm.getOrDefault(c, 0);
            hm.put(c, count + 1);
        }
        int sum = 0;
        for (HashMap.Entry<Character, Integer> entry : hm.entrySet()) {
            int value = entry.getValue();
            sum += value;
        }

        return sum;
    }

    public static void main(String[] args) {
        String str = "aabbccddeeffgghhiiiiii";
        demo s = new demo();
        System.out.println(s.minimumPushes(str));
    }
}
