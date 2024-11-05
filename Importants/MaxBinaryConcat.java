import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int maxGoodNumber(int[] nums) {
        List<String> lst = new ArrayList<>();
        for (int num : nums) {
            lst.add(Integer.toBinaryString(num));
        }
        Collections.sort(lst, (a, b) -> (b + a).compareTo(a + b));
        String newStr = "";
        for (String str : lst) {
            newStr += str;
        }
        return Integer.parseInt(newStr, 2);
    }
}

public class MaxBinaryConcat {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution s = new Solution();
        System.out.println(s.maxGoodNumber(nums));
    }
}
