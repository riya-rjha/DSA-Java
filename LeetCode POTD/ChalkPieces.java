public class ChalkPieces {
    public int chalkReplacer(int[] chalk, int k) {
        int i = 0;
        while (chalk[i] <= k) {

            if (k < 0) {
                return i;
            }
            k = k - chalk[i];
            if (i == chalk.length - 1) {
                i = 0;
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] chalk = { 5, 1, 5 };
        int k = 22;
        ChalkPieces s = new ChalkPieces();
        System.out.println(s.chalkReplacer(chalk, k));
    }
}
