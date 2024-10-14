import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReorganizeArr {

    public List<Integer> rearrange(List<Integer> arr) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            ans.add(-1);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != -1 && arr.get(i) < ans.size()) {
                ans.set(arr.get(i), arr.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> lst = Arrays.asList(-1, -1, 6, 1, 9, 3, 2, -1, 4, -1);
        ReorganizeArr ans = new ReorganizeArr();
        System.out.println("Original: " + lst);
        System.out.println("Answer: " + ans.rearrange(lst));
    }
}
