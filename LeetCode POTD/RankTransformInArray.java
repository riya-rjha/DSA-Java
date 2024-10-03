import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] temp = arr.clone();
        Arrays.sort(temp);
        Map<Integer, Integer> hm = new LinkedHashMap<>();
        int j = 1;
        for (int i = 0; i < temp.length; i++) {
            if (!hm.containsKey(temp[i])) {
                hm.put(temp[i], j++);
            }
        }
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int index = hm.get(arr[i]);
            lst.add(index);
        }
        int[] ans = new int[lst.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }
}

public class RankTransformInArray {
    public static void main(String[] args) {
        int[] arr = { 37, 12, 28, 9, 100, 56, 80, 5, 12 };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.arrayRankTransform(arr)));
    }
}
