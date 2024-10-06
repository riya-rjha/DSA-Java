import java.util.Arrays;

class Solution {
    public boolean areSentencesSimilar(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return areSentencesSimilar(s2, s1);
        }

        String[] small = s1.split(" ");
        String[] large = s2.split(" ");
        System.out.println(Arrays.toString(small) + " " + Arrays.toString(large));

        int st = 0;
        int e1 = small.length - 1;
        System.out.println(e1);
        int e2 = large.length - 1;
        System.out.println(e2);

        while (st <= e1 && small[st].equals(large[st])) {
            System.out.println(st + " String: " + small[st] + " Another: " + large[st]);
            st++;
        }

        while (st <= e1 && small[e1].equals(large[e2])) {
            System.out.println("E1: " + e1);
            System.out.println("E2: " + e2);
            System.out.println(st + " String: " + small[e1] + " Another: " + large[e2]);
            e1--;
            e2--;
        }

        if (st > e1)
            return true;
        return false;
    }
}

public class SentenceSimilarity {
    public static void main(String[] args) {
        String sentence1 = "My name is Haley";
        String sentence2 = "My Haley";
        Solution ans = new Solution();
        System.out.println(ans.areSentencesSimilar(sentence1, sentence2));
    }
}
