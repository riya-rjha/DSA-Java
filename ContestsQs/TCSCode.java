import java.util.*;

public class TCSCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lst.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            lst.get(a).add(b);
            lst.get(b).add(a);
        }

        int k = sc.nextInt();
        if (k <= n) {
            System.out.println(1);
        }

        boolean[] isWork = new boolean[n];
        Arrays.fill(isWork, true);
        int dayCount = 1;
        int restored = n;

        while (restored < k) {
            boolean[] nextDay = new boolean[n];
            int todayWork = 0;

            for (int i = 0; i < n; i++) {
                int wfoFriends = 0;
                for (int friend : lst.get(i)) {
                    if (isWork[friend]) {
                        wfoFriends++;
                    }
                }
                if (isWork[i] && wfoFriends == 3) {
                    nextDay[i] = true;
                } else if (!isWork[i] && wfoFriends < 3) {
                    nextDay[i] = true;
                } else {
                    nextDay[i] = false;
                }
                if (nextDay[i]) {
                    todayWork++;
                }
            }

            restored += todayWork;
            isWork = nextDay;
            dayCount++;
        }

        System.out.println(dayCount);
        sc.close();
    }
}
