package CC;

public class CC171 {

    public static void helper() {
        String s = "AYVITIAZ";
        String ans = "ADVITIYA";
        int moves = 0;
        for (int i = 0; i < 8; i++) {
            char ch = s.charAt(i);
            char needed = ans.charAt(i);
            if (ch < needed) {
                moves += (int) (needed - ch);
                System.out.println("if moves :  " + moves);
                System.out.println("i: " + i);
            } else if (needed < ch) {
                moves += (int) (('Z' - ch) + (needed - 'A') + 1);
                System.out.println("else moves :  " + moves);
                System.out.println("i: " + i);
            } else {
                continue;
            }
            System.out.println(moves);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        String s = "RGBRGG";
        int ops = 0;
        int minOps = n;
        char[][] arrangements = { { 'R', 'G', 'B' }, { 'R', 'B', 'G' }, { 'G', 'R', 'B' }, { 'G', 'B', 'R' },
                { 'B', 'R', 'G' }, { 'B', 'G', 'R' } };
        for (char[] curr : arrangements) {
            ops = 0;
            for (int i = 0; i < n; i++) {
                char currPermutation = curr[i % 3];
                if (s.charAt(i) != currPermutation)
                    ops++;
            }
            minOps = Math.min(minOps, ops);
        }
        System.out.println(minOps);
    }
}
