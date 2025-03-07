import java.util.Scanner;

public class Clothing_Store {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int[] avbShirts = new int[3];
            int[] demandShirts = new int[3];

            for (int i = 0; i < 3; i++) {
                avbShirts[i] = sc.nextInt();
            }

            for (int i = 0; i < 3; i++) {
                demandShirts[i] = sc.nextInt();
            }

            int cnt = 0;
            int i = 0;
            while (i < 3) {
                int buyShirt = Math.min(avbShirts[i], demandShirts[i]);
                cnt += buyShirt;
                demandShirts[i] -= buyShirt;
                avbShirts[i] -= buyShirt;
                i++;
            }

            if (demandShirts[1] > 0 && avbShirts[2] > 0) {
                int XLtoL = Math.min(avbShirts[2], demandShirts[1]);
                cnt += XLtoL;
                demandShirts[1] -= XLtoL;
            }

            if (demandShirts[0] > 0 && avbShirts[2] > 0) {
                int LtoSmall = Math.min(avbShirts[2], demandShirts[0]);
                cnt += LtoSmall;
                demandShirts[0] -= LtoSmall;
            }

            if (demandShirts[0] > 0 && avbShirts[1] > 0) {
                int LtoSmall = Math.min(avbShirts[1], demandShirts[0]);
                cnt += LtoSmall;
                demandShirts[0] -= LtoSmall;
            }

            System.out.println(cnt);
        }
        sc.close();
    }
}