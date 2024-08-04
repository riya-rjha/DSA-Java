
public class MatchingColors {

    public int winningPlayerCount(int n, int[][] pick) {
        int colorCountArr[][] = new int[n][2];
        for (int[] currPlayer : pick) {
            int player = currPlayer[0];
            int color = currPlayer[1];
            colorCountArr[player][color]++;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j : colorCountArr[i]) {
                if (j > i) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] pick = { { 0, 0 }, { 1, 0 }, { 1, 0 }, { 2, 1 }, { 2, 1 }, { 2, 0 } };
        MatchingColors ans = new MatchingColors();
        System.out.println(ans.winningPlayerCount(n, pick));
    }
}
