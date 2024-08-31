import java.util.HashMap;
import java.util.Map;

public class HashDividedString {

    static HashMap<Character, Integer> hm = new HashMap<>();

    public String[] subStrings(String str, int k) {
        int n = str.length();
        int length_of_subString = n / k;
        String[] arr = new String[length_of_subString];

        for (int i = 0; i < length_of_subString; i++) {
            int start = i * k;
            int end = start + k;
            arr[i] = str.substring(start, end);
        }

        return arr;
    }

    public int calculateNumber(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            Integer val = hm.get(str.charAt(i));
            sum += val;
        }
        return sum % 26;
    }

    public String stringHash(String s, int k) {
        int count = 0;
        for (char i = 'a'; i <= 'z'; i++) {
            hm.put(i, count);
            count++;
        }

        String[] arr = subStrings(s, k);
        StringBuilder final_ans = new StringBuilder();

        for (String substring : arr) {
            int hashValue = calculateNumber(substring);
            for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
                if (entry.getValue() == hashValue) {
                    final_ans.append(entry.getKey());
                    break;
                }
            }
        }

        return final_ans.toString();
    }

    public static void main(String[] args) {
        String str = "abcd";
        int k = 2;
        HashDividedString n = new HashDividedString();
        System.out.println(n.stringHash(str, k));
    }
}
