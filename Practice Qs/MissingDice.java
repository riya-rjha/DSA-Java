import java.util.Arrays;

public class MissingDice {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for (int i = 0; i < rolls.length; i++) {
            sum += rolls[i];
        }
        int remainingSum = mean * (rolls.length + n) - sum;
        if (remainingSum < n || remainingSum > 6 * n) {
            return new int[] {};
        }

        int distributedSum = remainingSum / n;
        int remainingSumToBeDistributed = remainingSum % n;

        int[] temp = new int[n];

        Arrays.fill(temp, distributedSum);

        for (int i = 0; i < remainingSumToBeDistributed; i++) {
            temp[i]++;
        }

        return temp;

    }

    public static void main(String[] args) {
        int[] rolls = { 1, 5, 6 };
        int mean = 3;
        int n = 4;
        MissingDice s = new MissingDice();
        System.out.println(Arrays.toString(s.missingRolls(rolls, mean, n)));
    }
}
