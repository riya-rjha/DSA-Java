import java.util.Scanner;

public class ElevenHundred {

    public static String returnAns(int i, int v, char[] arr) {
        if (arr.length < 4) {
            return "NO";
        }
        char new_v = '0';
        if (v == 1) {
            new_v = '1';
        }
        arr[i - 1] = new_v;
        for (int j = Math.max(0, i - 4); j <= Math.min(arr.length - 4, i - 1); j++) {
            if (arr[j] == '1' && arr[j + 1] == '1' && arr[j + 2] == '0' && arr[j + 3] == '0') {
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            char[] arr = s.toCharArray();
            int q = sc.nextInt();
            while (q-- > 0) {
                int i = sc.nextInt();
                int v = sc.nextInt();
                System.out.println(returnAns(i, v, arr));
            }
        }
        sc.close();
    }
}
