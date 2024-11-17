import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC144 {

    static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i <= n - 2 * k; i++) {
            boolean flag1 = true;
            boolean flag2 = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    flag1 = false;
                    break;
                }
            }

            if (!flag1)
                continue;

            for (int j = i + k; j < i + 2 * k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    flag2 = false;
                    break;
                }
            }

            if (flag1 && flag2) {
                return true;
            }
        }
        return false;
    }

    // TLE
    static int maxIncreasingSubarrays(List<Integer> nums) {
        int max = nums.size() / 2;
        int k = -1;
        int n = nums.size();
        for (k = max; k >= 1; k--) {
            int st = 0;
            int end = 2 * k;
            while (end <= n) {
                boolean flag1 = true;
                boolean flag2 = true;
                for (int i = st; i < st + k - 1; i++) {
                    if (nums.get(i) >= nums.get(i + 1)) {
                        flag1 = false;
                        break;
                    }
                }
                if (flag1) {
                    for (int i = st + k; i < end - 1; i++) {
                        if (nums.get(i) >= nums.get(i + 1)) {
                            flag2 = false;
                            break;
                        }
                    }
                    if (flag2) {
                        return k;
                    }
                }
                st++;
                end++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 4, 4, 4, 5, 6, 7));
        int k = 5;
        System.out.println(hasIncreasingSubarrays(lst, k));
    }
}
