import java.util.*;

public class Make_same {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            String s1 = sc.next();
            String s2 = sc.next();
            String s3 = sc.next();
            
            int[] zeroesCount = new int[3];
            int totZeroes = 0;
            
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) == '0') zeroesCount[0]++;
                if (s2.charAt(i) == '0') zeroesCount[1]++;
                if (s3.charAt(i) == '0') zeroesCount[2]++;
            }
            
            totZeroes = zeroesCount[0] + zeroesCount[1] + zeroesCount[2];
            
            if (totZeroes % n != 0) {
                System.out.println(-1);
                continue;
            }
            
            int minSwaps = totZeroes / n;
            
            if (minSwaps == 0 || minSwaps == 3) {
                System.out.println(0);
                continue;
            }
            
            int[] cnts = zeroesCount.clone();
            Arrays.sort(cnts);
            
            int res = 0;
            for (int i = 0; i < minSwaps; i++) {
                res += cnts[i];
            }
            
            int ans = minSwaps * n - res;
            System.out.println(ans);
        }
        
        sc.close();
    }
}