import java.util.*;

public class B_Journey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while (t-- > 0) {
            long n = sc.nextLong();
            long a = sc.nextLong();
            long b = sc.nextLong();
            long c = sc.nextLong();
            long tot = a + b + c;
            long days = n / tot;
            // System.out.println("Days: " + days);
            long remainingDays = n % tot;
            // System.out.println("Days remaining: " + remainingDays);
            long totDays = days * 3;
            long curr = 0;
            if (remainingDays > 0) {
                curr += a;
                if (curr >= remainingDays) {
                    totDays++;
                    // System.out.println("Tot 1: " + totDays);
                } else {
                    curr += b;
                    if (curr >= remainingDays) {
                        totDays += 2;
                    } else {
                        totDays += 3;
                    }
                    // System.out.println("Tot 2: " + totDays);
                }
            }
            System.out.println(totDays);
        }
        sc.close();
    }
}