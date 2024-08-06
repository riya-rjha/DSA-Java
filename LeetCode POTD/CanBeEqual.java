import java.util.Arrays;

public class CanBeEqual {

    public static boolean canBeEqual(int[] target, int[] arr) {
        if (target.length == arr.length) {
            for (int i = 0; i < target.length; i++) {
                if (arr[i] != target[i]) {
                    Arrays.sort(arr);
                    Arrays.sort(target);
                    break;
                }
            }
            for (int i = 0; i < target.length; i++) {
                if (arr[i] != target[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int target[] = { 809, 107, 274 };
        int arr[] = { 809, 274, 107 };
        System.out.println(canBeEqual(target, arr));
    }
}
