import java.util.*;

public class C_XOR_and_Triangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            long x = sc.nextLong();
            // System.out.println(Arrays.toString(arr));
            // long m = x;
            // long ans = -1;
            // while(m > 3){
            // long y = m - 1;
            // long third = x ^ y;
            // // System.out.println("y: "+ y);
            // // System.out.println("third: " + third);
            // if((x + y) > third && (y + third) > x && (third + x) > y){
            // ans = y;
            // break;
            // }
            // m = m - 1;
            // }

            long y = Long.highestOneBit(x) - 1;
            long third = x ^ y;
            long ans = -1;
            if ((x + y) > third && (y + third) > x && (third + x) > y) {
                ans = y;
            }
            System.out.println(ans);
        }
        sc.close();
    }
}