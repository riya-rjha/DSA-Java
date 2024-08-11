import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SnakeInMatrix {

    public static int finalPositionOfSnake(int n, List<String> commands) {
        int arr[][] = new int[n][n];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = count;
                count++;
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        int ans = arr[0][0];
        int a = 0;
        int b = 0;

        for (int k = 0; k < commands.size(); k++) {
            String command = commands.get(k);
            if (command.equals("DOWN") && a + 1 < arr.length) {
                ans = arr[++a][b];
            } else if (command.equals("RIGHT") && b + 1 < arr[0].length) {
                ans = arr[a][++b];
            } else if (command.equals("UP") && a - 1 >= 0) {
                ans = arr[--a][b];
            } else if (command.equals("LEFT") && b - 1 >= 0) {
                ans = arr[a][--b];
            }
        }
        ans = arr[a][b];
        return ans;
    }

    public static void main(String[] args) {
        int n = 3;
        ArrayList<String> commands = new ArrayList<>(Arrays.asList("DOWN", "RIGHT", "UP"));
        System.out.println(finalPositionOfSnake(n, commands));
    }
}