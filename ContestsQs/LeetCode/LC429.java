import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class LC429 {

    static int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int el : nums) {
            set.add(el);
        }
        if (set.size() == nums.length) {
            return 0;
        }
        List<Integer> lst = new ArrayList<>();
        for (int num : nums) {
            lst.add(num);
        }
        int cnt = 0;
        while (lst.size() != 0) {
            set = new HashSet<>(lst);
            if (set.size() == lst.size()) {
                return cnt;
            }
            int canRemove = Math.min(3, lst.size());
            for (int i = 0; i < canRemove; i++) {
                lst.remove(0);
            }
            cnt++;
        }
        return cnt;
    }

    static int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        long firstEl = nums[0];
        int cnt = 1;
        for (int el : nums) {
            if (el <= firstEl) {
                long currentEl = firstEl + 1;
                if (Math.abs(currentEl - el) <= k) {
                    firstEl = currentEl;
                    cnt++;
                }
            } else {
                firstEl = el;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 4, 4 };
        System.out.println(minimumOperations(nums));
        int[] arr = { 1, 2, 2, 3, 3, 4 };
        int k = 2;
        System.out.println(maxDistinctElements(arr, k));
    }
}
