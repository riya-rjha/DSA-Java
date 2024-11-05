public class Contest422 {

    static boolean isBalanced(String num) {
        int sumEven = 0;
        int sumOdd = 0;
        char arr[] = num.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            int val = Integer.parseInt(String.valueOf(arr[i]));
            if (i % 2 == 0) {
                sumEven += val;
            } else {
                sumOdd += val;
            }
        }
        return (sumEven == sumOdd);
    }

    

    static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int t = moveTime[0][m - 1];
        for (int i = 1; i < n; i++) {
            t += Math.min(moveTime[i][0], 1);
        }
        for (int j = 1; j < m; j++) {
            t += Math.min(moveTime[n - 1][j], 1);
        }
        return t;
    }

    public static void main(String[] args) {
        String s = "24123";
        String s2 = "1234";
        System.out.println(isBalanced(s));
        System.out.println(isBalanced(s2));
        int[][] moveTime = { { 0, 1 }, { 1, 2 } };
        System.out.println(minTimeToReach(moveTime));
    }
}