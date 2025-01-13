import java.util.Arrays;

public class SortedMatrix {

    // Ideally, in binary search we check with start and end
    // Here, we will be checking in respective rows
    // So in binSearch, we are checking only in one specific row when there are only
    // 2 rows
    // So start = rows and end = mid
    // And starting index to ending index = Starting Column to Ending Column

    static int[] binSearch(int arr[][], int row, int colStart, int colEnd, int target) {
        while (colStart <= colEnd) {
            int mid = colStart + (colEnd - colStart) / 2;
            if (arr[row][mid] == target) {
                return new int[] { row, mid };
            }
            if (arr[row][mid] > target) {
                colEnd = mid - 1;
            } else {
                colStart = mid + 1;
            }
        }
        return new int[] { -1, -1 };
    }

    // Initially, we will start searching in the middle column
    // And continue the search with midCol and mid value
    // We will run a loop until & unless we get not more than 2 rows exact

    // Applying conditions for target
    // If target is equal to current row and midcol or equal to next row and mid col
    // return that row and midCol
    // If target is less than curr Row and midcol - 1, search in left half
    // If target is between colMid and last column, search in between or right half
    // If target is less than currRow + 1 and colMid - 1, search in left half

    static int[] search(int[][] arr, int target) {
        int rows = arr.length;
        int cols = arr[0].length;

        if (cols == 0) {
            return new int[] { -1, -1 };
        }

        if (rows == 1) {
            return binSearch(arr, 0, 0, cols - 1, target);
        }

        int rowStart = 0;
        int rowEnd = rows - 1;
        int colMid = cols / 2;

        while (rowStart < rowEnd - 1) {
            int mid = rowStart + (rowEnd - rowStart) / 2;
            if (arr[mid][colMid] == target) {
                return new int[] { mid, colMid };
            }
            if (arr[mid][colMid] > target) {
                rowEnd = mid;
            } else {
                rowStart = mid;
            }
        }

        // When only two rows are remaining
        if (arr[rowStart][colMid] == target) {
            return new int[] { rowStart, colMid };
        }

        if (arr[rowStart + 1][colMid] == target) {
            return new int[] { rowStart + 1, colMid };
        }

        if (target <= arr[rowStart][colMid - 1]) {
            return binSearch(arr, rowStart, 0, colMid - 1, target);
        }

        if (target >= arr[rowStart][colMid + 1] && target <= arr[rowStart][colMid - 1]) {
            return binSearch(arr, rowStart, colMid + 1, cols - 1, target);
        }

        if (target <= arr[rowStart + 1][colMid - 1]) {
            return binSearch(arr, rowStart + 1, 0, colMid - 1, target);
        }

        return binSearch(arr, rowStart + 1, colMid + 1, cols - 1, target);

    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        System.out.println(Arrays.toString(search(arr, 4)));
    }
}
