import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityVote {

    public static List<Integer> findMajority(List<Integer> nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int per = nums.size() / 3;
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            hm.put(nums.get(i), hm.getOrDefault(nums.get(i), 0) + 1);
        }
        for (Map.Entry<Integer, Integer> hash : hm.entrySet()) {
            int key = hash.getKey();
            int val = hash.getValue();
            if (val > per) {
                lst.add(key);
            }
        }
        if (lst.size() == 0) {
            lst.add(-1);
        }
        return lst;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(findMajority(nums));
    }
}
