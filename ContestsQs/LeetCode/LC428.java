import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC428 {
    static int buttonWithLongestTime(int[][] events) {
        int maxDiff = events[0][1];
        int idx = events[0][0];
        for (int i = 1; i < events.length; i++) {
            int t2 = events[i][1];
            int t1 = events[i - 1][1];
            int diff = t2 - t1;
            if (diff > maxDiff) {
                maxDiff = diff;
                idx = events[i][0];
            } else if (diff == maxDiff) {
                idx = Math.min(idx, events[i][0]);
            }
        }
        return idx;
    }

    static Map<String, Map<String, Double>> calculateAmount(List<List<String>> pairs, List<Double> rates) {
        Map<String, Map<String, Double>> amounts = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            var pair = pairs.get(i);
            String firstDay = pair.get(0), secondDay = pair.get(1);
            double currPrice = rates.get(i);
            amounts.putIfAbsent(firstDay, new HashMap<>());
            amounts.putIfAbsent(secondDay, new HashMap<>());
            amounts.get(firstDay).put(secondDay, currPrice);
            amounts.get(secondDay).put(firstDay, 1.0 / currPrice);
        }
        return amounts;
    }

    static Map<String, Map<String, Double>> findShortestPath(Map<String, Map<String, Double>> amounts) {
        List<String> allAmountsVals = new ArrayList<>(amounts.keySet());
        Map<String, Map<String, Double>> distance = new HashMap<>();

        for (String entry : allAmountsVals) {
            distance.putIfAbsent(entry, new HashMap<>());
            for (String secondDay : allAmountsVals) {
                if (entry.equals(secondDay)) {
                    distance.get(entry).put(secondDay, 1.0);
                } else if (amounts.get(entry).containsKey(secondDay)) {
                    distance.get(entry).put(secondDay, amounts.get(entry).get(secondDay));
                } else {
                    distance.get(entry).put(secondDay, 0.0);
                }
            }
        }

        for (String i : allAmountsVals) {
            for (String j : allAmountsVals) {
                for (String k : allAmountsVals) {
                    double newAmount = distance.get(j).get(i) * distance.get(i).get(k);
                    distance.get(j).put(k, Math.max(distance.get(j).get(k), newAmount));
                }
            }
        }

        return distance;
    }

    static double max(String init, List<List<String>> pairs1, List<Double> rates1, List<List<String>> pairs2,
            List<Double> rates2) {
        Map<String, Map<String, Double>> amounts1 = calculateAmount(pairs1, rates1);
        Map<String, Map<String, Double>> amounts2 = calculateAmount(pairs2, rates2);

        Map<String, Map<String, Double>> day1Rates = findShortestPath(amounts1);
        Map<String, Map<String, Double>> ratesDay2 = findShortestPath(amounts2);

        Map<String, Double> ratesDay1 = new HashMap<>();
        for (Map.Entry<String, Double> curr : day1Rates.get(init).entrySet()) {
            ratesDay1.put(curr.getKey(), curr.getValue());
        }
        ratesDay1.put(init, 1.0);

        double max = 1.0;
        for (Map.Entry<String, Double> entry : ratesDay1.entrySet()) {
            String amountVal = entry.getKey();
            if (ratesDay2.containsKey(amountVal)) {
                double amount = entry.getValue() * ratesDay2.get(amountVal).get(init);
                max = Math.max(max, amount);
            }
        }
        return max;
    }

    static double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1,
            List<List<String>> pairs2, double[] rates2) {
        List<Double> rateList1 = new ArrayList<>();
        List<Double> rateList2 = new ArrayList<>();

        for (double rate : rates1)
            rateList1.add(rate);
        for (double rate : rates2)
            rateList2.add(rate);

        return max(initialCurrency, pairs1, rateList1, pairs2, rateList2);
    }

    public static void main(String[] args) {
        // int[][] events = { { 10, 5 }, { 1, 7 } };
        // System.out.println(buttonWithLongestTime(events));

        String initialCurrency = "EUR";
        List<List<String>> pairs1 = List.of(List.of("EUR", "USD"), List.of("USD", "JPY"));
        double[] rates1 = {2.0, 3.0};
        List<List<String>> pairs2 = List.of(List.of("JPY", "USD"), List.of("USD", "CHF"), List.of("CHF", "EUR"));
        double[] rates2 = {4.0, 5.0, 6.0};
        System.out.println(maxAmount(initialCurrency, pairs1, rates1, pairs2, rates2));

    }
}