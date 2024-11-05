import java.util.*;

public class oa1 {

    public static long maximizeTotalMemoryPoints(List<Integer> memory) {
        List<Integer> lst = new ArrayList<>();
        Collections.sort(memory, Collections.reverseOrder());
        lst.add(0, memory.get(0));
        for (int i = 1; i < memory.size(); i++) {
            lst.add(i, memory.get(i) + lst.get(i - 1));
        }
        long sum = 0;
        for (int i = 0; i < lst.size(); i++) {
            sum += lst.get(i);
        }
        return sum;
    }

    public static int cleanupDataset(String dataset, int x, int y) {
        int sum = 0;
        for (int i = 0; i < dataset.length() - 1; i += 2) {
            if (dataset.charAt(i) == dataset.charAt(i + 1)) {
                sum += x;
            } else {
                sum += y;
            }
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < dataset.length(); i++) {
            hm.put(dataset.charAt(i), hm.getOrDefault(dataset.charAt(i), 0) + 1);
        }
        int sum2 = 0;
        List<Integer> lst = new ArrayList<>();
        for (Map.Entry<Character, Integer> el : hm.entrySet()) {
            lst.add(el.getValue());
        }
        int count = 1;
        for (int i = 0; i < lst.size(); i++) {
            if (lst.get(i) % 2 != 0) {
                if (count % 2 == 0) {
                    lst.remove(i);
                }
                sum2 += y;
            } else {
                sum2 += x;
                lst.remove(lst.get(i));
                lst.add(lst.get(i) - 2);
            }
        }
        return Math.min(sum, sum2);
    }

    static boolean rotateString(String s, String goal) {
        for (int i = 0; i < goal.length(); i++) {
            char ch = goal.charAt(i);
            if(!s.contains(String.valueOf(ch))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // List<Integer> lst = new ArrayList<>();
        // lst.add(3);
        // lst.add(4);
        // lst.add(5);
        // System.out.println(maximizeTotalMemoryPoints(lst));
        // String s = "ouio";
        // System.out.println(cleanupDataset(s, 2, 4));

        String s = "abcde", goal = "abced";
        System.out.println(rotateString(s, goal));
    }
}
