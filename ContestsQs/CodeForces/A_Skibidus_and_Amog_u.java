import java.util.*;

public class A_Skibidus_and_Amog_u {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String w = sc.next();
            int idx = w.lastIndexOf("us");
            System.out.println(w.substring(0, idx) + "i");
        }
        sc.close();
    }
}