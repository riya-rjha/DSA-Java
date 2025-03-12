import java.util.*;

public class A_Draw_a_Square {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int l = Math.abs(sc.nextInt());
            int r = Math.abs(sc.nextInt());
            int d = Math.abs(sc.nextInt());
            int u = Math.abs(sc.nextInt());
            if(l == r && r == d && d == u && u == l) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}