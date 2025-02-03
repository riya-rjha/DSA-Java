import java.util.*;

public class LC434 {
    static int countPartitions(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            leftSum = 0;
            rightSum = 0;
            if (i != n - 1) {
                for (int j = 0; j <= i; j++) {
                    // System.out.println("j1: " + j);
                    leftSum += nums[j];
                    // System.out.println("leftsum: " + leftSum);
                }
                for (int j = i + 1; j <= n - 1; j++) {
                    // System.out.println("j2: " + j);
                    rightSum += nums[j];
                    // System.out.println("rightSum: " + rightSum);
                }
                if (Math.abs(leftSum - rightSum) % 2 == 0)
                    // System.out.println("Count inc");
                    cnt++;
            }
        }
        return cnt;
    }

    static int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int[] mentions = new int[numberOfUsers];
        boolean[] isOnline = new boolean[numberOfUsers];
        Arrays.fill(isOnline, true);
        int[] timeStamps = new int[numberOfUsers];
        for (List<String> list : events) {
            int currTimeStamp = Integer.parseInt(list.get(1));
            for (int i = 0; i < numberOfUsers; i++) {
                if (!isOnline[i] && timeStamps[i] <= currTimeStamp) {
                    isOnline[i] = true;
                }
            }
            String typeOfMessage = list.get(0);
            String ids = list.get(2);
            if (typeOfMessage.equals("OFFLINE")) {
                int id = Integer.parseInt(ids);
                isOnline[id] = false;
                timeStamps[id] = currTimeStamp + 60;
            } else if (typeOfMessage.equals("MESSAGE")) {
                Set<Integer> set = new HashSet<>();
                if (ids.equals("ALL")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        set.add(i);
                    }
                } else if (ids.equals("HERE")) {
                    for (int i = 0; i < numberOfUsers; i++) {
                        if (isOnline[i]) {
                            set.add(i);
                        }
                    }
                } else {
                    String[] tokens = ids.split(" ");
                    for (String token : tokens) {
                        if (token.startsWith("id")) {
                            int id = Integer.parseInt(token.substring(2));
                            set.add(id);
                        }
                    }
                }
                for (int id : set) {
                    mentions[id]++;
                }
            }
        }
        return mentions;
    }

    public static void main(String[] args) {
        // int[] arr = {2,4,6,8};
        int[] arr = { 1, 3, 7, 8 };
        // int[] arr = { 10, 10, 3, 7, 6 };
        // int[] arr = { 1, 2, 2 };

        System.out.println(countPartitions(arr));

        List<List<String>> events = new ArrayList<>();
        List<String> event = Arrays.asList("MESSAGE", "10", "id1 id0");
        events.add(event);
        event = Arrays.asList("OFFLINE", "11", "0");
        events.add(event);
        event = Arrays.asList("MESSAGE", "71", "HERE");
        events.add(event);

        // List<List<String>> events = new ArrayList<>();
        // List<String> event = Arrays.asList("MESSAGE", "10", "id1 id0");
        // events.add(event);
        // event = Arrays.asList("OFFLINE", "11", "0");
        // events.add(event);
        // event = Arrays.asList("MESSAGE", "12", "ALL");
        // events.add(event);

        // List<List<String>> events = new ArrayList<>();
        // List<String> event = Arrays.asList("OFFLINE", "10", "0");
        // events.add(event);
        // event = Arrays.asList("MESSAGE", "12", "HERE");
        // events.add(event);

        int numberOfUsers = 2;
        System.out.println(Arrays.toString(countMentions(numberOfUsers, events)));

    }
}