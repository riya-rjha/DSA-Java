public class MostRemovedStone {

    static int count = 1;

    public static void searchInArr(int arr[][], int i, int j) {
        for (int j2 = i - 1; j2 >= 0; j2--) {
            for (int k = 0; k <= j; k++) {
                if (arr[i][j] == arr[j2][k]) {
                    count++;
                    return;
                }
            }
        }
    }

    public static int removeStones(int[][] stones) {
        for (int i = stones.length - 1; i >= 0; i--) {
            for (int j = 0; j < stones[0].length; j++) {
                int prevCount = count;
                searchInArr(stones, i, j);
                if (prevCount != count) {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));
    }
}
