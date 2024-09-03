import java.util.Scanner;

public class Minimize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- != 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int arr[] = new int[b - a + 1];
            int counter = b;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = counter;
                counter--;
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < arr.length; i++) {
                int ans = (arr[i] - a) + (b - arr[i]);
                min = Math.min(min, ans);
            }
            System.out.println(min);
        }
    }
}