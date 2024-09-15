import java.util.Stack;

public class LongestValidParentheses {

    static int maxLength(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        count.push(-1);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
                count.push(i);
            }
            else if(s.charAt(i) == ')' && !stack.isEmpty()){
                stack.pop();
                count.pop();
                ans = Math.max(ans, i - count.peek());
            }
            else{
                count.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "((()";
        System.out.println(maxLength(str));
    }
}
