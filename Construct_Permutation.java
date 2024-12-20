import java.util.*;

public class Construct_Permutation {

    public static boolean isValidPermutation(List<Integer> ans) {
        int sum = 0;
        for (int el : ans) {
            sum += el;
        }
        if (sum % (ans.size() + 1) == 0) {
            return false;
        }
        for (int i = 0; i < ans.size(); i++) {
            for (int j = i + 1; j < ans.size(); j++) {
                int curr = ans.get(i) + ans.get(j);
                if(curr % (ans.size() + 1) == 0){
                    return false;
                }
            }
        }return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            List<Integer> ans = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                ans.add(i);
                if (isValidPermutation(ans)) {
                    for (int el : ans) {
                        System.out.print(el + " ");
                    }
                    System.out.println();
                }
                ans = new ArrayList<>();
            }
        }
        sc.close();
    }
}