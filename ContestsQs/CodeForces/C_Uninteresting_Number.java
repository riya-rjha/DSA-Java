package CodeForces;
import java.util.*;

public class C_Uninteresting_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String num = sc.next();
            int[] arr = new int[num.length()];
            int k = 0;
            for (int i = 0; i < num.length(); i++) {
                int curr = Integer.parseInt(String.valueOf(num.charAt(i)));
                arr[k] = curr;
                k++;
            }
            System.out.println(Arrays.toString(arr));
            int sum = 0;
            for (int element : arr) {
                sum += element;
            }
            if (sum % 9 == 0)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
        sc.close();
    }
}