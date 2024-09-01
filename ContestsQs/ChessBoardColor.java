import java.util.HashMap;

public class ChessBoardColor {

    char[][] chessBoard = new char[8][8];

    HashMap<Character, Integer> hm = new HashMap<>();

    private int[] getIndex(String str) {
        char ch = str.charAt(0);
        int n1 = str.charAt(1) - '0' - 1;
        int n2 = hm.get(ch);
        return new int[] { n1, n2 };
    }

    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        for (int i = 0; i < chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.length; j++) {
                if ((i + j) % 2 == 0) {
                    chessBoard[i][j] = 'W';
                } else {
                    chessBoard[i][j] = 'B';
                }
            }
        }
        int count = 0;
        for (char i = 'a'; i <= 'h'; i++) {
            hm.put(i, count);
            count++;
        }
        int index1[] = getIndex(coordinate1);
        int index2[] = getIndex(coordinate2);
        char val1 = chessBoard[index1[0]][index1[1]];
        char val2 = chessBoard[index2[0]][index2[1]];

        if (val1 == val2) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String coordinate1 = "a1", coordinate2 = "h3";
        ChessBoardColor s = new ChessBoardColor();
        System.out.println(s.checkTwoChessboards(coordinate1, coordinate2));
    }
}