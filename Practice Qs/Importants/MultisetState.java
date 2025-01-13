import java.util.ArrayList;
import java.util.Scanner;

public class MultisetState {

    public static int[] finalArr(int arr[], int k) {

        ArrayList<Integer> lst = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            lst.add(arr[i]);
        }

        while (k-- > 0) {
            int X = lst.get(0);
            int Y = lst.get(lst.size() - 1);
            lst.remove(0);
            lst.remove(lst.size() - 1);
            lst.add(X + Y);
        }

        int ans[] = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int ans[] = finalArr(arr, k);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] +" ");
            }
        }
        sc.close();
    }
}
