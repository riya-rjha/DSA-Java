import java.util.HashMap;

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

    public int winPlayerOptimized(int n, int [] [] pick){
        HashMap<Integer, HashMap<Integer, Integer>> hm = new HashMap<>();

        // Add for every nth player in hashmap and initialize
        for (int i = 0; i < pick.length; i++) {
            hm.put(i, new HashMap<>());
        }

        for (int[] currPlayer : pick) { 
            int x = currPlayer[0];
            int y = currPlayer[1];
            // for every player x add current color y in the hashmap and for that y
            // add number of occurrence
            hm.get(x).put(y, hm.get(x).getOrDefault(y, 0) +1);
        }

        int count = 0;
        for (int key : hm.keySet()) {
            HashMap<Integer, Integer> map = hm.get(key);
            for (int yMap : map.keySet() ) {
                if(key < map.get(yMap)){
                    count++;
                    break;
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
        System.out.println(ans.winPlayerOptimized(n, pick));
    }
}
