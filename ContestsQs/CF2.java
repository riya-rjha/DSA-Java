import java.util.*;

public class CF2 {

    public static int[] getRowColumn(int[] arr, int k) {
        int value = k - 2;

        // Brute Force (TLE)
        // for (int i = 0; i < arr.length; i++) {
        // for (int j = i + 1; j < arr.length; j++) {
        // if (arr[i] * arr[j] == val) {
        // return new int[] { arr[i], arr[j] };
        // }
        // }
        // }

        // Again TLE
        // List<Integer> lst = new ArrayList<>();
        // for (int i = 0; i < arr.length; i++) {
        // lst.add(arr[i]);
        // }
        // for (int i = 0; i < lst.size(); i++) {
        // int ans = val % lst.get(i);
        // int ans2 = val / lst.get(i);
        // if (ans == 0 && lst.contains(ans2)) {
        // if (lst.indexOf(ans2) != i) {
        // return new int[] { lst.get(i), ans2 };
        // }
        // }
        // }

        // Optimized
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            if (val > 1) {
                if (key * key == value) {
                    return new int[] { key, key };
                }
            }
            int ans = value % key;
            int ans2 = value / key;
            if (ans == 0 && hm.containsKey(ans2)) {
                return new int[] { key, ans2 };
            }
        }
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        // while (t-- > 0) {
        // int n = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < arr.length; i++) {
        // arr[i] = sc.nextInt();
        // }
        // Map<Integer, Integer> hm = new HashMap<>();
        // for (int i = 0; i < arr.length; i++) {
        // hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        // }
        // int sum = 0;
        // for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
        // int val = entry.getValue();
        // int count = val;
        // while (count > 1) {
        // sum += 1;
        // count = count - 2;
        // }
        // }
        // System.out.println(sum);
        // }

        int t = sc.nextInt();
        while (t-- > 0) {
            int k = sc.nextInt();
            int[] arr = new int[k];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            int[] ans = getRowColumn(arr, k);
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
        }

        sc.close();
    }
}