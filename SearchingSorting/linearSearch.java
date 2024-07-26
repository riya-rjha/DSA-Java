package SearchingSorting;

import java.util.*;

class linearSearch {

    // search in string
    static boolean search(String str, char target) {
        if (str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (target == str.charAt(i)) {
                return true;
            }
        }

        /*
         * for(char ch: str.toCharArray()){
         * if(ch == target) return true;
         * }
         */

        return false;
    }

    public static int findMin(int arr[]) {

        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if (smallest > arr[i]) {
                smallest = arr[i];
            }
        }

        return smallest;
    }

    public static int[] findInTwoDarray(int[][] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (target == arr[i][j])
                    return new int[] { i, j };
            }
        }
        return new int[] { -1, -1 };

        /*
         * for(int [] el: arr){
         *  for(int j: el){
         *    // Alt method for looping in 2D Array
         *  }
         * }
         * 
         */

    }

    public static void main(String[] args) {
        String str = "Kunal Kushwaha DSA in Java";
        char target = 'i';
        System.out.println(search(str, target));
        int arr[] = { 10, -3, 72, 83, 16, 3, 81 };
        System.out.println(findMin(arr));
        System.out.println("Enter elments of 2D Array: ");
        Scanner sc = new Scanner(System.in);
        int newArr[][] = new int[3][2];
        for (int i = 0; i < newArr.length; i++) {
            System.out.println("Enter elements of row " + (i + 1));
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.println("Enter element of column " + (j + 1));
                newArr[i][j] = sc.nextInt();
            }
        }
        int target2 = 38;
        System.out.println("Element found at index: " + (Arrays.toString(findInTwoDarray(newArr, target2))));
    }
}
