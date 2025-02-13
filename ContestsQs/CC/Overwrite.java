import java.util.*;

public class Overwrite {
    static final long inf = 10000000000L;
    static final int mod = 1000000007;
    static Scanner sc = new Scanner(System.in);

    static void solve() {
        int n = sc.nextInt();
        int m = sc.nextInt();

        long[] a = new long[n];
        long[] b = new long[m];

        // Reading array a
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        // Reading array b
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLong();
        }

        // Fidxing minimum element and its index in array b
        int idx = -1;
        long mini = inf;
        for (int i = 0; i < m; i++) {
            if (b[i] < mini) {
                mini = b[i];
                idx = i;
            }
        }

        // Creating new vector nv with rotated elements
        ArrayList<Long> nv = new ArrayList<>();
        for (int i = idx; i < m; i++) {
            nv.add(b[i]);
        }
        for (int i = 0; i < idx; i++) {
            nv.add(b[i]);
        }

        int i = 0;
        boolean flag = false;

        while (i <= n - m) {
            // System.out.println("i: " + i);
            if (nv.get(0) < a[i]) {
                if (m == 1) {
                    a[i] = nv.get(0);
                    i++;
                } else {
                    flag = true;
                    while (i <= n - m) {
                        a[i++] = nv.get(0);
                    }
                    break;
                }
            } else {
                i++;
            }
        }

        if (m == 1) {
            for (i = 0; i < n; i++) {
                System.out.print(a[i] + " ");
            }
            System.out.println();
            return;
        }

        if (flag) {
            i = n - m;
            for (int j = 0; j < m; j++) {
                a[i + j] = nv.get(j);
            }
        } else if (a[n - m] == nv.get(0)) {
            i = n - m + 1;
            boolean checkFlag = false;
            for (int j = 1; j < m; j++) {
                if (nv.get(j) < a[i]) {
                    checkFlag = true;
                    break;
                } else if (a[i] < nv.get(j)) {
                    break;
                } else {
                    i++;
                }
            }
            if (checkFlag) {
                i = n - m;
                for (int j = 0; j < m; j++) {
                    a[i + j] = nv.get(j);
                }
            }
        }

        // Print final array
        for (i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        sc.close();
    }
}