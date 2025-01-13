import java.util.HashSet;

public class WalkingRobotSimulation {

    // Prime no makes calculations easy
    private static final int hashMultiplier = 60013;

    private int hashingFunc(int x, int y) {
        // creates a hashed ID consisting of representation of both x & y
        return x + y * hashMultiplier;
    }

    /*
     * North - 0
     * East - 1
     * South - 2
     * West - 3
     */

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        HashSet<Integer> obstacleSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            // Each obstacle array in obstacles has 2 numbers at indices 0 and 1
            // Add in the form of Hashed Function
            obstacleSet.add(hashingFunc(obstacle[0], obstacle[1]));
        }

        int maxDist = 0;
        int posX = 0;
        int posY = 0;
        int currentDirection = 0;
        int currPos[] = { 0, 0 };

        for (int command : commands) {
            // Turn Left
            if (command == -2) {
                currentDirection = (currentDirection + 3) % 4;
            }

            // Turn Right
            if (command == -1) {
                currentDirection = (currentDirection + 1) % 4; // to revolve only around 1, 2, 3 : we have used mod 4
            }

            int[] currDirArr = directions[currentDirection];
            for (int i = 0; i < command; i++) {
                posX = currPos[0] + currDirArr[0];
                posY = currPos[1] + currDirArr[1];

                if (obstacleSet.contains(hashingFunc(posX, posY))) {
                    break;
                }

                currPos[0] = posX;
                currPos[1] = posY;
            }

            maxDist = Math.max(maxDist, currPos[0] * currPos[0] + currPos[1] * currPos[1]);
        }
        return maxDist;
    }

    public static void main(String[] args) {
        int[] commands = { 4, -1, 4, -2, 4 };
        int[][] obstacle = { { 2, 4 } };
        WalkingRobotSimulation s = new WalkingRobotSimulation();
        System.out.println(s.robotSim(commands, obstacle));
    }
}