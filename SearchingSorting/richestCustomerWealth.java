public class richestCustomerWealth {

    public int maximumWealth(int[][] accounts) {
        int max = Integer.MIN_VALUE;
        for (int[] arr : accounts) {
            int sum = 0;
            for (int el : arr) {
                sum += el;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] accounts = { { 1, 5 }, { 7, 3 }, { 3, 5 } };
        richestCustomerWealth ans = new richestCustomerWealth();
        System.out.println(ans.maximumWealth(accounts));
    }
}
