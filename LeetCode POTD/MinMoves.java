import java.util.Arrays;

public class MinMoves {

    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i = 0; i < students.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int seats[] = { 3, 1, 5 };
        int students[] = { 2, 7, 4 };
        System.out.println(minMovesToSeat(seats, students));
    }
}