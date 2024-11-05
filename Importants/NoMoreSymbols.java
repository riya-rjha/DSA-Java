import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class NoMoreSymbols {

    public static void reverseStack(Stack<String> stack) {
        Queue<String> queue = new LinkedList<>();
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
    }

    public static int getAns(String s, HashMap<String, Integer> nums, HashMap<String, String> ops) {
        String[] str = s.split(" ");
        Stack<Integer> numbers = new Stack<>();
        Stack<String> operations = new Stack<>();

        for (int i = str.length - 1; i >= 0; i--) {
            if (nums.containsKey(str[i])) {
                numbers.push(nums.get(str[i]));
            } else if (ops.containsKey(str[i])) {
                operations.push(ops.get(str[i]));
            } else if (str[i].contains("c")) {
                String[] newStr = str[i].split("c");
                int num = 0;
                for (int j = 0; j < newStr.length; j++) {
                    if (nums.containsKey(newStr[j])) {
                        num = num * 10 + nums.get(newStr[j]);
                    } else {
                        return Integer.MAX_VALUE; // Invalid word
                    }
                }
                numbers.push(num);
            } else {
                return Integer.MAX_VALUE; // Invalid word
            }
        }
        reverseStack(operations);
        // Evaluate the operations in the order they were added
        while (!operations.isEmpty() && numbers.size() >= 2) {
            int b = numbers.pop();
            int a = numbers.pop();
            String operand = operations.pop();
            switch (operand) {
                case "+":
                    numbers.push(a + b);
                    break;
                case "*":
                    numbers.push(a * b);
                    break;
                case "-":
                    numbers.push(b - a);
                    break;
                case "%":
                    numbers.push(a % b);
                    break;
                case "**":
                    numbers.push((int) Math.pow(a, b));
                    break;
                default:
                    return Integer.MAX_VALUE; // Invalid operation
            }
            System.out.println("Top: " + numbers.peek());
        }

        if (numbers.size() != 1) {
            return Integer.MIN_VALUE; // Incomplete expression
        }
        return numbers.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        HashMap<String, Integer> nums = new HashMap<>();
        nums.put("zero", 0);
        nums.put("one", 1);
        nums.put("two", 2);
        nums.put("three", 3);
        nums.put("four", 4);
        nums.put("five", 5);
        nums.put("six", 6);
        nums.put("seven", 7);
        nums.put("eight", 8);
        nums.put("nine", 9);

        HashMap<String, String> ops = new HashMap<>();
        ops.put("add", "+");
        ops.put("sub", "-");
        ops.put("mul", "*");
        ops.put("rem", "%");
        ops.put("pow", "**");

        int ans = getAns(str, nums, ops);

        if (ans == Integer.MAX_VALUE) {
            System.out.println("expression evaluation stopped invalid words present");
        } else if (ans == Integer.MIN_VALUE) {
            System.out.println("expression is not complete or invalid");
        } else {
            System.out.println(ans);
        }

        sc.close();
    }
}
