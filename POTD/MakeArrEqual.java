import java.util.Scanner;

public class MakeArrEqual {

    public static String makeArrEq(int n, int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] + arr[j] == arr[i]) {
                    arr[i] = arr[i] + arr[j];
                }
            }
        }
        String ans = "";
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                ans = "YES";
            } else {
                ans = "NO";
            }
        }
        return ans;
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(makeArrEq(n, arr));
            t--;
        }
    }
}
