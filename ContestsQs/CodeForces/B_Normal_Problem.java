package CodeForces;
import java.util.*;

public class B_Normal_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) == 'p') {
                    sb.append('q');
                }
                else if (a.charAt(i) == 'q') {
                    sb.append('p');
                } else {
                    sb.append(a.charAt(i));
                }
            }
            System.out.println(sb.reverse());
        }
        sc.close();
    }
}