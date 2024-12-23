import java.util.*;

public class C_Preparing_for_the_Exam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            List<Integer> notPresentQList = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                notPresentQList.add(sc.nextInt());
            }
            List<Integer> knownQs = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                knownQs.add(sc.nextInt());
            }
            List<Integer> lst = new ArrayList<>();
            List<Integer> ans = new ArrayList<>(lst);
            for (int i = 1; i <= n; i++) {
                lst.add(i);
            }
            String output = "";
            for (int i = 0; i < notPresentQList.size(); i++) {
                ans = new ArrayList<>(lst);
                int notKnownQs = notPresentQList.get(i);
                ans.remove(Integer.valueOf(notKnownQs));
                boolean isPass = true;
                for (int j = 0; j < ans.size(); j++) {
                    if (!knownQs.contains(ans.get(j))) {
                        isPass = false;
                        break;
                    }
                }
                if (isPass) {
                    output += '1';
                } else {
                    output += '0';
                }
            }
            System.out.println(output);
        }
        sc.close();
    }
}