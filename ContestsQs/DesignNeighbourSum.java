public class DesignNeighbourSum {
    static class neighborSum {

        int[][] grid;
        int n;

        public neighborSum(int[][] grid) {
            this.grid = grid;
            this.n = grid.length;
        }

        private int[] findPos(int value) {
            int arr[] = new int[2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == value) {
                        arr[0] = i;
                        arr[1] = j;
                        return arr;
                    }
                }
            }
            return null;
        }

        private int sumOfElements(int[][] grid, int[][] directions, int value) {
            int[] posEl = findPos(value);
            if (posEl == null) {
                return 0;
            }
            int i = posEl[0];
            int j = posEl[1];
            int sum = 0;
            for (int dir[] : directions) {
                int sum_x = i + dir[0];
                int sum_y = j + dir[1];
                if (sum_x >= 0 && sum_x < n && sum_y >= 0 && sum_y < n) {

                    sum += grid[sum_x][sum_y];
                }
            }
            return sum;
        }

        public int adjacentSum(int value) {
            int directions[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
            return sumOfElements(grid, directions, value);
        }

        public int diagonalSum(int value) {
            int[][] directions = { { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
            return sumOfElements(grid, directions, value);
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
        int value = 8;
        neighborSum obj = new neighborSum(grid);
        int param_1 = obj.adjacentSum(value);
        int param_2 = obj.diagonalSum(value);
        System.out.println(param_1);
        System.out.println(param_2);

    }
}