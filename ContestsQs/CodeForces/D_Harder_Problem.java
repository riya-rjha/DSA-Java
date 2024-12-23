import java.util.*;

public class D_Harder_Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n + 1];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                if (a[x] == 0) {
                    b[i] = x;
                    a[x] = 1;
                }
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (a[i] == 0) {
                    queue.add(i);
                }
            }
            for (int i = 0; i < n; i++) {
                if (b[i] == 0) {
                    b[i] = queue.poll();
                }
            }
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}