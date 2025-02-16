public class PunishmentNumber {

    public static boolean sumOfDig(int idx, String sum, String number, String n, int len) {
        if (sum.equals(n)) {
            System.out.println("True");
            return true;
        }
        if (number.isEmpty()) {
            if (sum.equals(n)) {
                return true;
            } else {
                return false;
            }
        }

        char ch = number.charAt(idx);

        // Pick
        boolean pick = sumOfDig(idx + 1, sum + ch, number.substring(idx + 1), n, len);
        if (!pick) {
            return false;
        }

        // Not Pick
        boolean notPick = sumOfDig(idx + 1, sum, number.substring(idx + 1), n, len);
        if (!notPick) {
            return false;
        }

        return pick || notPick;
    }

    public static int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            String number = String.valueOf(i * i);
            if (sumOfDig(0, "", number, String.valueOf(i), number.length())) {
                System.out.println("Yes");
                sum += i * i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // int n = 10;
        // System.out.println(punishmentNumber(n));
        System.out.println(sumOfDig(0, "", "81", "9", 2));
    }
}