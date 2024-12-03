import java.util.*;

public class TCSCode2 {

    public static void findPatternSum(List<String> numSegs, List<String> inpSegs) {
        Map<Integer, String> patterns = new HashMap<>();
        for (int num = 0; num < 10; num++) {
            StringBuilder pattern = new StringBuilder();
            for (int row = 0; row < numSegs.size(); row++) {
                pattern.append(numSegs.get(row).substring(num * 3, (num + 1) * 3));
            }
            patterns.put(num, pattern.toString());
        }

        List<List<Integer>> numbers = new ArrayList<>();
        int segments = inpSegs.get(0).length() / 3;

        for (int i = 0; i < segments; i++) {
            StringBuilder seg = new StringBuilder();
            for (int row = 0; row < inpSegs.size(); row++) {
                seg.append(inpSegs.get(row).substring(i * 3, (i + 1) * 3));
            }

            List<Integer> matches = new ArrayList<>();
            for (Map.Entry<Integer, String> entry : patterns.entrySet()) {
                int diff = 0;
                String pattern = entry.getValue();
                for (int j = 0; j < seg.length(); j++) {
                    if (seg.charAt(j) != pattern.charAt(j)) {
                        diff++;
                    }
                }
                if (diff <= 1) {
                    matches.add(entry.getKey());
                }
            }

            if (matches.isEmpty()) {
                System.out.print("Invalid");
                return;
            }
            numbers.add(matches);
        }

        int totalSum = 0;
        List<List<Integer>> result = new ArrayList<>();
        generateCombinations(numbers, 0, new ArrayList<>(), result);

        for (int i = 0; i < result.size(); i++) {
            StringBuilder number = new StringBuilder();
            for (int j = 0; j < result.get(i).size(); j++) {
                number.append(result.get(i).get(j));
            }
            totalSum += Integer.parseInt(number.toString());
        }

        System.out.print(totalSum);
    }

    private static void generateCombinations(List<List<Integer>> numbers, int index, List<Integer> currentCombo,
            List<List<Integer>> result) {
        if (index == numbers.size()) {
            result.add(new ArrayList<>(currentCombo));
            return;
        }

        for (int i = 0; i < numbers.get(index).size(); i++) {
            currentCombo.add(numbers.get(index).get(i));
            generateCombinations(numbers, index + 1, currentCombo, result);
            currentCombo.remove(currentCombo.size() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> numSegs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numSegs.add(sc.nextLine().strip());
        }

        List<String> inpSegs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            inpSegs.add(sc.nextLine().strip());
        }

        findPatternSum(numSegs, inpSegs);

        sc.close();
    }
}
