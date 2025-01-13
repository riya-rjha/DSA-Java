import java.util.Stack;

class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            stack.push(ch);
            System.out.println("Peeked val: " + stack.peek());
            char top = stack.peek();
            if (top == 'B') {
                stack.pop();
                top = stack.peek();
                System.out.println("Top BA: " + top);
                if (top == 'A') {
                    stack.pop();
                } else {
                    stack.push('B');
                }
            }
            if (top == 'D') {
                stack.pop();
                top = stack.peek();
                System.out.println("Top CD: " + top);
                if (top == 'C') {
                    stack.pop();
                } else {
                    stack.push('D');
                }
            }
        }
        System.out.println(stack);
        return stack.size();

    }
}

public class MinStringAfterRemoval {
    public static void main(String[] args) {
        String s = "ABFCACDB";
        Solution ans = new Solution();
        System.out.println(ans.minLength(s));
    }
}