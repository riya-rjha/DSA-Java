import java.util.*;

public class Parity {

    public static String answerParity(int b, int k, int[] arr) {
        // double sum = 0;
        // for (int i = 0; i < arr.length; i++) {
        // sum += arr[i] * Math.pow(b, k - 1);
        // }
        // if (sum % 2 == 0) {
        // return "even";
        // }
        // return "odd";

        if (b % 2 == 0) {
            if (arr[k - 1] % 2 == 0) {
                return "even";
            } else {
                return "odd";
            }
        } else {
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += arr[i];
            }
            if (sum % 2 == 0) {
                return "even";
            } else {
                return "odd";
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(answerParity(b, k, arr));
        sc.close();
    }
}
