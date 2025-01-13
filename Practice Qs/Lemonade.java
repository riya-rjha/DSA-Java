public class Lemonade {
    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five_dollars = 0, ten_dollars = 0;

            for (int x : bills) {
                if (x == 5) {
                    five_dollars++;
                } else if (x == 10) {
                    if (five_dollars > 0) {
                        five_dollars--;
                        ten_dollars++;
                    } else {
                        return false;
                    }
                } else {
                    if (five_dollars > 0 && ten_dollars > 0) {
                        five_dollars--;
                        ten_dollars--;
                    } else if (five_dollars > 2) {
                        five_dollars -= 3;
                    } else {
                        return false;
                    }
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        int bills[] = { 5, 5, 5, 10, 20 };
        Solution s = new Solution();
        System.out.println(s.lemonadeChange(bills));
    }
}