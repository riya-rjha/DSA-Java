public class NumberOfIslands {

    static int[][] directions = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 }, { 1, -1 }, { 1, 1 }, { -1, -1 },
            { -1, 1 } };

    private static void dfs(int i, int j, int n, int m, char[][] grid) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        for (int[] ks : directions) {
            dfs(ks[0] + i, ks[1] + j, n, m, grid);
        }
    }

    public static int numIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ans++;
                    dfs(i, j, grid.length, grid[0].length, grid);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '0', '1', '1', '1', '0', '0', '0' },
                { '0', '0', '1', '1', '0', '1', '0' }
        };
        System.out.println(numIslands(grid));
    }
}
