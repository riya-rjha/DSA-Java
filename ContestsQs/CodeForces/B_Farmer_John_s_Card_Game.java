import java.util.*;

public class B_Farmer_John_s_Card_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            List<Integer> ans = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            boolean flag = true;
            for (int j = 0; j < m; j++) {
                int i = 0;
                while (i < n) {
                    if (arr[i][j] > stack.peek()) {
                        stack.push(arr[i][j]);
                    } else {
                        flag = false;
                        break;
                    }
                    ;
                    i++;
                }
                if (!flag) {
                    ans.add(i + 1);
                }
            }
            if (ans.size() == 0) {
                System.out.println(-1);
            } else {
                for (int i = 0; i < ans.size(); i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }
}