import java.util.*;

public class relativeSortArray {

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] sortRelArr(int[] arr1, int[] arr2) {
        // Creating a Hash Table
        HashMap<Integer, Integer> hm = new HashMap<>();
        int count = 1;
        for (int i = 0; i < arr1.length; i++) {
            if (!hm.containsKey(arr1[i])) {
                hm.put(arr1[i], count);
                System.out.println(arr1[i] + ": " + count);
            } else {
                hm.put(arr1[i], hm.get(arr1[i]) + 1);
                System.out.println(arr1[i] + ": " + count);
            }
        }

        // Add all elements of arr2 to arr1
        ArrayList<Integer> lst1 = new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            count = hm.get(arr2[i]);
            while (count != 0) {
                lst1.add(arr2[i]);
                count--;
            }
        }

        // Add remaining elements of arr1 to arrayList2 & then sort
        ArrayList<Integer> lst2 = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!lst1.contains(arr1[i])) {
                lst2.add(arr1[i]);
            }
        }

        // Sort the list2 of remaining elements
        Collections.sort(lst2);
        lst1.addAll(lst2);

        // Return the array
        int[] result = new int[lst1.size()];
        for (int i = 0; i < lst1.size(); i++) {
            result[i] = lst1.get(i);
        }

        return result;
    }

    public static int[] optSortRelArr(int arr1[], int arr2[]){

    }

    public static void main(String[] args) {
        // int arr1[] = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        // int arr2[] = { 2, 1, 4, 3, 9, 6 };

        int arr1[] = { 28, 6, 22, 8, 44, 17 };
        int arr2[] = { 22, 28, 8, 6 };

        int ans[] = sortRelArr(arr1, arr2);
        printArr(ans);
    }
}
