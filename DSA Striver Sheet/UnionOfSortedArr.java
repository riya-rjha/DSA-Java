import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnionOfSortedArr {

    // 1112 /1120 Testcases passed
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!lst.contains(arr1[i])) {
                lst.add(arr1[i]);
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            if (!lst.contains(arr2[i])) {
                lst.add(arr2[i]);
            }
        }
        Collections.sort(lst);
        return lst;
    }

    // Use set to maintain the order of element
    // TC -> O(n + m)

    public static ArrayList<Integer> findUnionUsingSet(int arr1[], int arr2[], int n, int m) {
        HashSet<Integer> set = new HashSet<>();
        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        for (int el : set) {
            lst.add(el);
        }
        Collections.sort(lst);
        return lst;
    }

    // 2-pointer approach
    // Optimized Solution

    public static ArrayList<Integer> findUnionOptimized(int arr1[], int arr2[], int n, int m) {
        ArrayList<Integer> lst = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (!set.contains(arr1[i])) {
                    lst.add(arr1[i]);
                    set.add(arr1[i]);
                }
                i++;
            } else if (arr1[i] > arr2[j]) {
                if (!set.contains(arr2[j])) {
                    lst.add(arr2[j]);
                    set.add(arr2[j]);
                }
                j++;
            } else {
                if (!set.contains(arr1[i])) {
                    lst.add(arr1[i]);
                    set.add(arr1[i]);
                }
                i++;
                j++;
            }
        }

        while (i < n) {
            if (!set.contains(arr1[i])) {
                lst.add(arr1[i]);
                set.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (!set.contains(arr2[j])) {
                lst.add(arr2[j]);
                set.add(arr2[j]);
            }
            j++;
        }

        return lst;
    }

    public static void main(String[] args) {
        int n = 9;
        int arr1[] = { -8, -3, -3, -2, 0, 1, 2, 2, 6 };
        int m = 3;
        int arr2[] = { -9, -9, 0 };
        // System.out.println(findUnion(arr1, arr2, n, m));
        // System.out.println(findUnionUsingSet(arr1, arr2, n, m));
        System.out.println(findUnionOptimized(arr1, arr2, n, m));
    }
}
