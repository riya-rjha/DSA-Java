import java.util.ArrayList;
import java.util.List;

public class MaxDistance {

    public static int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> list = arrays.get(i);
            int currentMin = list.get(0);
            int currentMax = list.get(list.size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(max - currentMin));
            maxDistance = Math.max(maxDistance, Math.abs(currentMax - min));

            min = Math.min(min, currentMin);
            max = Math.max(max, currentMax);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        int[][] array2D = {
                { 1, 4 },
                { 0, 5 } };

        // Create the List of Lists and populate it
        List<List<Integer>> arrays = new ArrayList<>();
        for (int i = 0; i < array2D.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < array2D[i].length; j++) {
                list.add(array2D[i][j]);
            }
            arrays.add(list);
        }
        System.out.println(maxDistance(arrays));
    }
}
