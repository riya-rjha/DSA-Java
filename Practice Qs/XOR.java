import java.util.Arrays;

public class XOR {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] prefixArr = new int[n + 1];
        int[] ans = new int[queries.length];
        prefixArr[0] = 0;
        for (int i = 1; i < prefixArr.length; i++) {
            prefixArr[i] = arr[i - 1] ^ prefixArr[i - 1];
        }
        int j = 0;
        for (int el[] : queries) {
            int first = prefixArr[el[0]];
            int second = prefixArr[el[1] + 1];
            int answer = first ^ second;
            ans[j] = answer;
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        XOR ans = new XOR();
        System.out.println(Arrays.toString(ans.xorQueries(arr, queries)));
    }
}