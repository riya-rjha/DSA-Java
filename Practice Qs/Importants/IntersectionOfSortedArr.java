import java.util.ArrayList;
import java.util.Arrays;

public class IntersectionOfSortedArr {

    // TC - O(n + m)
    public static ArrayList<Integer> findIntersection(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> lst = new ArrayList<>();
        int count[] = new int[m];
        Arrays.fill(count, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr1[i] == arr2[j] && count[j] == 0) {
                    lst.add(arr1[i]);
                    count[j] = 1;
                    break;
                }
                if (arr2[j] > arr1[i])
                    break; // Nothing remaining to be common
            }
        }
        return lst;
    }

    public static ArrayList<Integer> findIntersectionOpt(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> lst = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr1[i] > arr2[j]) {
                j++;
            } else {
                lst.add(arr1[i]);
                i++;
                j++;
            }
        }

        return lst;
    }

    public static void main(String[] args) {
        int n = 5;
        int arr1[] = { 1, 4, 6, 20, 44 };
        int m = 4;
        int arr2[] = { 4, 6, 44, 100 };
        System.out.println(findIntersection(arr1, arr2, n, m));
        System.out.println(findIntersectionOpt(arr1, arr2, n, m));
    }
}
