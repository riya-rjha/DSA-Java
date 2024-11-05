import java.util.Scanner;

public class FreyaFrog {

    public static int returnMoves(int x, int y, int k) {
        int moves = 0;
        int travelledX = 0;
        int travelledY = 0;

        while (travelledX < x || travelledY < y) {
            if (moves % 2 == 0) {
                int pos1 = Math.min(k, x - travelledX);
                travelledX += pos1;
            } else {
                int pos2 = Math.min(k, y - travelledY);
                travelledY += pos2;
            }
            moves++;
        }
        return moves;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- != 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int k = sc.nextInt();
                System.out.println(returnMoves(x, y, k));
            }
        }
    }
}
