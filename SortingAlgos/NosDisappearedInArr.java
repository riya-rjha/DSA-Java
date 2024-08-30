import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NosDisappearedInArr {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!hm.containsKey(i)) {
                lst.add(i);
            }
        }
        return lst;
    }

    static void swapArr(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    static void cyclicSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                swapArr(arr, i, arr[i] - 1);
            }
        }
    }

    static List<Integer> findNoOpt(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        cyclicSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                lst.add(i + 1);
            }
        }
        return lst;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };
        NosDisappearedInArr ans = new NosDisappearedInArr();
        System.out.println(ans.findDisappearedNumbers(nums));
        System.out.println(NosDisappearedInArr.findNoOpt(nums));
    }
}
