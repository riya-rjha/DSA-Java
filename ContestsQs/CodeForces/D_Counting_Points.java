import java.util.*;

public class D_Counting_Points {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] circles = new int[n][2];

            // Centre of circles
            for (int i = 0; i < n; i++) {
                circles[i][0] = sc.nextInt();
            }

            // Radii of circles
            for (int i = 0; i < n; i++) {
                circles[i][1] = sc.nextInt();
            }

            
        }
        sc.close();
    }
}