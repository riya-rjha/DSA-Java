import java.util.Scanner;

public class SqOrNotBeautifulMatrix {

    public static void checkAns(int n, String s) {
        // count no of 1s
        int count_no_of_ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count_no_of_ones++;
            }
        }

        // check for n = 4
        // where all nos are 1

        if (count_no_of_ones == n) {
            if (n == 4) {
                System.out.println("YES");
            }
        } else {
            System.out.println("NO");
        }

        count_no_of_ones--;
        if (count_no_of_ones * count_no_of_ones == n) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int t = sc.nextInt();
            while (t-- != 0) {
                int n = sc.nextInt(); // no of 1's
                String s = sc.next();
                checkAns(n, s);
            }
        }
    }
}
