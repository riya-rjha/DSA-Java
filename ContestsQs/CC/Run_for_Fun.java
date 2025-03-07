import java.util.Scanner;

public class Run_for_Fun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int cnt = 0;
        if (x - y >= 0)
            cnt = 0;
        else {
            y = y - x;
            while (y > 0) {
                cnt++;
                y = y - x;
            }
        }
        System.out.println(cnt);
        sc.close();
    }
}