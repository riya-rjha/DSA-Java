import java.util.Stack;

public class StringBalancing {

    public int minSwaps(String s) {
        if (s == " ") {
            return 0;
        }
        int swaps = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[') {
                stack.push('[');
            } else {
                if (!stack.isEmpty()) {
                    // closing bracket found
                    stack.pop();
                } else {
                    swaps++;
                }
            }
        }
        return (swaps + 1) / 2; // for each increment of swap, two brackets become balanced
    }

    public static void main(String[] args) {
        String s = "]]][[[";
        StringBalancing ans = new StringBalancing();
        System.out.println(ans.minSwaps(s));
    }
}
