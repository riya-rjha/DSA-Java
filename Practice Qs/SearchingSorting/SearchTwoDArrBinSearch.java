import java.util.Arrays;

public class SearchTwoDArrBinSearch {

    public static int[] linearSearch(int nums[][], int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (target == nums[i][j]) {
                    return new int[] { i, j };
                }
            }
        }

        return new int[] { -1, -1 };
    }

    public static int[] binSearch(int nums[][], int target) {
        int row = 0;
        int col = nums[0].length - 1;

        while (row < nums.length && col > 0) {
            if (target == nums[row][col]) {
                return new int[] { row, col };
            }
            else if(target > nums[row][col]){
                row++;
            }
            else{
                col--;
            }
        }

        return new int[] {-1, -1};

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int target = 11;
        System.out.println("On applying Linear search: " );
        System.out.println("Element " + target + " found at position: " + Arrays.toString(linearSearch(matrix, target)));
        System.out.println("On applying Binary search: " );
        System.out.println("Element " + target + " found at position: " + Arrays.toString(binSearch(matrix, target)));
    }
}
