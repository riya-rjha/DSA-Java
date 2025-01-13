import java.util.Scanner;

public class LongestGoodArr {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- != 0) {
                long l = sc.nextInt();
                long r = sc.nextInt();
                long i = 0;
                long count = 1;
                while (l <= r) {
                    i++;
                    l = l + count;
                    count++;
                }
                System.out.println(i);
            }
        }
    }
}