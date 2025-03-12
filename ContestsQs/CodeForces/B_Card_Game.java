import java.util.*;

public class B_Card_Game {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a1 = sc.nextInt();
            int a2 = sc.nextInt();
            int b1 = sc.nextInt();
            int b2 = sc.nextInt();
            int cnt = 0;
            if(a1 > b1){
                cnt++;
                if(a2 > b2) cnt++;
                else break;
            } 
            if(a1 > b2) {
                cnt++;
                if(a2 > b1) cnt++;
                else break;
            }
            if(cnt % 2 == 0) System.out.println(cnt);
            else System.out.println(0);
        }
        sc.close();
    }
}